package com.dcode.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.hnxurui.TranscodingServiceStub.Streamstat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dcode.entity.Connection;
import com.dcode.service.HeartbeatService;
import com.dcode.service.TranscodingService;

@Component("HeartbeatServiceImpl")
public class HeartbeatServiceImpl implements HeartbeatService {
	
	@Autowired
	private TranscodingService transcodingService;
	
	//日志
	private final static Logger logger = LoggerFactory.getLogger(HeartbeatServiceImpl.class);
	
	//缓存
	private static ConcurrentMap<String,Connection> heartbeatMap = new ConcurrentHashMap<>();
	
	//设置超时时间为 10分钟
	private final static long TIME_OUT = 1*60*1000;
	
	//更新心跳缓存，刷新缓存池中各条流最新心跳的时间
	public void updateHeartbeatCache(List<String> urlList) {
		for (String url : urlList) {
			if(heartbeatMap.containsKey(url)) {
				heartbeatMap.get(url).refresh();
			}else {
				Connection connection=new Connection(url);
				connection.refresh();
				heartbeatMap.put(url, connection);
			}
		}
	}
	
	//定时任务方法，自动结束超时未使用的转码服务
	public void autoCleanUnusedService() {
		long curTime = System.currentTimeMillis();
		for (Connection con : heartbeatMap.values()) {
			if(curTime-con.getLastTime()>TIME_OUT) {
				transcodingService.CloseOneJfmpeg(con.getRtspUrl());
			}
		}
		
	}
	
	//清理异常的服务：转码节点转码服务进程崩溃，节点缓存和持久化数据无法对应更新
	//同时Tomcat节点崩溃,丢失了缓存的延期缓存数据
	//此时重启Tomcat后通过比对心跳和恢复的缓存，找出没有心跳却存在的缓存数据，进行集中清理
	public void autoCleanUnrunningExceptionService() {
		Map<String,Integer> exMap = new HashMap<String,Integer>();

		for (Connection con : heartbeatMap.values()) {
			exMap.put(con.getRtspUrl(), 1);
		}
		List<Streamstat> runningList = transcodingService.GetServerRunningList();
		for (Streamstat streamstat :runningList ) {
			String key=streamstat.getRtspUrl();
			if(exMap.containsKey(key)) {
				Integer value = exMap.get(key);
				exMap.put(key, ++value);
				continue;
			}
			exMap.put(key, 1);
		}
		
		List<String> exList=new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : exMap.entrySet()) {
			if(entry.getValue()==1) {
				exList.add(entry.getKey());
			}
		}
		
		if(exList.isEmpty()) {return;}
		
		for (String rtspUrl : exList) {
			logger.info("clean: " + rtspUrl);
			transcodingService.CloseOneJfmpeg(rtspUrl);
		}
	}

}
