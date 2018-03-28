package com.dcode.entity;

public class FrontModel {
	//RTSP 流地址
	private String rtspUrl;
	//摄像头别名
	private String rtspAlias;
	//WebSocket流地址
	private String wsUrl;
	//服务状态
	private Boolean serviceStatus;
	
	private int cameraStatus;
	
	private String rtspUser;
	
	private String rtspPsd;
	
	
	public String getRtspUrl() {
		return rtspUrl;
	}
	public void setRtspUrl(String rtspUrl) {
		this.rtspUrl = rtspUrl;
	}
	public String getRtspAlias() {
		return rtspAlias;
	}
	public void setRtspAlias(String rtspAlias) {
		this.rtspAlias = rtspAlias;
	}
	public String getWsUrl() {
		return wsUrl;
	}
	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
	}
	
	public Boolean getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(Boolean serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	public int getCameraStatus() {
		return cameraStatus;
	}
	public void setCameraStatus(int cameraStatus) {
		this.cameraStatus = cameraStatus;
	}
	public String getRtspUser() {
		return rtspUser;
	}
	public void setRtspUser(String rtspUser) {
		this.rtspUser = rtspUser;
	}
	public String getRtspPsd() {
		return rtspPsd;
	}
	public void setRtspPsd(String rtspPsd) {
		this.rtspPsd = rtspPsd;
	}
	//构造方法
	public FrontModel(String rtspUrl, String rtspAlias, String rtspUser, String rtspPsd) {
		super();
		this.rtspUrl = rtspUrl;
		this.rtspAlias = rtspAlias;
		this.rtspUser = rtspUser;
		this.rtspPsd = rtspPsd;
		this.wsUrl = "";
		this.serviceStatus = false;
	}
	
	
}
