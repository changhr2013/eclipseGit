package com.dcode.entity;

public class Monitor {
    private Integer id;

    private String monitor;

    private String rtspstreamurl;

    private String rtsppsd;

    private String rtspusername;

    private String password;

    private Integer regionid;
    
    private String regionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor == null ? null : monitor.trim();
    }

    public String getRtspstreamurl() {
        return rtspstreamurl;
    }

    public void setRtspstreamurl(String rtspstreamurl) {
        this.rtspstreamurl = rtspstreamurl == null ? null : rtspstreamurl.trim();
    }

    public String getRtsppsd() {
        return rtsppsd;
    }

    public void setRtsppsd(String rtsppsd) {
        this.rtsppsd = rtsppsd == null ? null : rtsppsd.trim();
    }

    public String getRtspusername() {
        return rtspusername;
    }

    public void setRtspusername(String rtspusername) {
        this.rtspusername = rtspusername == null ? null : rtspusername.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}