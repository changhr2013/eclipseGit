package com.dcode.service.impl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
	private final static long TIME_OUT = 10*60*1000;
	
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

}
