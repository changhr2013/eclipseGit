package com.dcode.web;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.hnxurui.TranscodingServiceStub.Streamstat;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcode.entity.FrontModel;
import com.dcode.entity.Monitor;
import com.dcode.entity.MonitorExample;
import com.dcode.service.HeartbeatService;
import com.dcode.service.MonitorService;
import com.dcode.service.RegionService;
import com.dcode.service.TranscodingService;
import com.dcode.utils.WebUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.xrzn.rtsp.DeviceCheckUtil;
import com.xrzn.rtsp.MinaTask;


@Controller
@RequestMapping("/") 
public class JfmpegWebServiceController {

	private final static Logger logger = LoggerFactory.getLogger(JfmpegWebServiceController.class);

	@Autowired
	private MonitorService monitorService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private TranscodingService transcodingService;
	
	@Autowired
	private HeartbeatService heartbeatService;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String GoIndex() {
		return "index";
	}
	
	//返回region列表数据
	@RequestMapping(value="regionlist",method=RequestMethod.GET)
	@ResponseBody
	public List<com.dcode.entity.Region> GetAllRegionList(){
		return regionService.getAll();
	}
	
	//获取最新的视频流列表信息
	@RequestMapping(value="curstreamlist")
	@ResponseBody
	public Map<String,Object> GetCurrentJfmpegList(HttpServletRequest request) {
		
		String regionId = request.getParameter("regionId");
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		int count = 0;
		
		List<FrontModel> fList = new ArrayList<FrontModel>();
		List<Streamstat> sList = transcodingService.GetCacheRunningList();

		if(StringUtils.isEmpty(regionId)) {
			//List<Monitor> mList = monitorService.getAll();
			PageInfo<Monitor> pageInfo=monitorService.findByPage(page, limit, new MonitorExample());
			count = (int) pageInfo.getTotal();
			List<Monitor> mList = pageInfo.getList();
			fList = WebUtils.FrontModelProduct(sList, mList);
			
		}else {
			//List<Monitor> mList = monitorService.getByRegionId(Integer.parseInt(regionId));
			//初始化查询参数
			MonitorExample monitorExample = new MonitorExample();
			monitorExample.createCriteria().andRegionidEqualTo(Integer.parseInt(regionId));
			PageInfo<Monitor> pageInfo = monitorService.findByPage(page, limit, monitorExample);
			count=(int) pageInfo.getTotal();
			List<Monitor> mList = pageInfo.getList();
			fList = WebUtils.FrontModelProduct(sList, mList);
		}
		
		Map<String,Object> jfmpegMap = new HashMap<String,Object>();
		jfmpegMap.put("data", fList);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", count);
		return jfmpegMap;
	}

	//通过参数打开相应的流（1.无参数打开所有 2.有regionId打开区域内的流3.有regionId和rtspUrl打开单个流）
	@RequestMapping(value = "openjfmpeg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> OpenConfigJfmpeg(HttpServletRequest request) {
		
		String regionId = request.getParameter("regionId");
		String rtspStreamUrl=request.getParameter("rtspStreamUrl");
		
		List<FrontModel> fList=new ArrayList<FrontModel>();

		if(StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			//区域id和流地址都为空时，打开所有流
			//在返回列表前执行过滤操作
			List<Monitor> mList = monitorService.getAll();
			List<Monitor> openMonitorList = WebUtils.FilterRightMonitors(mList);
			for (Monitor monitor : openMonitorList) {
				transcodingService.OpenOneJfmpeg(monitor.getPassword(), monitor.getRtspstreamurl(),
						monitor.getRtspusername(), monitor.getRtsppsd());
			}
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
			
		}else if(!StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			//有区域id没有流地址时，打开区域内的流
			//在返回列表前执行过滤操作
			List<Monitor> mList = monitorService.getByRegionId(Integer.parseInt(regionId));
			List<Monitor> openMonitorList = WebUtils.FilterRightMonitors(mList);
			for (Monitor monitor : openMonitorList) {
				transcodingService.OpenOneJfmpeg(monitor.getPassword(), monitor.getRtspstreamurl(),
						monitor.getRtspusername(), monitor.getRtsppsd());
			}
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
			
		}else if(!StringUtils.isEmpty(regionId)&&(!StringUtils.isEmpty(rtspStreamUrl))){
			//区域id和流地址都不为空时，打开区域内的单个流，返回区域列表
			Monitor monitor = monitorService.getByRtspUrl(rtspStreamUrl);
			transcodingService.OpenOneJfmpeg(monitor.getPassword(), monitor.getRtspstreamurl(),
					monitor.getRtspusername(), monitor.getRtsppsd());
			List<Monitor> mList = monitorService.getByRegionId(Integer.parseInt(regionId));
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
			
		}else if(StringUtils.isEmpty(regionId)&&(!StringUtils.isEmpty(rtspStreamUrl))) {
			//区域id为空流地址不为空时，打开单个流，返回全部列表
			Monitor monitor = monitorService.getByRtspUrl(rtspStreamUrl);
			transcodingService.OpenOneJfmpeg(monitor.getPassword(), monitor.getRtspstreamurl(),
					monitor.getRtspusername(), monitor.getRtsppsd());
			List<Monitor> mList = monitorService.getAll();
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
		}
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", fList);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", fList.size());
		
