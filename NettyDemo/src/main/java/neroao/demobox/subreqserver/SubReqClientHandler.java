package neroao.demobox.subreqserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubReqClientHandler extends ChannelInboundHandlerAdapter {

	public SubReqClientHandler(){
		
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx){
		for(int i =0;i<10;i++){
			ctx.write(subReq(i));
		}
		ctx.flush();
	}
	
	private SubscribeReq subReq(int i){
		SubscribeReq req = new SubscribeReq();
		req.setAddress("address");
		req.setPhoneNumber("1234567");
		req.setProductName("Netty demo");
		req.setSubReqID(i);
		req.setUserName("neroao");
		return req;
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
		System.out.println("Recive server response : ["+msg+"]");
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
	
}
