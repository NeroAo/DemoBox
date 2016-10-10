package neroao.demobox.grpcdemo.helloworld;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

public class HelloWorldServer {
	
	private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());
	
	private int port = 9000;
	private Server server;
	private void start ( ) throws IOException{
		server = ServerBuilder.forPort(9000).addService(new GreeterImpl()).build().start();
		logger.info("Server start , listener on "+port);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run(){
				System.out.println("*** shuting down gRPC server since JVM is shuting down");
				HelloWorldServer.this.stop();
				System.out.println("*** Server shut down");
			}
		});
	}
	
	private void stop(){
		if(server != null){
			server.shutdown();
		}
	}
	
	private void blockUntilShutdown () throws InterruptedException{
		if(server != null){
			server.awaitTermination();
		}
	}
	
	public static void main(String[] args) throws Exception{
		final HelloWorldServer server  = new HelloWorldServer();
		server.start();
		server.blockUntilShutdown();
	}
	
	private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
		
		@Override
		public void sayHello(HelloRequest req,StreamObserver<HelloReply> responseObserver){
			HelloReply reply = HelloReply.newBuilder().setMessage("Hello "+req.getName()).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		}
	}

}
