package com.xrzn.rtsp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceCheckUtil {
	private static DeviceCheckUtil instance = new DeviceCheckUtil();
	private DeviceCheckUtil(){
		
	}
	public static DeviceCheckUtil getInstance(){
		return instance;
	}
	//注册摄像头
	public void registDevice(String ip,Integer port,String rtspAddr){
		if(isEmpty(ip)){
			throw new RuntimeException("ip不能为空");
		}
		if(port==null){
			throw new RuntimeException("port不能为空");
		}
		if(isEmpty(rtspAddr)){
			throw new RuntimeException("rtspAddr不能为空");
		}
		if(getRtspSession(ip,port,rtspAddr)==null){
			MinaRtspSession se = new MinaRtspSession(null, ip, port, rtspAddr);
			MinaRtspSessionCache.getInstance().getSessions().add(se);
		}
	}
	//注销摄像头
//	public void logoutDevice(String ip,Integer port,String rtspAddr){
//		List<MinaRtspSession> objs = MinaRtspSessionCache.getInstance().getSessions();
//		for(int i=objs.size()-1;i>=0;i--){
//			MinaRtspSession o = objs.get(i);
//			if(o.getIp().equals(ip)&&o.getPort()==port&&o.getAddress().equals(rtspAddr)){
//				objs.remove(o);
//			}
//		}
//	}
	
	public Map<String,String> getDeviceStatus(String ip,Integer port,String rtspAddr){
		MinaRtspSession obj = getRtspSession(ip, port, rtspAddr);
		if(obj==null){
			return null;
		}else{
			Map<String,String> result = new HashMap<String,String>();
			result.put("url", obj.getAddress());
			result.put("ip", obj.getIp());
			result.put("port", obj.getPort()+"");
			result.put("status",obj.getStatus()+"");
			return result;
		}
	}
	
	
	private MinaRtspSession getRtspSession(String ip,Integer port,String rtspAddr){
		List<MinaRtspSession> objs = MinaRtspSessionCache.getInstance().getSessions();
		for(MinaRtspSession o:objs){
			if(o.getIp().equals(ip)&&o.getPort()==port&&o.getAddress().equals(rtspAddr)){
				return o;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean isEmpty(String a){
		if(a==null&&a.trim().length()==0){
			return true;
		}else{
			return false;
		}
	}
}
