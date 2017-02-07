package neroao.demobox.grpcdemo.streamrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StreamRpcServer {
	
	private final static Logger logger = Logger.getLogger(StreamRpcServer.class.getName());
	
	private final int port = 9000;
	private final Server server;
	
	public StreamRpcServer (){
		server =ServerBuilder.forPort(port).addService(new StreamRpcService()).build();
	}
	
	public void start() throws IOException {
		server.start();
		Runtime.getRuntime().addShutdownHook(new Thread (){
			@Override 
			public void run (){
				StreamRpcServer.this.stop();
			}
		});
	}
	
	public void stop(){
		if(server != null){
			server.shutdown();
		}
	}
	
	 private void blockUntilShutdown() throws InterruptedException {
		    if (server != null) {
		      server.awaitTermination();
		    }
		  }
	 
	 public static void main(String[] args) throws Exception {
		    StreamRpcServer server = new StreamRpcServer();
		    server.start();
		    server.blockUntilShutdown();
		  }
	
	private class StreamRpcService extends StreamRpcGrpc.StreamRpcImplBase{
		
		
		
		@Override
		public void say(RequestMessage request,StreamObserver<ResponseMessage> responseObserver){
			responseObserver.onNext(ResponseMessage.newBuilder().setRepMessage("***Response : To "+
					request.getName()+" ,Message : "+request.getMessage() +" recived!").build());
			responseObserver.onCompleted();
		}
		
		@Override
		public void sayToSomeBody (SomebodyNames somebodyNames,StreamObserver<Message> responseObserver){
			String[] names = somebodyNames.getNames().split(",");
			for(String name :names){
				responseObserver.onNext(Message.newBuilder().setMessage("*** Say Hello To :" + name).build());
			}
			responseObserver.onCompleted();
		}
		
		@Override
		public StreamObserver<RequestMessage> someBodySay (final StreamObserver<ResponseSummary> responseObserver){
			StreamObserver<RequestMessage> observer = 
					new StreamObserver<RequestMessage> (){
						String messageSum = "";
						@Override
						public void onNext(RequestMessage value) {
							String name = value.getName();
							String message = value.getMessage();
							messageSum = messageSum + name +" say : "+message +"!";
						}

						@Override
						public void onError(Throwable t) {
							 logger.log(Level.WARNING, "someBodySay cancelled");
						}

						@Override
						public void onCompleted() {
							responseObserver.onNext(ResponseSummary.newBuilder().setMessageCount(messageSum).build());
							responseObserver.onCompleted();
						}
				
			};
			return observer;
		}
		
		@Override
		public StreamObserver<MessageCount> streamChat ( final StreamObserver<MessageCount> responseObserver){
			StreamObserver<MessageCount> observer = new StreamObserver<MessageCount> (){

				@Override
				public void onNext(MessageCount value) {
					String name = value.getName();
					String message = value.getMessage();
					responseObserver.onNext(MessageCount.newBuilder().setName("Server").setMessage("rescive :" + message).build());
					
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
					
				}

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
					
				}
				
			};
			return observer;
		}
	}

}
