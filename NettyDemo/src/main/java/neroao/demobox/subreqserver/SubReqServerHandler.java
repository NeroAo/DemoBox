package neroao.demobox.subreqserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception{
		SubscribeReq req = (SubscribeReq) msg;
		if("neroao".equalsIgnoreCase(req.getUserName())){
			System.out.println("Service accept client subscribe req : ["+req.toString()+"]");
			ctx.writeAndFlush(resp(req.getSubReqID()));
		}
	}
	
	private SubscribeResp resp(int subReqID){
		SubscribeResp resp = new SubscribeResp();
		resp.setSubReqID(subReqID);
		resp.setRespCode(0);
		resp.setDesc("Netty demo will sent to your address");
		return resp;
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx , Throwable cause){
		cause.printStackTrace();ctx.close();
	}

}
