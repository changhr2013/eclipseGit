package com.dcode.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hnxurui.TranscodingServiceStub;
import org.hnxurui.TranscodingServiceStub.ArrayOfStreamstat;
import org.hnxurui.TranscodingServiceStub.CloseSingleJFmpeg;
import org.hnxurui.TranscodingServiceStub.GetRunningCount;
import org.hnxurui.TranscodingServiceStub.GetRunningList;
import org.hnxurui.TranscodingServiceStub.OpenSingleJFmpeg;
import org.hnxurui.TranscodingServiceStub.Streamstat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dcode.enums.ServiceUrlEnum;
import com.dcode.service.TranscodingService;
@Service
@Component("TranscodingServiceImpl")
public class TranscodingServiceImpl implements TranscodingService {
	//正在运行的服务缓存列表
	protected static Map<String, Streamstat> runningMap = new HashMap<>();
	
	protected static List<TranscodingServiceStub> stubList = GetServiceStubList();
	
	private final static Logger logger = LoggerFactory.getLogger(TranscodingServiceImpl.class);
	
	//获取TranscodingService客户端实例列表
	public static List<TranscodingServiceStub> GetServiceStubList() {
		try{
			List<TranscodingServiceStub> stubList = new ArrayList<TranscodingServiceStub>();
			for (ServiceUrlEnum urlEnum : ServiceUrlEnum.values()) {
				stubList.add(new TranscodingServiceStub(urlEnum.getUrl()));
			}
			//stubList.add(new TranscodingServiceStub(ServiceUrlEnum.ONE_SERVER.getUrl()));
			//stubList.add(new TranscodingServiceStub(ServiceUrlEnum.TWO_SERVER.getUrl()));
			//stubList.add(new TranscodingServiceStub(ServiceUrlEnum.THREE_SERVER.getUrl()));
			
			for (TranscodingServiceStub stub : stubList) {
				stub._getServiceClient().getOptions().setProperty(
						org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
			}
			return stubList;
			
		}catch(Exception e){
			logger.error("初始化远程WebService出错:\r\n"+e.getMessage());
		}
		return null;
	}
	
	//查询运行服务的数量，选择运行最少数量的服务的服务器来开启新的转换服务
	public synchronized Streamstat OpenOneJfmpeg(String password,String rtspUrl,String rtspUser,String rtspPsd) {
		
		//如果服务已经在运行，就从缓存中拿出相关信息返回
		if(runningMap.containsKey(rtspUrl)) {
			return runningMap.get(rtspUrl);
		}
		
		//实例化服务运行数量查询
		GetRunningCount runningCount = new GetRunningCount();
		
		//list用来存储运行服务数量查询的结果列表
		List<Integer> countList = new ArrayList<Integer>();
		
		//实例化启动一个流转换服务并传入运行参数
		OpenSingleJFmpeg openJFmpeg = new OpenSingleJFmpeg();
		openJFmpeg.setPassword(password);
		openJFmpeg.setRtspUrl(rtspUrl);
		openJFmpeg.setRtspUser(rtspUser);
		openJFmpeg.setRtspPsd(rtspPsd);
		
		try {
			//遍历服务查询，将结果写入数量查询结果list
			for (TranscodingServiceStub stub : stubList) {
				countList.add(stub.getRunningCount(runningCount).getGetRunningCountResult());
			}
			
			//寻找到服务启动数量最低的服务器，开启新的转换服务
			int index = countList.indexOf(Collections.min(countList));
			Streamstat streamstat = stubList.get(index).openSingleJFmpeg(openJFmpeg).getOpenSingleJFmpegResult();
			
			//将运行的服务信息存入缓存
			runningMap.put(streamstat.getRtspUrl(), streamstat);
			return streamstat;
			
		} catch (RemoteException remoteE) {
			logger.error("开启远程服务请求出错:\r\n"+remoteE.getMessage());
		}
		return null;
	}
	
	//查询缓存中的服务，找到对应的rtspUrl的信息，请求相应的服务器关闭转换服务，对应的更新缓存
	public synchronized Streamstat CloseOneJfmpeg(String rtspUrl) {
		//如果定时任务已经自动将流关闭，就返回null
		if(!runningMap.containsKey(rtspUrl)) {
			return null;
		}
		//获取缓存中要关闭服务的相关
		Streamstat streamstat = runningMap.get(rtspUrl);
		String runningServerIp = streamstat.getServerIp();
		
		//遍历查找
		for (int index=0;index<ServiceUrlEnum.values().length;index++) {
			try {
				//获取服务对应的host
				String host = ServiceUrlEnum.values()[index].getHost();
				
				//实例化关闭转码服务
				CloseSingleJFmpeg closeJfmpeg = new CloseSingleJFmpeg();
				closeJfmpeg.setRtspUrl(rtspUrl);
				
				if(host.equals(runningServerIp)) {
					//调用相应的WebService关闭转码服务
					Streamstat cStreamstat = stubList.get(index).closeSingleJFmpeg(closeJfmpeg).getCloseSingleJFmpegResult();
					//更新缓存
					runningMap.remove(rtspUrl);
					return cStreamstat;
				}
			} catch (RemoteException remoteE) {
				logger.error("关闭远程服务请求出错:\r\n"+remoteE.getMessage());
			}
		}
		return null;
	
	}
	
	//获取所有的服务器运行的服务列表
	public List<Streamstat> GetServerRunningList(){
		List<Streamstat> streamstatList = new ArrayList<Streamstat>();
		//实例化获取运行的服务列表
		GetRunningList runningList = new GetRunningList();
		try {
			//获取各个服务器运行的服务列表
			for (TranscodingServiceStub stub : stubList) {
				ArrayOfStreamstat arrayOfStreamstat = stub.getRunningList(runningList).getGetRunningListResult();
				Streamstat[] streamstatsArr = arrayOfStreamstat.getStreamstat();
				if(streamstatsArr!=null) {
					for (Streamstat streamstat : streamstatsArr) {
						streamstatList.add(streamstat);
						runningMap.put(streamstat.getRtspUrl(), streamstat);
					}
				}
			}
			return streamstatList;
		} catch (RemoteException remoteE) {
			logger.error("获取远程运行服务列表出错:\r\n"+remoteE.getMessage());
		}
		return streamstatList;
	}
	
	//初始化任务，项目重启时请求远程节点恢复Running Cache信息
	@PostConstruct
	public void RecoverRunningCache() {
		//实例化获取运行的服务列表
		GetRunningList runningList = new GetRunningList();
		try {
			//获取各个服务器运行的服务列表
			for (TranscodingServiceStub stub : stubList) {
				ArrayOfStreamstat arrayOfStreamstat = stub.getRunningList(runningList).getGetRunningListResult();
				Streamstat[] streamstatsArr = arrayOfStreamstat.getStreamstat();
				if(streamstatsArr!=null) {
					for (Streamstat streamstat : streamstatsArr) {
						runningMap.put(streamstat.getRtspUrl(), streamstat);
					}
				}
			}
		} catch (RemoteException remoteE) {
			logger.error("获取远程运行服务列表出错:\r\n"+remoteE.getMessage());
		}
	}
	
	//获取缓存中运行的服务列表
	public List<Streamstat> GetCacheRunningList(){
		return new ArrayList<Streamstat>(runningMap.values());
	}
	
}
