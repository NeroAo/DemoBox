// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: streamrpc_test.proto

package neroao.demobox.grpcdemo.streamrpc;

/**
 * Protobuf type {@code streamrpc.ResponseMessage}
 */
public  final class ResponseMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:streamrpc.ResponseMessage)
    ResponseMessageOrBuilder {
  // Use ResponseMessage.newBuilder() to construct.
  private ResponseMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResponseMessage() {
    repMessage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ResponseMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            repMessage_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return neroao.demobox.grpcdemo.streamrpc.StreamRpcProto.internal_static_streamrpc_ResponseMessage_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return neroao.demobox.grpcdemo.streamrpc.StreamRpcProto.internal_static_streamrpc_ResponseMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            neroao.demobox.grpcdemo.streamrpc.ResponseMessage.class, neroao.demobox.grpcdemo.streamrpc.ResponseMessage.Builder.class);
  }

  public static final int REPMESSAGE_FIELD_NUMBER = 1;
  private volatile java.lang.Object repMessage_;
  /**
   * <code>optional string repMessage = 1;</code>
   */
  public java.lang.String getRepMessage() {
    java.lang.Object ref = repMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      repMessage_ = s;
      return s;
    }
  }
  /**
   * <code>optional string repMessage = 1;</code>
   */
  public com.google.protobuf.ByteString
      getRepMessageBytes() {
    java.lang.Object ref = repMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      repMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getRepMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, repMessage_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRepMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, repMessage_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof neroao.demobox.grpcdemo.streamrpc.ResponseMessage)) {
      return super.equals(obj);
    }
    neroao.demobox.grpcdemo.streamrpc.ResponseMessage other = (neroao.demobox.grpcdemo.streamrpc.ResponseMessage) obj;

    boolean result = true;
    result = result && getRepMessage()
        .equals(other.getRepMessage());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + REPMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getRepMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(neroao.demobox.grpcdemo.streamrpc.ResponseMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code streamrpc.ResponseMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:streamrpc.ResponseMessage)
      neroao.demobox.grpcdemo.streamrpc.ResponseMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return neroao.demobox.grpcdemo.streamrpc.StreamRpcProto.internal_static_streamrpc_ResponseMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return neroao.demobox.grpcdemo.streamrpc.StreamRpcProto.internal_static_streamrpc_ResponseMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              neroao.demobox.grpcdemo.streamrpc.ResponseMessage.class, neroao.demobox.grpcdemo.streamrpc.ResponseMessage.Builder.class);
    }

    // Construct using neroao.demobox.grpcdemo.streamrpc.ResponseMessage.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      repMessage_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return neroao.demobox.grpcdemo.streamrpc.StreamRpcProto.internal_static_streamrpc_ResponseMessage_descriptor;
    }

    public neroao.demobox.grpcdemo.streamrpc.ResponseMessage getDefaultInstanceForType() {
      return neroao.demobox.grpcdemo.streamrpc.ResponseMessage.getDefaultInstance();
    }

    public neroao.demobox.grpcdemo.streamrpc.ResponseMessage build() {
      neroao.demobox.grpcdemo.streamrpc.ResponseMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public neroao.demobox.grpcdemo.streamrpc.ResponseMessage buildPartial() {
      neroao.demobox.grpcdemo.streamrpc.ResponseMessage result = new neroao.demobox.grpcdemo.streamrpc.ResponseMessage(this);
      result.repMessage_ = repMessage_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof neroao.demobox.grpcdemo.streamrpc.ResponseMessage) {
        return mergeFrom((neroao.demobox.grpcdemo.streamrpc.ResponseMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(neroao.demobox.grpcdemo.streamrpc.ResponseMessage other) {
      if (other == neroao.demobox.grpcdemo.streamrpc.ResponseMessage.getDefaultInstance()) return this;
      if (!other.getRepMessage().isEmpty()) {
        repMessage_ = other.repMessage_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      neroao.demobox.grpcdemo.streamrpc.ResponseMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (neroao.demobox.grpcdemo.streamrpc.ResponseMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object repMessage_ = "";
    /**
     * <code>optional string repMessage = 1;</code>
     */
    public java.lang.String getRepMessage() {
      java.lang.Object ref = repMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        repMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string repMessage = 1;</code>
     */
    public com.google.protobuf.ByteString
        getRepMessageBytes() {
      java.lang.Object ref = repMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        repMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string repMessage = 1;</code>
     */
    public Builder setRepMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      repMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string repMessage = 1;</code>
     */
    public Builder clearRepMessage() {
      
      repMessage_ = getDefaultInstance().getRepMessage();
      onChanged();
      return this;
    }
    /**
     * <code>optional string repMessage = 1;</code>
     */
    public Builder setRepMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      repMessage_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:streamrpc.ResponseMessage)
  }

  // @@protoc_insertion_point(class_scope:streamrpc.ResponseMessage)
  private static final neroao.demobox.grpcdemo.streamrpc.ResponseMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new neroao.demobox.grpcdemo.streamrpc.ResponseMessage();
  }

  public static neroao.demobox.grpcdemo.streamrpc.ResponseMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResponseMessage>
      PARSER = new com.google.protobuf.AbstractParser<ResponseMessage>() {
    public ResponseMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ResponseMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ResponseMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResponseMessage> getParserForType() {
    return PARSER;
  }

  public neroao.demobox.grpcdemo.streamrpc.ResponseMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

