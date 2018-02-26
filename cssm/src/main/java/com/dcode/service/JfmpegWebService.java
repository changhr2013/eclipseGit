package com.dcode.service;

import java.util.List;

import org.tempuri.MyWebServiceStub.ArrayOfJFmpeg;
import org.tempuri.MyWebServiceStub.JFmpeg;

public interface JfmpegWebService {

	/**
	 * 得到当前服务运行的服务器ip地址
	 * 
	 * @return
	 * */
	String GetWebServerIp();
	
	/**
	 * 重新初始化服务器视频流环境
	 * 
	 * @return
	 * */
	String Reset();
	
	/**
	 * 打印当前的配置视频流信息
	 * 
	 * @return
	 * */
	List<JFmpeg> GetCurWebServiceList();
	
	/**
	 * 通过参数打开一个JFmpeg视频直播流
	 * 
	 * @param rtspUrl rtsp 流地址
	 * @param rtspUser rtsp 用户名
	 * @param rtspPsd rtsp 密码
	 * @param paddword jsmpeg 密码
	 * */
	void OpenSingleStream(String rtspUrl,String rtspUser,String rtspPsd,String password);
	
	/**
	 * 通过进出端口号关闭一条JFmpeg视频流
	 * 
	 * @param inPort 入端口
	 * @param outPort 出端口
	 * */
	void CloseSingleStream(String rtspStreamUrl);
	
	/**
	 * 开启所有的XML文件中 配置的JFmepg视频流通道
	 * 
	 * */
	List<JFmpeg> OpenConfigStream();
	
	/**
	 * 关闭所有的XML文件中 配置的JFmepg视频流通道
	 * 
	 * */
	void CloseConfigStream();
	
}
