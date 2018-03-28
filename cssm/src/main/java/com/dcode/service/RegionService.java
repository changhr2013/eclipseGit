package com.dcode.service;

import java.util.List;

import com.dcode.entity.Region;

public interface RegionService {
	
	
	public List<Region> getAll();
	
	public Region getById(int id);

}
