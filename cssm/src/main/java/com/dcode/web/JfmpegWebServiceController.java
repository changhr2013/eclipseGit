package com.dcode.web;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping(value = "/serverip", method = RequestMethod.GET)
	public String GetWebServerIp(Model model) {
		String serverip=jfmpegService.GetWebServerIp();
		model.addAttribute("serverip", serverip);
		return "msgtest";
	}
	
	@RequestMapping(value="/currentjfmpeglist",method=RequestMethod.GET)
	@ResponseBody
	public List<JFmpeg> GetCurrentJfmpegList(Model model) {
		
		List<JFmpeg> jlist=jfmpegService.GetCurWebServiceList();
		
		model.addAttribute("curjlist", jlist);
		return jlist;
	}
	
	@RequestMapping(value = "/openconfigjfmpeg", method = RequestMethod.GET)
	@ResponseBody
	public List<JFmpeg> OpenConfigJfmpeg(Model model) {
		List<JFmpeg> jlist=jfmpegService.OpenConfigStream();
		model.addAttribute("curjlist", jlist);
		return jlist;
	}
	
	@RequestMapping(value = "/closeconfigjfmpeg", method = RequestMethod.GET)
	public String CloseConfigJfmpeg(Model model) {
		jfmpegService.CloseConfigStream();
		model.addAttribute("result", "all config jfmpeg stream is closed.");
		return "msgtest";
	}
	
	@RequestMapping(value = "/opensinglejfmpeg", method = RequestMethod.POST)
	public String OpenSingleJfmpeg(String rtspUrl,String rtspUsername,String rtspPassword,String jsmpegPassword) {
		
		return null;
	}
	
}
