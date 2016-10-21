package neroao.demobox.grpcdemo.helloworld;

import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.ServerCalls.UnaryMethod;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

import neroao.demobox.grpcdemo.helloworld.GreeterGrpc.GreeterImplBase;

public class HelloJsonServer {
	  private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

	  /* The port on which the server should run */
	  private int port = 9000;
	  private Server server;

	  private void start() throws IOException {
	    server = ServerBuilder.forPort(port)
	        .addService(bindService(new GreeterImpl()))
	        .build()
	        .start();
	    logger.info("Server started, listening on " + port);
	    Runtime.getRuntime().addShutdownHook(new Thread() {
	      @Override
	      public void run() {
	        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
	        System.err.println("*** shutting down gRPC server since JVM is shutting down");
	        HelloJsonServer.this.stop();
	        System.err.println("*** server shut down");
	      }
	    });
	  }

	  private void stop() {
	    if (server != null) {
	      server.shutdown();
	    }
	  }

	  /**
	   * Await termination on the main thread since the grpc library uses daemon threads.
	   */
	  private void blockUntilShutdown() throws InterruptedException {
	    if (server != null) {
	      server.awaitTermination();
	    }
	  }

	  /**
	   * Main launches the server from the command line.
	   */
	  public static void main(String[] args) throws IOException, InterruptedException {
	    final HelloJsonServer server = new HelloJsonServer();
	    server.start();
	    server.blockUntilShutdown();
	  }

	  private static class GreeterImpl extends GreeterImplBase {

	    @Override
	    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
	      HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
	      responseObserver.onNext(reply);
	      responseObserver.onCompleted();
	    }
	  }

	  private ServerServiceDefinition bindService(final GreeterImplBase serviceImpl) {
	    return io.grpc.ServerServiceDefinition
	        .builder(new io.grpc.ServiceDescriptor(GreeterGrpc.SERVICE_NAME,
	        		HelloJsonClient.HelloJsonStub.METHOD_SAY_HELLO))
	        .addMethod(HelloJsonClient.HelloJsonStub.METHOD_SAY_HELLO,
	            asyncUnaryCall(
	              new UnaryMethod<HelloRequest, HelloReply>() {
	                @Override
	                public void invoke(
	                    HelloRequest request, StreamObserver<HelloReply> responseObserver) {
	                  serviceImpl.sayHello(request, responseObserver);
	                }
	              }))
	        .build();
	  }
	}
