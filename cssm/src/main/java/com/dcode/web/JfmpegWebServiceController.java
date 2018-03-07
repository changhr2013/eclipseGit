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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tempuri.MyWebServiceStub.ArrayOfJFmpeg;
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
	
	@RequestMapping(value = "/serverip", method = RequestMethod.GET)
	public String GetWebServerIp(Model model) {
		String serverip=jfmpegService.GetWebServerIp();
		model.addAttribute("serverip", serverip);
		return "msgtest";
	}
	
	@RequestMapping(value="/currentjfmpeglist",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> GetCurrentJfmpegList() {
		
		List<JFmpeg> jlist=jfmpegService.GetCurWebServiceList();
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", jlist);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", jlist.size());
		return jfmpegMap;
	}
	
	@RequestMapping(value = "/openconfigjfmpeg", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> OpenConfigJfmpeg(Model model) {
		List<JFmpeg> jlist=jfmpegService.OpenConfigStream();
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", jlist);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", jlist.size());
		
		return jfmpegMap;
	}
	
	@RequestMapping(value = "/closeconfigjfmpeg", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> CloseConfigJfmpeg(Model model) {
		List<JFmpeg> jlist=jfmpegService.CloseConfigStream();
		
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
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> Reset() {
		
		String result=jfmpegService.Reset();
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		if(!result.equals("JFmpeg's Environment has been Reset.")) {
			jfmpegMap=GetCurrentJfmpegList();
			return jfmpegMap;
		}
		
		jfmpegMap.put("data", null);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "重置出错，请重新重置。");
		jfmpegMap.put("count", 0);
		
		return jfmpegMap;
		
	}
	
	@RequestMapping(value = "/video.html", method = RequestMethod.GET)
	public String videopage() {
		return "video";
	}
	
}
