package com.dcode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcode.dao.RegionMapper;
import com.dcode.entity.Region;
import com.dcode.service.RegionService;
@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	private RegionMapper regionMapper;
	
	public List<Region> getAll() {
		return regionMapper.selectAll(null);
	}

	public Region getById(int id) {
		// TODO Auto-generated method stub
		return regionMapper.selectByPrimaryKey(id);
	}

}
