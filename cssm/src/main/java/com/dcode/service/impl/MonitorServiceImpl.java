package com.dcode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcode.dao.MonitorMapper;
import com.dcode.entity.Monitor;
import com.dcode.entity.MonitorExample;
import com.dcode.service.MonitorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class MonitorServiceImpl implements MonitorService {
	@Autowired
	private MonitorMapper monitorMapper;

	public PageInfo<Monitor> findByPage(int page, int pageSize,MonitorExample param) {
		PageHelper.startPage(page,pageSize);
		List<Monitor> list = monitorMapper.selectAll(param);
		return  new PageInfo<Monitor>(list);
	}

	public List<Monitor> getAll() {
		return  monitorMapper.selectAll(null);
	}

	public Monitor getById(int id) {
		return monitorMapper.selectByPrimaryKey(id);
	}
	
	public Monitor getByRtspUrl(String url){
		List<Monitor> list = monitorMapper.selectByRtspUrl(url);
		return list==null||list.size()==0?null:list.get(0);
	}

	public List<Monitor> getByRegionId(int regionId) {
		return monitorMapper.getByRegionId(regionId);
	}
}
