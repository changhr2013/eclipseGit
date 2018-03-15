package com.dcode.web;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tempuri.MyWebServiceStub.JFmpeg;

import com.dcode.service.JfmpegWebService;


@Controller
@RequestMapping("/jfmpeg") 
public class JfmpegWebServiceController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JfmpegWebService jfmpegService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String GoIndex() {
		return "index";
	}
	
	//返回WebService服务器的ip地址
	@RequestMapping(value = "/serverip", method = RequestMethod.GET)
	@ResponseBody
	public String GetWebServerIp() {
		String serverip=jfmpegService.GetWebServerIp();
		return serverip;
	}
	
	//获取最新的视频流列表信息
	@RequestMapping(value="/curstreamlist",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> GetCurrentJfmpegList(HttpServletRequest request) {
		
		String regionId=request.getParameter("regionId");
		List<JFmpeg> jlist=new ArrayList<JFmpeg>();
		
		if(StringUtils.isEmpty(regionId)) {
			jlist=jfmpegService.GetCurWebServiceList();
		}else {
			jlist=jfmpegService.GetCurrentStreamListByRegion(Integer.getInteger(regionId));
		}
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", jlist);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", jlist.size());
		return jfmpegMap;
	}

	//通过参数打开相应的流（1.无参数打开所有 2.有regionId打开区域内的流3.有regionId和rtspUrl打开单个流）
	@RequestMapping(value = "/openjfmpeg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> OpenConfigJfmpeg(HttpServletRequest request) {
		
		String regionId = request.getParameter("regionId");
		String rtspStreamUrl=request.getParameter("rtspStreamUrl");
		
		List<JFmpeg> jlist=new ArrayList<JFmpeg>();
		
		if(StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			jlist=jfmpegService.OpenAllStream();
		}else if(!StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			jlist=jfmpegService.OpenStreamListByRegion(Integer.getInteger(regionId));
		}else if(!StringUtils.isEmpty(regionId)&&(!StringUtils.isEmpty(rtspStreamUrl))){
			jlist=jfmpegService.OpenOneJFmpeg(rtspStreamUrl, Integer.getInteger(regionId));
		}
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", jlist);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", jlist.size());
		
		return jfmpegMap;
	}
	
	//通过参数关闭相应的流（1.无参数关闭所有 2.有regionId关闭区域内的流 3.有regionId和rtspUrl关闭单个流）
	@RequestMapping(value = "/closejfmpeg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> CloseConfigJfmpeg(HttpServletRequest request) {
		
		String regionId = request.getParameter("regionId");
		String rtspStreamUrl=request.getParameter("rtspStreamUrl");
		
		List<JFmpeg> jlist=new ArrayList<JFmpeg>();
		
		if(StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			jlist=jfmpegService.CloseAllStream();
		}else if(!StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			jlist=jfmpegService.CloseStreamListByRegion(Integer.getInteger(regionId));
		}else if(!StringUtils.isEmpty(regionId)&&(!StringUtils.isEmpty(rtspStreamUrl))){
			jlist=jfmpegService.CloseOneJFmpeg(rtspStreamUrl, Integer.getInteger(regionId));
		}
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", jlist);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", jlist.size());
		
		return jfmpegMap;
	}
	
	/**
	 * 通过地址转发到添加视频流页面
	 * */
	@RequestMapping(value="/addsinglejfmpeg",method=RequestMethod.GET)
	public String addSingleJfmpeg() {
		return "opensingle";
	}
	
	/**
	 * 通过提交的表单参数打开一个jfmpeg视频流
	 * */
	@RequestMapping(value = "/opensinglejfmpeg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> OpenSingleJfmpeg(HttpServletRequest request) {
		String rtspUrl=request.getParameter("rtspUrl");
		String rtspUsername=request.getParameter("rtspUsername");
		String rtspPassword=request.getParameter("rtspPassword");
		String jsmpegPassword=request.getParameter("jsmpegPassword");
		
		List<JFmpeg> jlist=jfmpegService.OpenSingleStream(rtspUrl, rtspUsername, rtspPassword, jsmpegPassword);
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", jlist);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", jlist.size());
		
		return jfmpegMap;
	}
	
	/**
	 * 通过地址转发到关闭视频流页面
	 * */
	@RequestMapping(value="/removesinglejfmpeg",method=RequestMethod.GET)
	public String removeSingleJfmpeg() {
		return "removesingle";
	}
	
	/**
	 * 通过提交的rtsp视频流地址关闭相应的转换进程
	 * */
	@RequestMapping(value = "/closesinglejfmpeg", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> CloseSingleJfmpeg(HttpServletRequest request) {
		String rtspStreamUrl=request.getParameter("rtspUrl");
		
		List<JFmpeg> jlist=jfmpegService.CloseSingleStream(rtspStreamUrl);
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", jlist);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", jlist.size());
		
		return jfmpegMap;
	}
	
	//强制杀死所有与webservice相关的进程，重置webservice服务器的系统环境
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> Reset() {
		
		String result=jfmpegService.Reset();
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		if(!result.equals("JFmpeg's Environment has been Reset.")) {
			
			List<JFmpeg> jlist=jfmpegService.GetCurWebServiceList();
			
			jfmpegMap.put("data", jlist);
			jfmpegMap.put("code", 0);
			jfmpegMap.put("msg", "重置成功");
			jfmpegMap.put("count", jlist.size());
			return jfmpegMap;
		}
		
		logger.info("重置环境出错！");
		jfmpegMap.put("data", null);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "重置出错，请重新重置。");
		jfmpegMap.put("count", 0);
		
		return jfmpegMap;
		
	}
	
	//video页面辅助重定向(暂用)
	@RequestMapping(value = "/video.html", method = RequestMethod.GET)
	public String videopage() {
		return "video";
	}
	
}
