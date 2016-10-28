package neroao.demobox.grpcdemo.header;

import io.grpc.ForwardingServerCall.SimpleForwardingServerCall;
import io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

import java.util.logging.Logger;

public class TestServerInterceptor implements ServerInterceptor {
	
	private static final Logger logger = Logger.getLogger(TestServerInterceptor.class.getName());
	
	private static Metadata.Key<String> logHeadKey =
		      Metadata.Key.of("logId", Metadata.ASCII_STRING_MARSHALLER);

	@Override
	public <ReqT, RespT> Listener<ReqT> interceptCall(
			ServerCall<ReqT, RespT> call, Metadata headers,
			ServerCallHandler<ReqT, RespT> next) {
		final String logId = headers.get(logHeadKey);
		return new SimpleForwardingServerCallListener<ReqT>(
		          next.startCall(new SimpleForwardingServerCall<ReqT,RespT>(call){
		  			@Override
				      public void sendHeaders(Metadata responseHeaders) {
				       logger.info("send headers"+",logId :"+logId);
				        super.sendHeaders(responseHeaders);
				      }
					
					@Override
					public void request(int numMessages){
						logger.info("client will send "+numMessages+" message"+",logId :"+logId);
						super.request(numMessages);
					}
					
					@Override
					public void sendMessage(RespT message){
						logger.info("send message to client ,message :"+message+",logId :"+logId);
						super.sendMessage(message);
					}
				}, headers)){
			@Override
			public void onMessage(ReqT message) {
				logger.info("recive message from client ,message :"+message+",logId :"+logId);
				super.onMessage(message);
			}
			
			@Override
			public void onHalfClose() {
				logger.info("client is halfClose!!!"+",logId :"+logId);
				super.onHalfClose();
			}
			
			@Override
			public void onCancel() {
				logger.info("client call is cancel!!!"+",logId :"+logId);
				super.onCancel();
			}
			
			@Override
			public void onComplete() {
				logger.info("call complete !!!"+",logId :"+logId);
				super.onComplete();
			}
			
			@Override
			public void onReady() {
				logger.info("client is ready!!!"+",logId :"+logId);
				super.onReady();
			}
		};
	}

}
