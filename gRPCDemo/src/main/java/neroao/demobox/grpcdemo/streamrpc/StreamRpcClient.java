package neroao.demobox.grpcdemo.streamrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import neroao.demobox.grpcdemo.streamrpc.StreamRpcGrpc.StreamRpcBlockingStub;
import neroao.demobox.grpcdemo.streamrpc.StreamRpcGrpc.StreamRpcStub;

public class StreamRpcClient {
	
	private final ManagedChannel channel;
	private final StreamRpcBlockingStub blockingStub;
	private final StreamRpcStub asynStub;
	
	public StreamRpcClient(String host ,int port){
		ManagedChannelBuilder builder = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true);
		channel = builder.build();
		blockingStub = StreamRpcGrpc.newBlockingStub(channel);
		asynStub = StreamRpcGrpc.newStub(channel);
	}
	
	public void shutdown() throws InterruptedException{
		channel.shutdown().awaitTermination(5,TimeUnit.SECONDS);
	}
	
	public void say( String name ,String message){
		RequestMessage request = RequestMessage.newBuilder().setName(name).setMessage(message).build();
		ResponseMessage resp ;
		try{
			resp = blockingStub.say(request);
		}catch(StatusRuntimeException e){
			e.printStackTrace();
			return;
		}
		System.out.println("****  invoke  function say from server");
		System.out.println(resp.getRepMessage());
		
	}
	
	public void sayToSomeBody (String names){
		SomebodyNames sNames = SomebodyNames.newBuilder().setNames(names).build();
		Iterator<Message> messages;
		try{
			messages = blockingStub.sayToSomeBody(sNames);
		}catch(StatusRuntimeException e){
			e.printStackTrace();
			return;
		}
		System.out.println("****  invoke  function sayToSomeBody from server");
		while(messages.hasNext()){
			System.out.println(messages.next().getMessage());
		}
	}
	
	public void someBodySay() throws InterruptedException{
		final CountDownLatch finishLatch = new CountDownLatch(1);
		StreamObserver<ResponseSummary> responseObserver = new StreamObserver<ResponseSummary>(){

			@Override
			public void onNext(ResponseSummary value) {
				System.out.println("*****  "+value.getMessageCount());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				finishLatch.countDown();
				
			}

			@Override
			public void onCompleted() {
				finishLatch.countDown();
				
			}
			
		};
		
		StreamObserver<RequestMessage> requestObserver = asynStub.someBodySay(responseObserver);
		for(int i =0 ;i<5 ;i++){
			requestObserver.onNext(RequestMessage.newBuilder().setName("name"+i).setMessage("message"+i).build());
		}
		requestObserver.onCompleted();
		finishLatch.await(1,TimeUnit.SECONDS);
	}
	
	public void streamChat ()  throws InterruptedException {
		final CountDownLatch finishLatch = new CountDownLatch(1);
		StreamObserver<MessageCount> requestObserver = asynStub.streamChat(new StreamObserver<MessageCount> (){

			@Override
			public void onNext(MessageCount value) {
				System.out.print("*** "+ value.getName()+" : "+value.getMessage());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				finishLatch.countDown();
				
			}

			@Override
			public void onCompleted() {
				finishLatch.countDown();
				
			}
			
		});
		
		try{
			for(int i =0 ;i<5;i++){
				requestObserver.onNext(MessageCount.newBuilder().setName("user "+i).setMessage("message "+i).build());
			}
		}catch(StatusRuntimeException e){
			finishLatch.countDown();
		}
		requestObserver.onCompleted();

	    // Receiving happens asynchronously
	    finishLatch.await(1, TimeUnit.MINUTES);
	}
	
	public static void main(String[] args) throws InterruptedException {
		StreamRpcClient client = new StreamRpcClient("127.0.0.1",9000);
		try{
			client.say("nero", "Hello");
			client.sayToSomeBody("tiger,kitty,nero");
			client.someBodySay();
			client.streamChat();
		}finally {
		      client.shutdown();
	    }
		
	}

}
