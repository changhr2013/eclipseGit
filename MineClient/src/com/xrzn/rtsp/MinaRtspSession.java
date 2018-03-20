package com.xrzn.rtsp;

import org.apache.mina.core.session.IoSession;

public class MinaRtspSession{
	private IoSession session;
	private String ip;
	private int port;
	private String address;
	private int status = 0;
	public MinaRtspSession(IoSession session,String ip,int port,String address){
		this.session = session;
		this.ip = ip;
		this.port = port;
		this.address = address;
	}
	public IoSession getSession() {
		return session;
	}
	public void setSession(IoSession session) {
		this.session = session;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
