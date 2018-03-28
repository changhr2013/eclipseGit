package com.dcode.dao;

import com.dcode.entity.Monitor;
import com.dcode.entity.MonitorExample;
import com.dcode.entity.Region;
import com.dcode.entity.RegionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RegionMapper {
    int countByExample(RegionExample example);

    int deleteByExample(RegionExample example);

    int deleteByPrimaryKey(Integer reginonid);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer reginonid);

    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
    
    List<Region>selectAll(RegionExample param);
}