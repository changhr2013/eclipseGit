package com.dcode.enums;

public enum ServiceUrlEnum {
	ONE_SERVER("192.168.0.90","http://192.168.0.90:8071/TranscodingService.asmx"),
	TWO_SERVER("192.168.0.90","http://192.168.0.90:8072/TranscodingService.asmx"),
	THREE_SERVER("192.168.0.90","http://192.168.0.90:8073/TranscodingService.asmx")
	;
	
	private String host;
	private String url;

	
	public String getHost() {
		return host;
	}

	public String getUrl() {
		return url;
	}

	private ServiceUrlEnum(String host,String url) {
		this.host = host;
		this.url = url;
	}
}
