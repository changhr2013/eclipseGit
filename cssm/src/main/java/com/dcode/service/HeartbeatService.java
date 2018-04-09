package com.dcode.service;

import java.util.List;

public interface HeartbeatService {

	//更新心跳缓存池
	void updateHeartbeatCache(List<String> urlList);
	
	//比对缓存池，自动结束长时间未使用的转码服务
	void autoCleanUnusedService();
	
	//异常服务清理
	void autoCleanUnrunningExceptionService();
}
