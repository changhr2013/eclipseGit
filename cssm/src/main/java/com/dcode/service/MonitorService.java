package com.dcode.service;

import java.util.List;

import com.dcode.entity.Monitor;
import com.dcode.entity.MonitorExample;
import com.github.pagehelper.PageInfo;

public interface MonitorService {
	
	public PageInfo<Monitor> findByPage(int page, int pageSize,MonitorExample param);
	
	public List<Monitor> getAll();
	
	public Monitor getById(int id);
	
	public Monitor getByRtspUrl(String url);
	
	public List<Monitor> getByRegionId(int reginId);

}
