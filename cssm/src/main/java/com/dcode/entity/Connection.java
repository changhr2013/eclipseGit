package com.dcode.entity;

public class Connection{
	private volatile long lastTime;
	private String rtspUrl;
	
	//刷新记录的时间
	public void refresh() {
		lastTime = System.currentTimeMillis();
	}
	//获取最后心跳时间
	public long getLastTime() {
		return lastTime;
	}

	public String getRtspUrl() {
		return rtspUrl;
	}

	public void setRtspUrl(String rtspUrl) {
		this.rtspUrl = rtspUrl;
	}
	
	//构造方法
	public Connection(String rtspUrl) {
		super();
		this.rtspUrl = rtspUrl;
	}
	
}