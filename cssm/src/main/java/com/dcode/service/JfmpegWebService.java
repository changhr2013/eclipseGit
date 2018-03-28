package com.dcode.service;

import java.util.List;

import org.tempuri.MyWebServiceStub.JFmpeg;
import org.tempuri.MyWebServiceStub.Region;

public interface JfmpegWebService {

	/**
	 * 得到当前服务运行的服务器ip地址
	 * 
	 * @return
	 * */
	String GetWebServerIp();
	
	//获得所有的区域列表
	List<Region> GetAllRegionList();
	
	/**
	 * 重新初始化服务器视频流环境
	 * 
	 * @return
	 * */
	String Reset();
	
	/**
	 * 返回当前的所有配置视频流信息
	 * 
	 * @return
	 * */
	List<JFmpeg> GetCurWebServiceList();
	
	//通过区域id得到对应区域下的最新流列表信息
	List<JFmpeg> GetCurrentStreamListByRegion(int regionId);
	
	//获取所有的配置列表
	List<JFmpeg> GetAllJfmpegList();
	
	/**
	 * 通过参数打开一个JFmpeg视频直播流
	 * 
	 * @param rtspUrl rtsp 流地址
	 * @param rtspUser rtsp 用户名
	 * @param rtspPsd rtsp 密码
	 * @param paddword jsmpeg 密码
	 * 
	 * @return
	 * */
	List<JFmpeg> OpenSingleStream(String rtspUrl,String rtspUser,String rtspPsd,String password);
	
	/**
	 * 通过进出端口号关闭一条JFmpeg视频流
	 * 
	 * @param inPort 入端口
	 * @param outPort 出端口
	 * */
	List<JFmpeg> CloseSingleStream(String rtspStreamUrl);
	
	/**
	 * 开启所有的XML文件中 配置的JFmepg视频流通道
	 * 
	 * */
	List<JFmpeg> OpenAllStream();
	
	/**
	 * 关闭所有的XML文件中 配置的JFmepg视频流通道
	 * 
	 * */
	List<JFmpeg> CloseAllStream();
	
	
	List<JFmpeg> OpenOneJFmpeg(String rtspStreamUrl,int regionId);
	
	List<JFmpeg> CloseOneJFmpeg(String rtspStreamUrl,int regionId);
	
	List<JFmpeg> OpenStreamListByRegion(int regionId);
	
	List<JFmpeg> CloseStreamListByRegion(int regionId);
	
}
