package com.dcode.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tempuri.MyWebServiceStub;
import org.tempuri.MyWebServiceStub.ArrayOfJFmpeg;
import org.tempuri.MyWebServiceStub.CloseSingleJFmpeg;
import org.tempuri.MyWebServiceStub.GetCurrentJFmpegList;
import org.tempuri.MyWebServiceStub.GetServerIpAddress;
import org.tempuri.MyWebServiceStub.JFmpeg;
import org.tempuri.MyWebServiceStub.KillAllJFmpegStream;
import org.tempuri.MyWebServiceStub.OpenSingleJFmpeg;
import org.tempuri.MyWebServiceStub.ResetJFmpeg;
import org.tempuri.MyWebServiceStub.RunAllConfigJFmpeg;

import com.dcode.service.JfmpegWebService;

@Component("JfmpegWebServiceImpl")
public class JfmpegWebServiceImpl implements JfmpegWebService {

	/**
	 * 初始化加载MyService对象
	 * */
	public static MyWebServiceStub GetServiceStub(){
		try{
			MyWebServiceStub stub = new MyWebServiceStub();
			stub._getServiceClient().getOptions().setProperty(  
	                org.apache.axis2.transport.http.HTTPConstants.CHUNKED,  
	                Boolean.FALSE); 
			return stub;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
}

	/**
	 * 得到当前服务运行的服务器ip地址
	 * */
	public String GetWebServerIp() {
		//得到服务器的ip地址
		GetServerIpAddress serverIp=new GetServerIpAddress();
		try {
			return GetServiceStub().getServerIpAddress(serverIp).getGetServerIpAddressResult();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 重新初始化服务器视频流环境
	 * */
	public String Reset() {
		ResetJFmpeg resetJFmpeg=new ResetJFmpeg();
		try {
			return GetServiceStub().resetJFmpeg(resetJFmpeg).getResetJFmpegResult();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "Failed to Reset Environment!";
	}
	
	/**
	 * 获取当前的配置视频流信息
	 * */
	public List<JFmpeg> GetCurWebServiceList() {
		//打印当前的视频流信息
		GetCurrentJFmpegList curJFmepgs=new GetCurrentJFmpegList();
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg arrayOfJFmpeg = GetServiceStub().getCurrentJFmpegList(curJFmepgs).getGetCurrentJFmpegListResult();
			JFmpeg[] jfmpegs = arrayOfJFmpeg.getJFmpeg();
			
			for(JFmpeg jfmpeg : jfmpegs){
				jfmpegList.add(jfmpeg);
				
//				System.out.println(jfmpeg.getStreamUrl()+" ==> In Port:"+jfmpeg.getInPort()+" Out Port:"+jfmpeg.getOutPort()
//				+" Jsmpeg Process Pid:"+jfmpeg.getJsmpegpid()+" FFmpeg Process Pid:"+jfmpeg.getFfmpegpid());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
	}
	
	/**
	 * 通过参数打开一个JFmpeg视频直播流
	 * @param rtspUrl rtsp 流地址
	 * @param rtspUser rtsp 用户名
	 * @param rtspPsd rtsp 密码
	 * @param paddword jsmpeg 密码
	 * */
	public void OpenSingleStream(String rtspUrl,String rtspUser,String rtspPsd,String password) {
		//打开一个JFmpeg视频流
		OpenSingleJFmpeg openSingleJFmpeg=new OpenSingleJFmpeg();
		openSingleJFmpeg.setRtspStreamUrl(rtspUrl);
		openSingleJFmpeg.setRtspUsername(rtspUser);
		openSingleJFmpeg.setRtspPsd(rtspPsd);
		openSingleJFmpeg.setPassword(password);
		
		try {
			ArrayOfJFmpeg openOneLaterList=GetServiceStub().openSingleJFmpeg(openSingleJFmpeg).getOpenSingleJFmpegResult();
			
			JFmpeg[] openOneJFmpeg = openOneLaterList.getJFmpeg();
			for(JFmpeg jfmpeg : openOneJFmpeg){
				System.out.println(jfmpeg.getStreamUrl()+" ==> In Port:"+jfmpeg.getInPort()+" Out Port:"+jfmpeg.getOutPort()
				+" Jsmpeg Process Pid:"+jfmpeg.getJsmpegpid()+" FFmpeg Process Pid:"+jfmpeg.getFfmpegpid());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 通过进出端口号关闭一条JFmpeg视频流
	 * @param inPort 入端口
	 * @param outPort 出端口
	 * */
	public void CloseSingleStream(String rtspStreamUrl) {
		
		CloseSingleJFmpeg closeSingleJFmpeg=new CloseSingleJFmpeg();
		closeSingleJFmpeg.setRtspStreamUrl(rtspStreamUrl);
		try {
			ArrayOfJFmpeg closeOneLaterList=GetServiceStub().closeSingleJFmpeg(closeSingleJFmpeg).getCloseSingleJFmpegResult();
			JFmpeg[] closeOneJFmpeg=closeOneLaterList.getJFmpeg();
			for (JFmpeg jfmpeg : closeOneJFmpeg) {
				System.out.println(jfmpeg.getStreamUrl()+" ==> In Port:"+jfmpeg.getInPort()+" Out Port:"+jfmpeg.getOutPort()
				+" Jsmpeg Process Pid:"+jfmpeg.getJsmpegpid()+" FFmpeg Process Pid:"+jfmpeg.getFfmpegpid());
			}
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 开启所有的XML文件中 配置的JFmepg视频流通道
	 * */
	public List<JFmpeg> OpenConfigStream() {
		
		RunAllConfigJFmpeg runAllConfigJFmpeg=new RunAllConfigJFmpeg();
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg openAllLaterList=GetServiceStub().runAllConfigJFmpeg(runAllConfigJFmpeg).getRunAllConfigJFmpegResult();
			
			JFmpeg[] openAllJFmpeg = openAllLaterList.getJFmpeg();
			
			for(JFmpeg jfmpeg : openAllJFmpeg){
				jfmpegList.add(jfmpeg);
//				System.out.println(jfmpeg.getStreamUrl()+" ==> In Port:"+jfmpeg.getInPort()+" Out Port:"+jfmpeg.getOutPort()
//				+" Jsmpeg Process Pid:"+jfmpeg.getJsmpegpid()+" FFmpeg Process Pid:"+jfmpeg.getFfmpegpid());
			}
			return jfmpegList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
	}
	
	/**
	 * 关闭所有的XML文件中 配置的JFmepg视频流通道
	 * */
	public void CloseConfigStream() {
		KillAllJFmpegStream killAllJFmpegStream = new KillAllJFmpegStream();
		//List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			System.out.println(GetServiceStub().killAllJFmpegStream(killAllJFmpegStream).getKillAllJFmpegStreamResult());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
