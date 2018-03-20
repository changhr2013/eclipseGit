package com.xrzn.rtsp;

import java.util.Map;

public class Test {
	public static void main(String[] args) throws Exception{
		MinaTask task = new MinaTask();
		task.initTask(60);
		DeviceCheckUtil.getInstance().registDevice("192.168.0.201", 554, "rtsp://admin:zlsd12345@192.168.0.201:554");
		while(true){
			Map<String,String> re = DeviceCheckUtil.getInstance().getDeviceStatus("192.168.0.201", 554, "rtsp://admin:zlsd12345@192.168.0.201:554");
			int status = Integer.parseInt(re.get("status"));
			System.out.println(re.get("ip")+"【"+(status==0?"离线":"在线")+"】");
			
			Thread.sleep(1000);
		}
	}
}
