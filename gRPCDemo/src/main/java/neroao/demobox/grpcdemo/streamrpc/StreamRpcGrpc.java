package neroao.demobox.grpcdemo.streamrpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: streamrpc_test.proto")
public class StreamRpcGrpc {

  private StreamRpcGrpc() {}

  public static final String SERVICE_NAME = "streamrpc.StreamRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<neroao.demobox.grpcdemo.streamrpc.RequestMessage,
      neroao.demobox.grpcdemo.streamrpc.ResponseMessage> METHOD_SAY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "streamrpc.StreamRpc", "say"),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.RequestMessage.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.ResponseMessage.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<neroao.demobox.grpcdemo.streamrpc.SomebodyNames,
      neroao.demobox.grpcdemo.streamrpc.Message> METHOD_SAY_TO_SOME_BODY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "streamrpc.StreamRpc", "sayToSomeBody"),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.SomebodyNames.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.Message.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<neroao.demobox.grpcdemo.streamrpc.RequestMessage,
      neroao.demobox.grpcdemo.streamrpc.ResponseSummary> METHOD_SOME_BODY_SAY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
          generateFullMethodName(
              "streamrpc.StreamRpc", "someBodySay"),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.RequestMessage.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.ResponseSummary.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<neroao.demobox.grpcdemo.streamrpc.MessageCount,
      neroao.demobox.grpcdemo.streamrpc.MessageCount> METHOD_STREAM_CHAT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "streamrpc.StreamRpc", "StreamChat"),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.MessageCount.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(neroao.demobox.grpcdemo.streamrpc.MessageCount.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamRpcStub newStub(io.grpc.Channel channel) {
    return new StreamRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StreamRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static StreamRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StreamRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class StreamRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void say(neroao.demobox.grpcdemo.streamrpc.RequestMessage request,
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY, responseObserver);
    }

    /**
     */
    public void sayToSomeBody(neroao.demobox.grpcdemo.streamrpc.SomebodyNames request,
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.Message> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY_TO_SOME_BODY, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.RequestMessage> someBodySay(
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.ResponseSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SOME_BODY_SAY, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.MessageCount> streamChat(
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.MessageCount> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_STREAM_CHAT, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAY,
            asyncUnaryCall(
              new MethodHandlers<
                neroao.demobox.grpcdemo.streamrpc.RequestMessage,
                neroao.demobox.grpcdemo.streamrpc.ResponseMessage>(
                  this, METHODID_SAY)))
          .addMethod(
            METHOD_SAY_TO_SOME_BODY,
            asyncServerStreamingCall(
              new MethodHandlers<
                neroao.demobox.grpcdemo.streamrpc.SomebodyNames,
                neroao.demobox.grpcdemo.streamrpc.Message>(
                  this, METHODID_SAY_TO_SOME_BODY)))
          .addMethod(
            METHOD_SOME_BODY_SAY,
            asyncClientStreamingCall(
              new MethodHandlers<
                neroao.demobox.grpcdemo.streamrpc.RequestMessage,
                neroao.demobox.grpcdemo.streamrpc.ResponseSummary>(
                  this, METHODID_SOME_BODY_SAY)))
          .addMethod(
            METHOD_STREAM_CHAT,
            asyncBidiStreamingCall(
              new MethodHandlers<
                neroao.demobox.grpcdemo.streamrpc.MessageCount,
                neroao.demobox.grpcdemo.streamrpc.MessageCount>(
                  this, METHODID_STREAM_CHAT)))
          .build();
    }
  }

  /**
   */
  public static final class StreamRpcStub extends io.grpc.stub.AbstractStub<StreamRpcStub> {
    private StreamRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamRpcStub(channel, callOptions);
    }

    /**
     */
    public void say(neroao.demobox.grpcdemo.streamrpc.RequestMessage request,
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayToSomeBody(neroao.demobox.grpcdemo.streamrpc.SomebodyNames request,
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.Message> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SAY_TO_SOME_BODY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.RequestMessage> someBodySay(
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.ResponseSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_SOME_BODY_SAY, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.MessageCount> streamChat(
        io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.MessageCount> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_STREAM_CHAT, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StreamRpcBlockingStub extends io.grpc.stub.AbstractStub<StreamRpcBlockingStub> {
    private StreamRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public neroao.demobox.grpcdemo.streamrpc.ResponseMessage say(neroao.demobox.grpcdemo.streamrpc.RequestMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAY, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<neroao.demobox.grpcdemo.streamrpc.Message> sayToSomeBody(
        neroao.demobox.grpcdemo.streamrpc.SomebodyNames request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SAY_TO_SOME_BODY, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StreamRpcFutureStub extends io.grpc.stub.AbstractStub<StreamRpcFutureStub> {
    private StreamRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<neroao.demobox.grpcdemo.streamrpc.ResponseMessage> say(
        neroao.demobox.grpcdemo.streamrpc.RequestMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAY, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY = 0;
  private static final int METHODID_SAY_TO_SOME_BODY = 1;
  private static final int METHODID_SOME_BODY_SAY = 2;
  private static final int METHODID_STREAM_CHAT = 3;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StreamRpcImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(StreamRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY:
          serviceImpl.say((neroao.demobox.grpcdemo.streamrpc.RequestMessage) request,
              (io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.ResponseMessage>) responseObserver);
          break;
        case METHODID_SAY_TO_SOME_BODY:
          serviceImpl.sayToSomeBody((neroao.demobox.grpcdemo.streamrpc.SomebodyNames) request,
              (io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.Message>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SOME_BODY_SAY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.someBodySay(
              (io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.ResponseSummary>) responseObserver);
        case METHODID_STREAM_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamChat(
              (io.grpc.stub.StreamObserver<neroao.demobox.grpcdemo.streamrpc.MessageCount>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_SAY,
        METHOD_SAY_TO_SOME_BODY,
        METHOD_SOME_BODY_SAY,
        METHOD_STREAM_CHAT);
  }

}
