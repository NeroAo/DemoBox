package neroao.demobox.grpcdemo.header;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Nullable;

public class TestClientInterceptor implements ClientInterceptor {
	
	private static final Logger logger = Logger.getLogger(TestClientInterceptor.class.getName());
	
	private static Metadata.Key<String> logHeadKey =
		      Metadata.Key.of("logId", Metadata.ASCII_STRING_MARSHALLER);

	@Override
	public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
			MethodDescriptor<ReqT, RespT> method, CallOptions callOptions,
			Channel next) {
		
		return new SimpleForwardingClientCall<ReqT,RespT>(next.newCall(method, callOptions)){
			String logId =  UUID.randomUUID().toString();
			@Override 
			public void start(Listener<RespT> responseListener, Metadata headers){
				headers.put(logHeadKey, logId);
				
				logger.info("client start!!!, logId :"+logId);
				super.start(new SimpleForwardingClientCallListener<RespT>(responseListener){
					@Override
					public void onHeaders(Metadata headers){
						logger.info("header received from server:"+headers+",logId :"+logId);
						super.onHeaders(headers);
					}
					
					@Override
					public void onMessage(RespT message){
						logger.info("message received from :"+ message+",logId :"+logId);
						super.onMessage(message);
					}
					
					@Override
					public void onClose(Status status, Metadata trailers) {
						logger.info("client close ,status :"+status+", trailers :"+trailers+",logId :"+logId);
						super.onClose(status, trailers);
					}
					
					@Override
					public void onReady() {
						logger.info("server is ready!!!"+",logId :"+logId);
						super.onReady();
					}
				},headers);
			}
			
			@Override
			public void request(int numMessages){
				logger.info("client will send "+ numMessages+" messsage"+",logId :"+logId);
				super.request(numMessages);
			}
			
			@Override
			public void cancel(@Nullable String message, @Nullable Throwable cause){
				logger.info("client call cancel ,message :"+message +", cause: "+cause+",logId :"+logId);
				super.cancel(message, cause);
			}
			
			@Override
			public void halfClose(){
				logger.info("client halfclose"+",logId :"+logId);
				super.halfClose();
			}
			
			@Override
			public void sendMessage(ReqT message){
				logger.info("client call send message :"+message+",logId :"+logId);
				super.sendMessage(message);
			}
			
			
		};
	}

}
