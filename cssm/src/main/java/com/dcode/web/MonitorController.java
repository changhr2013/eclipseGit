package com.dcode.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcode.entity.Monitor;
import com.dcode.entity.Region;
import com.dcode.service.MonitorService;
import com.dcode.service.RegionService;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/monitor") 
public class MonitorController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MonitorService monitorService;
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value="/monitor",method=RequestMethod.GET)
	public String GoIndex() {
		return "monitor";
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/grid")
	@ResponseBody
	public Map<String,Object> grid(int page,int limit,Monitor m) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PageInfo<Monitor> pager = monitorService.findByPage(page,limit,null);
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", pager.getTotal());
		resultMap.put("data", pager.getList());
		return resultMap;
	}
	/**
	 * 获取所有的摄像头列表
	 * @return
	 */
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public List<Monitor> getAll() {
		return monitorService.getAll();
	}
	/**
	 * 根据id获取摄像头信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getById")
	@ResponseBody
	public Monitor getById(int id){
		return monitorService.getById(id);
	}
	/**
	 * 根据rtsp地址获取摄像头信息
	 * @param rtspurl
	 * @return
	 */
	@RequestMapping(value = "/getByRtspUrl")
	@ResponseBody
	public Monitor getByRtspUrl(String rtspurl){
		return monitorService.getByRtspUrl(rtspurl);
	}
	/**
	 * 根据区域id获取摄像头信息列表
	 * @param regionId
	 * @return
	 */
	@RequestMapping(value = "/getByRegionId")
	@ResponseBody
	public List<Monitor> findMonitorByRegionId(int regionId){
		return monitorService.getByRegionId(regionId);
	}
	/**
	 * 获取所有区域信息
	 * @return
	 */
	@RequestMapping(value = "/getAllRegion")
	@ResponseBody
	public List<Region> getAllRegion(){
		return regionService.getAll();
	}
	/**
	 * 根据区域id获取区域信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getRegionById")
	@ResponseBody
	public Region getRegionById(int id){
		return regionService.getById(id);
	}
	
}
