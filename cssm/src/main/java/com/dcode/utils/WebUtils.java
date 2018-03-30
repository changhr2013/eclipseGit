package com.dcode.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.hnxurui.TranscodingServiceStub.Streamstat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.dcode.entity.FrontModel;
import com.dcode.entity.Monitor;
import com.xrzn.rtsp.DeviceCheckUtil;

public class WebUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(WebUtils.class);
	/**
	 * 根据参数拼装完整的RTSP流地址 
	 * @param rtspUrl RTSP地址
	 * @param rtspUser 用户名
	 * @param rtspPsd 密码
	 * @return
	 * @author changhr2013
	 * */
	public static String RtspUrlProduct(String rtspUrl,String rtspUser,String rtspPsd) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("rtsp://");
		if(StringUtils.isEmpty(rtspUser)) {
			sBuilder.append(rtspUrl);
		}else {
			sBuilder.append(rtspUser);
			sBuilder.append(":");
			sBuilder.append(rtspPsd);
			sBuilder.append("@");
			sBuilder.append(rtspUrl);
		}

		return sBuilder.toString();
	}
	
	/**
	 * 根据字符串获取URI对象
	 * @param url 不带协议头的地址
	 * @return
	 * @author changhr2013
	 * */
	public static URI GetUri(String url) {
		try {
			URI uri = new URI("http://"+url);
			return uri;
		} catch (URISyntaxException e) {
			logger.error("地址格式错误无法转换为URI:\r\n"+e.getMessage());
		}
		return null;
	}
	
	/**
	 * 获取RTSP流的状态
	 * @param frontModel 前端显示model
	 * @return frontModel
	 * @author changhr2013
	 * */
	public static FrontModel GetRtspStatus(FrontModel frontModel) {
		//准备参数:IP地址、端口号、完成的RTSP地址
		String rtspTunnel = RtspUrlProduct(frontModel.getRtspUrl(), frontModel.getRtspUser(), frontModel.getRtspPsd());
		URI uri = GetUri(frontModel.getRtspUrl());
		String host = uri.getHost();
		int port = uri.getPort();
		//获取摄像头RTSP流状态
		int status = Integer.parseInt(DeviceCheckUtil.getInstance().getDeviceStatus(host, port, rtspTunnel).get("status"));
		//更新frontModel
		frontModel.setCameraStatus(status);
		
		return frontModel;
	}
	
	/**
	 * 拼装前端显示的model数据
	 * @param runningList 正在运行的服务列表
	 * @param jfList 用户请求的流列表
	 * @return frontModels 返回前端显示的数据列表
	 * @author changhr2013
	 * */
	public static List<FrontModel> FrontModelProduct(List<Streamstat> runningList,List<Monitor> monitorList){
		List<FrontModel> frontModels = new ArrayList<FrontModel>();
		//外层循环，添加所有要显示的列表
		runningflag:
		for (Monitor monitor : monitorList) {
			FrontModel frontModel = new FrontModel(monitor.getRtspstreamurl(), monitor.getMonitor(), monitor.getRtspusername(), monitor.getRtsppsd());
			frontModel = WebUtils.GetRtspStatus(frontModel);
			//内层循环，根据传入的运行列表修改相应的服务状态
			for (Streamstat streamstat : runningList) {
				if(frontModel.getRtspUrl().equals(streamstat.getRtspUrl())) {
					frontModel.setServiceStatus(streamstat.getStatus());
					frontModel.setWsUrl(streamstat.getWsUrl());
					//runningList.remove(streamstat); //尝试删除已经组合的元素来降低内层循环的次数
					frontModels.add(frontModel);
					continue runningflag;
				}
			}
			frontModels.add(frontModel);
		}
		
		return frontModels;
	}
	
	/**
	 * 获取RTSP流的状态
	 * @param Monitor
	 * @return Boolean
	 * @author changhr2013
	 * */
	public static Boolean GetRtspStatus(Monitor monitor) {
		//准备参数:IP地址、端口号、完成的RTSP地址
		String rtspTunnel = RtspUrlProduct(monitor.getRtspstreamurl(), monitor.getRtspusername(), monitor.getRtsppsd());
		URI uri = GetUri(monitor.getRtspstreamurl());
		String host = uri.getHost();
		int port = uri.getPort();
		//获取摄像头RTSP流状态
		int status = Integer.parseInt(DeviceCheckUtil.getInstance().getDeviceStatus(host, port, rtspTunnel).get("status"));
		if(status==1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 检查状态，移除MonitorList列表中状态不正常的monitor
	 * */
	public static List<Monitor> FilterRightMonitors(List<Monitor> monitors){
		List<Monitor> runMonitors = new ArrayList<>(monitors);
		for (Monitor monitor : monitors) {
			if(!WebUtils.GetRtspStatus(monitor)) {
				runMonitors.remove(monitor);
			}
		}
		return runMonitors;
	}
	
}
