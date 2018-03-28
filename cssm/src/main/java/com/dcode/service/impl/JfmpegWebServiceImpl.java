package com.dcode.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tempuri.MyWebServiceStub;
import org.tempuri.MyWebServiceStub.JFmpeg;
import org.tempuri.MyWebServiceStub.Region;
import org.tempuri.MyWebServiceStub.ArrayOfJFmpeg;
import org.tempuri.MyWebServiceStub.ArrayOfRegion;
import org.tempuri.MyWebServiceStub.GetCurrentJFmpegList;
import org.tempuri.MyWebServiceStub.GetCurrentStreamListByRegion;
import org.tempuri.MyWebServiceStub.GetServerIpAddress;
import org.tempuri.MyWebServiceStub.GetAllRegionList;
import org.tempuri.MyWebServiceStub.ResetJFmpeg;
import org.tempuri.MyWebServiceStub.GetAllJfmpegList;

import org.tempuri.MyWebServiceStub.OpenAllStream;
import org.tempuri.MyWebServiceStub.OpenSingleJFmpeg;
import org.tempuri.MyWebServiceStub.OpenOneJFmpeg;
import org.tempuri.MyWebServiceStub.OpenStreamListByRegion;

import org.tempuri.MyWebServiceStub.CloseAllStream;
import org.tempuri.MyWebServiceStub.CloseSingleJFmpeg;
import org.tempuri.MyWebServiceStub.CloseOneJFmpeg;
import org.tempuri.MyWebServiceStub.CloseStreamListByRegion;

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
	
	//得到所有的配置列表信息
	public List<JFmpeg> GetAllJfmpegList(){
		GetAllJfmpegList getAllJfmpegList=new GetAllJfmpegList();
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg arrayOfJFmpeg= GetServiceStub().
					getAllJfmpegList(getAllJfmpegList).getGetAllJfmpegListResult();
			JFmpeg[] jfmpegs=arrayOfJFmpeg.getJFmpeg();
			
			for(JFmpeg jfmpeg : jfmpegs){
				jfmpegList.add(jfmpeg);
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
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
	 * 获取区域列表
	 * */
	public List<Region> GetAllRegionList() {
		GetAllRegionList getAllRegionList=new GetAllRegionList();
		
		List<Region> regions=new ArrayList<Region>();
		try {
			ArrayOfRegion arrayOfRegion=GetServiceStub().
					getAllRegionList(getAllRegionList).getGetAllRegionListResult();
			Region[] regionsArr=arrayOfRegion.getRegion();
			
			for (Region region : regionsArr) {
				regions.add(region);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return regions;
		
	}
	
	/**
	 * 获取当前的配置视频流信息
	 * */
	public List<JFmpeg> GetCurWebServiceList() {
		GetCurrentJFmpegList curJFmepgs=new GetCurrentJFmpegList();
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg arrayOfJFmpeg = GetServiceStub().
					getCurrentJFmpegList(curJFmepgs).getGetCurrentJFmpegListResult();
			JFmpeg[] jfmpegs = arrayOfJFmpeg.getJFmpeg();
			
			for(JFmpeg jfmpeg : jfmpegs){
				jfmpegList.add(jfmpeg);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
	}

	/**
	 * 根据区域id获取指定区域的视频流列表信息
	 * */
	public List<JFmpeg> GetCurrentStreamListByRegion(int regionId){
		
		GetCurrentStreamListByRegion getCurrentStreamListByRegion=new GetCurrentStreamListByRegion();
		getCurrentStreamListByRegion.setRegionId(regionId);
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		try {
			ArrayOfJFmpeg arrayOfJFmpeg=GetServiceStub().
					getCurrentStreamListByRegion(getCurrentStreamListByRegion).getGetCurrentStreamListByRegionResult();
			JFmpeg[] jfmpegs = arrayOfJFmpeg.getJFmpeg();
			
			for(JFmpeg jfmpeg : jfmpegs){
				jfmpegList.add(jfmpeg);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
	}

	/**
	 * 根据区域id打开指定区域的视频流列表信息
	 * */
	public List<JFmpeg> OpenStreamListByRegion(int regionId){
		
		OpenStreamListByRegion openStreamListByRegion=new OpenStreamListByRegion();
		openStreamListByRegion.setRegionId(regionId);
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg arrayOfJFmpeg=GetServiceStub().
					openStreamListByRegion(openStreamListByRegion).getOpenStreamListByRegionResult();
			JFmpeg[] jfmpegs = arrayOfJFmpeg.getJFmpeg();
			
			for(JFmpeg jfmpeg : jfmpegs){
				jfmpegList.add(jfmpeg);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
	}
	
	/**
	 * 根据区域id关闭指定区域的视频流列表信息
	 * */
	public List<JFmpeg> CloseStreamListByRegion(int regionId){
		
		CloseStreamListByRegion closeStreamListByRegion=new CloseStreamListByRegion();
		closeStreamListByRegion.setRegionId(regionId);
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg arrayOfJFmpeg=GetServiceStub().
					closeStreamListByRegion(closeStreamListByRegion).getCloseStreamListByRegionResult();
			JFmpeg[] jfmpegs = arrayOfJFmpeg.getJFmpeg();
			
			for(JFmpeg jfmpeg : jfmpegs){
				jfmpegList.add(jfmpeg);
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
	public List<JFmpeg> OpenSingleStream(String rtspUrl,String rtspUser,String rtspPsd,String password) {
		//打开一个JFmpeg视频流
		OpenSingleJFmpeg openSingleJFmpeg=new OpenSingleJFmpeg();
		openSingleJFmpeg.setRtspStreamUrl(rtspUrl);
		openSingleJFmpeg.setRtspUsername(rtspUser);
		openSingleJFmpeg.setRtspPsd(rtspPsd);
		openSingleJFmpeg.setPassword(password);
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg openOneLaterList=GetServiceStub().openSingleJFmpeg(openSingleJFmpeg).getOpenSingleJFmpegResult();
			
			JFmpeg[] openOneJFmpeg = openOneLaterList.getJFmpeg();
			for(JFmpeg jfmpeg : openOneJFmpeg){
				jfmpegList.add(jfmpeg);
			}
			
			return jfmpegList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return jfmpegList;

	}
	
	/**
	 * 通过rtsp流地址关闭一条JFmpeg视频流
	 * @param inPort 入端口
	 * @param outPort 出端口
	 * */
	public List<JFmpeg> CloseSingleStream(String rtspStreamUrl) {
		
		CloseSingleJFmpeg closeSingleJFmpeg=new CloseSingleJFmpeg();
		closeSingleJFmpeg.setRtspStreamUrl(rtspStreamUrl);
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg closeOneLaterList=GetServiceStub().closeSingleJFmpeg(closeSingleJFmpeg).getCloseSingleJFmpegResult();
			JFmpeg[] closeOneJFmpeg=closeOneLaterList.getJFmpeg();
			for (JFmpeg jfmpeg : closeOneJFmpeg) {
				jfmpegList.add(jfmpeg);
			}
			return jfmpegList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
	}
	
	/**
	 * 开启所有配置的JFmepg视频流通道
	 * */
	public List<JFmpeg> OpenAllStream() {
		
		OpenAllStream openAllStream=new OpenAllStream();
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg openAllLaterList=GetServiceStub().openAllStream(openAllStream).getOpenAllStreamResult();			
			JFmpeg[] openAllJFmpeg = openAllLaterList.getJFmpeg();
			
			for(JFmpeg jfmpeg : openAllJFmpeg){
				jfmpegList.add(jfmpeg);
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
	public List<JFmpeg> CloseAllStream() {
		
		CloseAllStream closeAllStream=new CloseAllStream();
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg closeAllLaterList=GetServiceStub().closeAllStream(closeAllStream).getCloseAllStreamResult();
			JFmpeg[] closeAllJFmpeg = closeAllLaterList.getJFmpeg();
			
			for(JFmpeg jfmpeg : closeAllJFmpeg){
				jfmpegList.add(jfmpeg);
			}
			
			return jfmpegList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
	}
	
	/**
	 * 通过区域id和url开启单个视频流,返回区域列表状态
	 * */
	public List<JFmpeg> OpenOneJFmpeg(String rtspStreamUrl,int regionId){
		
		OpenOneJFmpeg openOneJFmpeg=new OpenOneJFmpeg();
		openOneJFmpeg.setRtspStreamUrl(rtspStreamUrl);
		openOneJFmpeg.setRegionId(regionId);
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg openOneLaterList=GetServiceStub().openOneJFmpeg(openOneJFmpeg).getOpenOneJFmpegResult();
			JFmpeg[] jFmpegs = openOneLaterList.getJFmpeg();
			
			for(JFmpeg jfmpeg : jFmpegs){
				jfmpegList.add(jfmpeg);
			}
			
			return jfmpegList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
		
	}
	
	/**
	 * 通过区域id和url关闭单个视频流，返回区域列表状态
	 * */
	public List<JFmpeg> CloseOneJFmpeg(String rtspStreamUrl,int regionId){
		
		CloseOneJFmpeg closeOneJFmpeg=new CloseOneJFmpeg();
		closeOneJFmpeg.setRtspStreamUrl(rtspStreamUrl);
		closeOneJFmpeg.setRegionId(regionId);
		
		List<JFmpeg> jfmpegList=new ArrayList<JFmpeg>();
		
		try {
			ArrayOfJFmpeg closeOneLaterList=GetServiceStub().closeOneJFmpeg(closeOneJFmpeg).getCloseOneJFmpegResult();
			JFmpeg[] jFmpegs = closeOneLaterList.getJFmpeg();
			
			for(JFmpeg jfmpeg : jFmpegs){
				jfmpegList.add(jfmpeg);
			}
			
			return jfmpegList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return jfmpegList;
		
	}

}
