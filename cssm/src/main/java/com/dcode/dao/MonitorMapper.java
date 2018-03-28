package com.dcode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcode.entity.Monitor;
import com.dcode.entity.MonitorExample;

public interface MonitorMapper {
    int countByExample(MonitorExample example);

    int deleteByExample(MonitorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Monitor record);

    int insertSelective(Monitor record);

    Monitor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Monitor record, @Param("example") MonitorExample example);

    int updateByExample(@Param("record") Monitor record, @Param("example") MonitorExample example);

    int updateByPrimaryKeySelective(Monitor record);

    int updateByPrimaryKey(Monitor record);
    
    List<Monitor> selectAll(MonitorExample param);
    
    List<Monitor> selectByRtspUrl(String rtspUrl);
    
    List<Monitor> getByRegionId(Integer regionId);
}