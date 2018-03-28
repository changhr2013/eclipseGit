package com.dcode.service;

import java.util.List;

import org.hnxurui.TranscodingServiceStub.Streamstat;

public interface TranscodingService {
	
	//查询运行服务的数量，选择运行最少数量的服务的服务器来开启新的转换服务
	Streamstat OpenOneJfmpeg(String password,String rtspUrl,String rtspUser,String rtspPsd);
	
	//查询缓存中的服务，找到对应的rtspUrl的信息，请求相应的服务器关闭转换服务，对应的更新缓存
	Streamstat CloseOneJfmpeg(String rtspUrl);
	
	//获取所有的服务器运行的服务列表
	List<Streamstat> GetServerRunningList();
	
	//获取缓存中运行的服务列表
	List<Streamstat> GetCacheRunningList();

}
