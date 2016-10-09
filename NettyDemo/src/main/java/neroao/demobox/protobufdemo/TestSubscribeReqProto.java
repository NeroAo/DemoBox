package neroao.demobox.protobufdemo;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestSubscribeReqProto {
	
	private static byte[] encode(SubscribeReqProto.SubscribeReq req){
		return req.toByteArray();
	}
	
	private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException{
		return SubscribeReqProto.SubscribeReq.parseFrom(body);
	}
	
	private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqId(1);
		builder.setUserName("neroao");
		builder.setProductName("Netty demo");
		builder.setAddress("address");
		return builder.build();
	}
	
	public static void main(String[] args) throws Exception{
		SubscribeReqProto.SubscribeReq req = createSubscribeReq();
		System.out.println("Before encode : "+req.toString());
		SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
		System.out.println("After encode : "+req2.toString());
		System.out.println("Assert equal : "+req2.equals(req));
		
	}

}
