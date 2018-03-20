package com.xrzn.rtsp;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.buffer.IoBuffer;

public class MinaTask {
	public void initTask(long period){
		Runnable runnable = new Runnable() {    
            public void run() { 
            	System.out.println("执行同步摄像头状态任务");
            	List<MinaRtspSession> sessions = MinaRtspSessionCache.getInstance().getSessions();
            	if(sessions!=null&&sessions.size()!=0){
            		for(MinaRtspSession se:sessions){
            			if(se!=null){
            				if(se.getSession()==null){
            					RtspMinaClient client = new RtspMinaClient();
            					boolean flag = client.initConnect(se);
            					if(flag){
            						client.sendRtspOptionsMessage();
            					}
            				}else{
            					StringBuilder sb = new StringBuilder();  
            			        sb.append("OPTIONS ");  
            			        sb.append(se.getAddress());  
            			        sb.append(RtspMinaClient.VERSION);  
            			        sb.append("Cseq: ");  
            			        sb.append("1");  
            			        sb.append("\r\n");  
            			        sb.append("\r\n"); 
            			        IoBuffer buffer = IoBuffer.allocate(20);  
            			        // 自动扩容  
            			        buffer.setAutoExpand(true);  
            			        // 自动收缩  
            			        buffer.setAutoShrink(true);  
            			        buffer.put(sb.toString().getBytes());  
            			        buffer.flip();  
            			        se.getSession().write(buffer);  
            				}
            			}
            		}
            	}
            }    
        };    
        ScheduledExecutorService service = Executors    
                .newSingleThreadScheduledExecutor();    
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间    
        service.scheduleAtFixedRate(runnable, 10, period, TimeUnit.SECONDS);
	}
}
