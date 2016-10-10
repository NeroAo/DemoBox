package neroao.demobox.grpcdemo.helloworld;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloWorldClient {
	
	private final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());
	
	private final ManagedChannel channel;
	private GreeterGrpc.GreeterBlockingStub blockingStub;
	
	public HelloWorldClient (int port ,String host) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		blockingStub = GreeterGrpc.newBlockingStub(channel);
	}
	
	public void shutdown() throws InterruptedException{
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public void greet(String name){
		logger.info("Will try to greet "+name+"...");
		HelloRequest req = HelloRequest.newBuilder().setName(name).build();
		HelloReply reply;
		try{
			reply = blockingStub.sayHello(req);
		}catch(StatusRuntimeException e){
			logger.log(Level.WARNING,"RPC failded :{0}",e.getStatus() );
			return;
		}
		logger.info("Greeting : "+reply.getMessage());
	}
	
	public static void main(String[] args) throws Exception{
		HelloWorldClient client  = new HelloWorldClient(9000,"127.0.0.1");
		try{
			String user = "world";
			if(args.length>0){
				user = args[0];
			}
			client.greet(user);
		}finally{
			client.shutdown();
		}
	}

}
