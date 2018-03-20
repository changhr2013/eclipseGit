package com.xrzn.rtsp;

import java.util.List;
import java.util.Vector;

public class MinaRtspSessionCache {
	private List<MinaRtspSession> sessions = null;
	private static MinaRtspSessionCache instance = new MinaRtspSessionCache();
	private MinaRtspSessionCache(){
		sessions = new Vector<MinaRtspSession>();
	}
	public static MinaRtspSessionCache getInstance(){
		return instance;
	}
	public List<MinaRtspSession> getSessions() {
		return sessions;
	}
	public void setSessions(List<MinaRtspSession> sessions) {
		this.sessions = sessions;
	}
	
}
