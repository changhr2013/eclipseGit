package com.xrzn.rtsp;
import java.net.InetSocketAddress;  
import org.apache.mina.core.buffer.IoBuffer;  
import org.apache.mina.core.future.ConnectFuture;  
import org.apache.mina.core.service.IoConnector;  
import org.apache.mina.core.service.IoHandlerAdapter;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.transport.socket.nio.NioSocketConnector;  
/** 
 * @since 
 */  
public class RtspMinaClient extends IoHandlerAdapter {  
	public static final String VERSION = " RTSP/1.0\r\n";  
	private static final String RTSP_OK = "RTSP/1.0 200 OK";
    private IoConnector connector;  
    private MinaRtspSession rtspSession = null;
    public RtspMinaClient() {  
    } 
    public boolean initConnect(MinaRtspSession rtspSession){
    	try{
    		connector = new NioSocketConnector();  
    		connector.setHandler(this);  
    		ConnectFuture connFuture = connector.connect(new InetSocketAddress(rtspSession.getIp(), rtspSession.getPort()));  
    		connFuture.awaitUninterruptibly();  
    		IoSession session = connFuture.getSession();  
    		this.rtspSession = rtspSession;
    		rtspSession.setSession(session);
    		return true;
    	}catch(Exception e){
    		rtspSession.setSession(null);
    		rtspSession.setStatus(0);
    		e.printStackTrace();
    		return false;
    	}
    }
    public static void main(String[] args) throws Exception {  
    	RtspMinaClient client = new RtspMinaClient();  
//    	client.initConnect("192.168.0.201", 554, "rtsp://admin:zlsd12345@192.168.0.201:554");
    	StringBuilder sb = new StringBuilder();  
        sb.append("OPTIONS ");  
        sb.append("rtsp://admin:zlsd12345@192.168.0.201:554");  
        sb.append(VERSION);  
        sb.append("Cseq: ");  
        sb.append("1");  
        sb.append("\r\n");  
        sb.append("\r\n"); 
        IoBuffer buffer = IoBuffer.allocate(20);  
        // 鑷姩鎵╁  
        buffer.setAutoExpand(true);  
        // 鑷姩鏀剁缉  
        buffer.setAutoShrink(true);  
        buffer.put(sb.toString().getBytes());  
        buffer.flip();  
        client.rtspSession.getSession().write(buffer);  
        Thread.sleep(2000);  
        // 鍏抽棴浼氳瘽锛屽緟鎵�鏈夌嚎绋嬪鐞嗙粨鏉熷悗  
        client.connector.dispose(true);  
    }  
    public void sendRtspOptionsMessage(){
    	StringBuilder sb = new StringBuilder();  
        sb.append("OPTIONS ");  
        sb.append(this.rtspSession.getAddress());  
        sb.append(VERSION);  
        sb.append("Cseq: ");  
        sb.append("1");  
        sb.append("\r\n");  
        sb.append("\r\n"); 
        IoBuffer buffer = IoBuffer.allocate(20);  
        // 鑷姩鎵╁  
        buffer.setAutoExpand(true);  
        // 鑷姩鏀剁缉  
        buffer.setAutoShrink(true);  
        buffer.put(sb.toString().getBytes());  
        buffer.flip();  
        rtspSession.getSession().write(buffer);  
    }
    @Override  
    public void messageReceived(IoSession iosession, Object message)  
            throws Exception {  
//    	InetSocketAddress address = (InetSocketAddress) rtspSession.getSession().getRemoteAddress();
//		String ipAddress = address.getHostName();
//		int port = address.getPort();
//		System.out.println(ipAddress+":"+port);
        IoBuffer bbuf = (IoBuffer) message;  
        byte[] byten = new byte[bbuf.limit()];  
        bbuf.get(byten, bbuf.position(), bbuf.limit());  
        String tmp = new String(byten);
        if(tmp.startsWith(RTSP_OK)){
        	rtspSession.setStatus(1);
        }else{
        	rtspSession.setStatus(0);
        }
//        System.out.println("瀹㈡埛绔敹鍒版秷鎭�" +tmp );  
    }  
    @Override  
    public void exceptionCaught(IoSession session, Throwable cause)  
            throws Exception {  
        System.out.println("瀹㈡埛绔紓甯�");
        rtspSession.setStatus(3);
        super.exceptionCaught(session, cause);  
    }  
    @Override  
    public void messageSent(IoSession iosession, Object obj) throws Exception {  
        System.out.println("瀹㈡埛绔秷鎭彂閫�");  
        super.messageSent(iosession, obj);  
    }  
    @Override  
    public void sessionClosed(IoSession iosession) throws Exception { 
    	rtspSession.setSession(null);
        System.out.println("瀹㈡埛绔細璇濆叧闂�");  
        super.sessionClosed(iosession);  
    }  
    @Override  
    public void sessionCreated(IoSession iosession) throws Exception {
    	rtspSession.setSession(iosession);
        System.out.println("瀹㈡埛绔細璇濆垱寤�");  
        super.sessionCreated(iosession);  
    }  
    @Override  
    public void sessionIdle(IoSession iosession, IdleStatus idlestatus)  
            throws Exception {  
        System.out.println("瀹㈡埛绔細璇濅紤鐪�");  
        super.sessionIdle(iosession, idlestatus);  
    }  
    @Override  
    public void sessionOpened(IoSession iosession) throws Exception {  
        System.out.println("瀹㈡埛绔細璇濇墦寮�");  
        super.sessionOpened(iosession);  
    }
	public IoConnector getConnector() {
		return connector;
	}
	public void setConnector(IoConnector connector) {
		this.connector = connector;
	}
	public static String getVersion() {
		return VERSION;
	}
	public static String getRtspOk() {
		return RTSP_OK;
	}  
    
}  