		return jfmpegMap;
	}
		
	//通过参数关闭相应的流（1.无参数关闭所有 2.有regionId关闭区域内的流 3.有regionId和rtspUrl关闭单个流）
	@RequestMapping(value = "closejfmpeg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> CloseConfigJfmpeg(HttpServletRequest request) {
		
		String regionId = request.getParameter("regionId");
		String rtspStreamUrl=request.getParameter("rtspStreamUrl");
		
		List<FrontModel> fList=new ArrayList<FrontModel>();
		
		if(StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			
			//没有区域id和流地址，关闭所有流
			List<Monitor> mList = monitorService.getAll();
			
			for (Monitor monitor : mList) {
				transcodingService.CloseOneJfmpeg(monitor.getRtspstreamurl());
			}
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
			
		}else if(!StringUtils.isEmpty(regionId)&&StringUtils.isEmpty(rtspStreamUrl)) {
			
			//有区域id没有流地址，关闭区域内的所有流 
			List<Monitor> mList = monitorService.getByRegionId(Integer.parseInt(regionId));
			
			for (Monitor monitor : mList) {
				transcodingService.CloseOneJfmpeg(monitor.getRtspstreamurl());
			}
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
			
		}else if(!StringUtils.isEmpty(regionId)&&(!StringUtils.isEmpty(rtspStreamUrl))){
			
			//有区域id和流地址，关闭视频流返回当前区域内流信息
			transcodingService.CloseOneJfmpeg(rtspStreamUrl);
			
			List<Monitor> mList = monitorService.getByRegionId(Integer.parseInt(regionId));
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
			
		}else if(StringUtils.isEmpty(regionId)&&!StringUtils.isEmpty(rtspStreamUrl)) {
			
			//没有区域id有流地址，关闭视频流返回当前所有流信息
			transcodingService.CloseOneJfmpeg(rtspStreamUrl);
			
			List<Monitor> mList = monitorService.getAll();
			List<Streamstat> sList = transcodingService.GetCacheRunningList();
			fList = WebUtils.FrontModelProduct(sList, mList);
		}
		
		Map<String,Object> jfmpegMap=new HashMap<String,Object>();
		jfmpegMap.put("data", fList);
		jfmpegMap.put("code", 0);
		jfmpegMap.put("msg", "");
		jfmpegMap.put("count", fList.size());
		
		return jfmpegMap;
	}
	
	//video页面辅助重定向(暂用)
	@RequestMapping(value = "video.html", method = RequestMethod.GET)
	public String videopage() {
		return "video";
	}
	
	//videotape页面辅助重定向(暂用)
	@RequestMapping(value="videotape.html",method=RequestMethod.GET)
	public String testTable() {
		return "videotape";
	}

	//MinaTask初始化
    static {
    	MinaTask task = new MinaTask();
    	task.initTask(60);
    }
	//配置注册摄像头状态服务的初始化任务和定时任务，spring初始化执行一次，之后每10分钟执行一次
    @PostConstruct
	@Scheduled(cron="0 */10 * * * ?")
	public void queryRtspStatus(){
		logger.info("执行定时任务，开始注册所有摄像头...");
		List<Monitor> monitorList = monitorService.getAll();
		
		for (Monitor monitor : monitorList) {
			
			String rtspTunnel = WebUtils.RtspUrlProduct(monitor.getRtspstreamurl(), monitor.getRtspusername(), monitor.getRtsppsd());
			
			//使用URI获取host地址和端口号
			URI uri = WebUtils.GetUri(monitor.getRtspstreamurl());
			String host = uri.getHost();
			int port = uri.getPort();
			
			//注册RTSP地址
			DeviceCheckUtil.getInstance().registDevice(host, port, rtspTunnel);
		}
		logger.info("所有摄像头注册完成。");
	}
    
    //心跳接收,提交心跳数据刷新心跳缓存
    @RequestMapping(value="heartbeatcheck", method=RequestMethod.POST)
    @ResponseBody
    public String handleHeartbeat(HttpServletRequest request) {
    	logger.info("receive heartbeat message form "+ request.getRemoteAddr());
    	String heartbeat = request.getParameter("clientheart");
    	if(heartbeat == null) {return null;}
    	ObjectMapper objectMapper = new ObjectMapper();  
    	try {
			@SuppressWarnings("unchecked")
			List<String> urlList = objectMapper.readValue(heartbeat, ArrayList.class);
			heartbeatService.updateHeartbeatCache(urlList);

		} catch (IOException e) {
			logger.error("心跳包json数据格式化出错：\r\n"+e.getMessage());
		}
		return "success";
    }
    
    //定时任务：每10分钟执行一次检查，关闭长时间未使用的转码服务
	@Scheduled(cron="0 */10 * * * ?")
	public void checkUnConnectedStream(){
		logger.info("执行定时任务，开始检测服务连通状态...");
		heartbeatService.autoCleanUnusedService();
		logger.info("检查完成，已关闭未使用的连接");
	}
	
	@RequestMapping(value="openoneservice",method=RequestMethod.GET)
	@ResponseBody
	public FrontModel openOneService(HttpServletRequest request) {
		String rtspUrl = request.getParameter("rtspUrl");
		Monitor monitor = monitorService.getByRtspUrl(rtspUrl);
		Streamstat streamstat = transcodingService.OpenOneJfmpeg(monitor.getPassword(), monitor.getRtspstreamurl(), 
										monitor.getRtspusername(), monitor.getRtsppsd());
		//首次开启服务时更新一次心跳数据，用来防止前端开启服务但心跳包未发送期间服务端生命周期任务自动结束新开启的服务
		heartbeatService.updateHeartbeatCache(Arrays.asList(rtspUrl));
		FrontModel frontModel = WebUtils.FrontModelProduct(streamstat, monitor);
		return frontModel;
	}
	
	
}
