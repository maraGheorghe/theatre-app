import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: theatre.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TheatreServiceGrpc {

  private TheatreServiceGrpc() {}

  public static final String SERVICE_NAME = "TheatreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Theatre.LoginRequest,
      Theatre.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = Theatre.LoginRequest.class,
      responseType = Theatre.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.LoginRequest,
      Theatre.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<Theatre.LoginRequest, Theatre.LoginResponse> getLoginMethod;
    if ((getLoginMethod = TheatreServiceGrpc.getLoginMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getLoginMethod = TheatreServiceGrpc.getLoginMethod) == null) {
          TheatreServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<Theatre.LoginRequest, Theatre.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.LogoutRequest,
      Theatre.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = Theatre.LogoutRequest.class,
      responseType = Theatre.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.LogoutRequest,
      Theatre.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<Theatre.LogoutRequest, Theatre.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = TheatreServiceGrpc.getLogoutMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getLogoutMethod = TheatreServiceGrpc.getLogoutMethod) == null) {
          TheatreServiceGrpc.getLogoutMethod = getLogoutMethod =
              io.grpc.MethodDescriptor.<Theatre.LogoutRequest, Theatre.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.LogoutResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("logout"))
              .build();
        }
      }
    }
    return getLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.AddShowRequest,
      Theatre.AddShowResponse> getAddShowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addShow",
      requestType = Theatre.AddShowRequest.class,
      responseType = Theatre.AddShowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.AddShowRequest,
      Theatre.AddShowResponse> getAddShowMethod() {
    io.grpc.MethodDescriptor<Theatre.AddShowRequest, Theatre.AddShowResponse> getAddShowMethod;
    if ((getAddShowMethod = TheatreServiceGrpc.getAddShowMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getAddShowMethod = TheatreServiceGrpc.getAddShowMethod) == null) {
          TheatreServiceGrpc.getAddShowMethod = getAddShowMethod =
              io.grpc.MethodDescriptor.<Theatre.AddShowRequest, Theatre.AddShowResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addShow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.AddShowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.AddShowResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("addShow"))
              .build();
        }
      }
    }
    return getAddShowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.DeleteShowRequest,
      Theatre.DeleteShowResponse> getDeleteShowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteShow",
      requestType = Theatre.DeleteShowRequest.class,
      responseType = Theatre.DeleteShowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.DeleteShowRequest,
      Theatre.DeleteShowResponse> getDeleteShowMethod() {
    io.grpc.MethodDescriptor<Theatre.DeleteShowRequest, Theatre.DeleteShowResponse> getDeleteShowMethod;
    if ((getDeleteShowMethod = TheatreServiceGrpc.getDeleteShowMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getDeleteShowMethod = TheatreServiceGrpc.getDeleteShowMethod) == null) {
          TheatreServiceGrpc.getDeleteShowMethod = getDeleteShowMethod =
              io.grpc.MethodDescriptor.<Theatre.DeleteShowRequest, Theatre.DeleteShowResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteShow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.DeleteShowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.DeleteShowResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("deleteShow"))
              .build();
        }
      }
    }
    return getDeleteShowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.UpdateShowRequest,
      Theatre.UpdateShowResponse> getUpdateShowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateShow",
      requestType = Theatre.UpdateShowRequest.class,
      responseType = Theatre.UpdateShowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.UpdateShowRequest,
      Theatre.UpdateShowResponse> getUpdateShowMethod() {
    io.grpc.MethodDescriptor<Theatre.UpdateShowRequest, Theatre.UpdateShowResponse> getUpdateShowMethod;
    if ((getUpdateShowMethod = TheatreServiceGrpc.getUpdateShowMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getUpdateShowMethod = TheatreServiceGrpc.getUpdateShowMethod) == null) {
          TheatreServiceGrpc.getUpdateShowMethod = getUpdateShowMethod =
              io.grpc.MethodDescriptor.<Theatre.UpdateShowRequest, Theatre.UpdateShowResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateShow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.UpdateShowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.UpdateShowResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("updateShow"))
              .build();
        }
      }
    }
    return getUpdateShowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.GetAllSeatsRequest,
      Theatre.GetAllSeatsResponse> getGetAllSeatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllSeats",
      requestType = Theatre.GetAllSeatsRequest.class,
      responseType = Theatre.GetAllSeatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.GetAllSeatsRequest,
      Theatre.GetAllSeatsResponse> getGetAllSeatsMethod() {
    io.grpc.MethodDescriptor<Theatre.GetAllSeatsRequest, Theatre.GetAllSeatsResponse> getGetAllSeatsMethod;
    if ((getGetAllSeatsMethod = TheatreServiceGrpc.getGetAllSeatsMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getGetAllSeatsMethod = TheatreServiceGrpc.getGetAllSeatsMethod) == null) {
          TheatreServiceGrpc.getGetAllSeatsMethod = getGetAllSeatsMethod =
              io.grpc.MethodDescriptor.<Theatre.GetAllSeatsRequest, Theatre.GetAllSeatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllSeats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetAllSeatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetAllSeatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("getAllSeats"))
              .build();
        }
      }
    }
    return getGetAllSeatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.GetReservedSeatsRequest,
      Theatre.GetReservedSeatsResponse> getGetReservedSeatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getReservedSeats",
      requestType = Theatre.GetReservedSeatsRequest.class,
      responseType = Theatre.GetReservedSeatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.GetReservedSeatsRequest,
      Theatre.GetReservedSeatsResponse> getGetReservedSeatsMethod() {
    io.grpc.MethodDescriptor<Theatre.GetReservedSeatsRequest, Theatre.GetReservedSeatsResponse> getGetReservedSeatsMethod;
    if ((getGetReservedSeatsMethod = TheatreServiceGrpc.getGetReservedSeatsMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getGetReservedSeatsMethod = TheatreServiceGrpc.getGetReservedSeatsMethod) == null) {
          TheatreServiceGrpc.getGetReservedSeatsMethod = getGetReservedSeatsMethod =
              io.grpc.MethodDescriptor.<Theatre.GetReservedSeatsRequest, Theatre.GetReservedSeatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getReservedSeats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetReservedSeatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetReservedSeatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("getReservedSeats"))
              .build();
        }
      }
    }
    return getGetReservedSeatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.GetShowOfTodayRequest,
      Theatre.GetShowOfTodayResponse> getGetShowOfTodayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getShowOfToday",
      requestType = Theatre.GetShowOfTodayRequest.class,
      responseType = Theatre.GetShowOfTodayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.GetShowOfTodayRequest,
      Theatre.GetShowOfTodayResponse> getGetShowOfTodayMethod() {
    io.grpc.MethodDescriptor<Theatre.GetShowOfTodayRequest, Theatre.GetShowOfTodayResponse> getGetShowOfTodayMethod;
    if ((getGetShowOfTodayMethod = TheatreServiceGrpc.getGetShowOfTodayMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getGetShowOfTodayMethod = TheatreServiceGrpc.getGetShowOfTodayMethod) == null) {
          TheatreServiceGrpc.getGetShowOfTodayMethod = getGetShowOfTodayMethod =
              io.grpc.MethodDescriptor.<Theatre.GetShowOfTodayRequest, Theatre.GetShowOfTodayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getShowOfToday"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetShowOfTodayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetShowOfTodayResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("getShowOfToday"))
              .build();
        }
      }
    }
    return getGetShowOfTodayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.GetShowOfADayRequest,
      Theatre.GetShowOfADayResponse> getGetShowOfADayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getShowOfADay",
      requestType = Theatre.GetShowOfADayRequest.class,
      responseType = Theatre.GetShowOfADayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.GetShowOfADayRequest,
      Theatre.GetShowOfADayResponse> getGetShowOfADayMethod() {
    io.grpc.MethodDescriptor<Theatre.GetShowOfADayRequest, Theatre.GetShowOfADayResponse> getGetShowOfADayMethod;
    if ((getGetShowOfADayMethod = TheatreServiceGrpc.getGetShowOfADayMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getGetShowOfADayMethod = TheatreServiceGrpc.getGetShowOfADayMethod) == null) {
          TheatreServiceGrpc.getGetShowOfADayMethod = getGetShowOfADayMethod =
              io.grpc.MethodDescriptor.<Theatre.GetShowOfADayRequest, Theatre.GetShowOfADayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getShowOfADay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetShowOfADayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetShowOfADayResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("getShowOfADay"))
              .build();
        }
      }
    }
    return getGetShowOfADayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Theatre.GetAllShowsRequest,
      Theatre.GetAllShowsResponse> getGetAllShowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllShows",
      requestType = Theatre.GetAllShowsRequest.class,
      responseType = Theatre.GetAllShowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Theatre.GetAllShowsRequest,
      Theatre.GetAllShowsResponse> getGetAllShowsMethod() {
    io.grpc.MethodDescriptor<Theatre.GetAllShowsRequest, Theatre.GetAllShowsResponse> getGetAllShowsMethod;
    if ((getGetAllShowsMethod = TheatreServiceGrpc.getGetAllShowsMethod) == null) {
      synchronized (TheatreServiceGrpc.class) {
        if ((getGetAllShowsMethod = TheatreServiceGrpc.getGetAllShowsMethod) == null) {
          TheatreServiceGrpc.getGetAllShowsMethod = getGetAllShowsMethod =
              io.grpc.MethodDescriptor.<Theatre.GetAllShowsRequest, Theatre.GetAllShowsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllShows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetAllShowsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Theatre.GetAllShowsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TheatreServiceMethodDescriptorSupplier("getAllShows"))
              .build();
        }
      }
    }
    return getGetAllShowsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TheatreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TheatreServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TheatreServiceStub>() {
        @java.lang.Override
        public TheatreServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TheatreServiceStub(channel, callOptions);
        }
      };
    return TheatreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TheatreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TheatreServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TheatreServiceBlockingStub>() {
        @java.lang.Override
        public TheatreServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TheatreServiceBlockingStub(channel, callOptions);
        }
      };
    return TheatreServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TheatreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TheatreServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TheatreServiceFutureStub>() {
        @java.lang.Override
        public TheatreServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TheatreServiceFutureStub(channel, callOptions);
        }
      };
    return TheatreServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TheatreServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(Theatre.LoginRequest request,
        io.grpc.stub.StreamObserver<Theatre.LoginResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(Theatre.LogoutRequest request,
        io.grpc.stub.StreamObserver<Theatre.LogoutResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    /**
     */
    public void addShow(Theatre.AddShowRequest request,
        io.grpc.stub.StreamObserver<Theatre.AddShowResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddShowMethod(), responseObserver);
    }

    /**
     */
    public void deleteShow(Theatre.DeleteShowRequest request,
        io.grpc.stub.StreamObserver<Theatre.DeleteShowResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteShowMethod(), responseObserver);
    }

    /**
     */
    public void updateShow(Theatre.UpdateShowRequest request,
        io.grpc.stub.StreamObserver<Theatre.UpdateShowResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateShowMethod(), responseObserver);
    }

    /**
     */
    public void getAllSeats(Theatre.GetAllSeatsRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetAllSeatsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllSeatsMethod(), responseObserver);
    }

    /**
     */
    public void getReservedSeats(Theatre.GetReservedSeatsRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetReservedSeatsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReservedSeatsMethod(), responseObserver);
    }

    /**
     */
    public void getShowOfToday(Theatre.GetShowOfTodayRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetShowOfTodayResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShowOfTodayMethod(), responseObserver);
    }

    /**
     */
    public void getShowOfADay(Theatre.GetShowOfADayRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetShowOfADayResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShowOfADayMethod(), responseObserver);
    }

    /**
     */
    public void getAllShows(Theatre.GetAllShowsRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetAllShowsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllShowsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.LoginRequest,
                Theatre.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.LogoutRequest,
                Theatre.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .addMethod(
            getAddShowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.AddShowRequest,
                Theatre.AddShowResponse>(
                  this, METHODID_ADD_SHOW)))
          .addMethod(
            getDeleteShowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.DeleteShowRequest,
                Theatre.DeleteShowResponse>(
                  this, METHODID_DELETE_SHOW)))
          .addMethod(
            getUpdateShowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.UpdateShowRequest,
                Theatre.UpdateShowResponse>(
                  this, METHODID_UPDATE_SHOW)))
          .addMethod(
            getGetAllSeatsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.GetAllSeatsRequest,
                Theatre.GetAllSeatsResponse>(
                  this, METHODID_GET_ALL_SEATS)))
          .addMethod(
            getGetReservedSeatsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.GetReservedSeatsRequest,
                Theatre.GetReservedSeatsResponse>(
                  this, METHODID_GET_RESERVED_SEATS)))
          .addMethod(
            getGetShowOfTodayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.GetShowOfTodayRequest,
                Theatre.GetShowOfTodayResponse>(
                  this, METHODID_GET_SHOW_OF_TODAY)))
          .addMethod(
            getGetShowOfADayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.GetShowOfADayRequest,
                Theatre.GetShowOfADayResponse>(
                  this, METHODID_GET_SHOW_OF_ADAY)))
          .addMethod(
            getGetAllShowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Theatre.GetAllShowsRequest,
                Theatre.GetAllShowsResponse>(
                  this, METHODID_GET_ALL_SHOWS)))
          .build();
    }
  }

  /**
   */
  public static final class TheatreServiceStub extends io.grpc.stub.AbstractAsyncStub<TheatreServiceStub> {
    private TheatreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TheatreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TheatreServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(Theatre.LoginRequest request,
        io.grpc.stub.StreamObserver<Theatre.LoginResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(Theatre.LogoutRequest request,
        io.grpc.stub.StreamObserver<Theatre.LogoutResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addShow(Theatre.AddShowRequest request,
        io.grpc.stub.StreamObserver<Theatre.AddShowResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddShowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteShow(Theatre.DeleteShowRequest request,
        io.grpc.stub.StreamObserver<Theatre.DeleteShowResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteShowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateShow(Theatre.UpdateShowRequest request,
        io.grpc.stub.StreamObserver<Theatre.UpdateShowResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateShowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllSeats(Theatre.GetAllSeatsRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetAllSeatsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllSeatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservedSeats(Theatre.GetReservedSeatsRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetReservedSeatsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReservedSeatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getShowOfToday(Theatre.GetShowOfTodayRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetShowOfTodayResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShowOfTodayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getShowOfADay(Theatre.GetShowOfADayRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetShowOfADayResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShowOfADayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllShows(Theatre.GetAllShowsRequest request,
        io.grpc.stub.StreamObserver<Theatre.GetAllShowsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllShowsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TheatreServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TheatreServiceBlockingStub> {
    private TheatreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TheatreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TheatreServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Theatre.LoginResponse login(Theatre.LoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.LogoutResponse logout(Theatre.LogoutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.AddShowResponse addShow(Theatre.AddShowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddShowMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.DeleteShowResponse deleteShow(Theatre.DeleteShowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteShowMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.UpdateShowResponse updateShow(Theatre.UpdateShowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateShowMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.GetAllSeatsResponse getAllSeats(Theatre.GetAllSeatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllSeatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.GetReservedSeatsResponse getReservedSeats(Theatre.GetReservedSeatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReservedSeatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.GetShowOfTodayResponse getShowOfToday(Theatre.GetShowOfTodayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShowOfTodayMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.GetShowOfADayResponse getShowOfADay(Theatre.GetShowOfADayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShowOfADayMethod(), getCallOptions(), request);
    }

    /**
     */
    public Theatre.GetAllShowsResponse getAllShows(Theatre.GetAllShowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllShowsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TheatreServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TheatreServiceFutureStub> {
    private TheatreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TheatreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TheatreServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.LoginResponse> login(
        Theatre.LoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.LogoutResponse> logout(
        Theatre.LogoutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.AddShowResponse> addShow(
        Theatre.AddShowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddShowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.DeleteShowResponse> deleteShow(
        Theatre.DeleteShowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteShowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.UpdateShowResponse> updateShow(
        Theatre.UpdateShowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateShowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.GetAllSeatsResponse> getAllSeats(
        Theatre.GetAllSeatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllSeatsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.GetReservedSeatsResponse> getReservedSeats(
        Theatre.GetReservedSeatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReservedSeatsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.GetShowOfTodayResponse> getShowOfToday(
        Theatre.GetShowOfTodayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShowOfTodayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.GetShowOfADayResponse> getShowOfADay(
        Theatre.GetShowOfADayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShowOfADayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Theatre.GetAllShowsResponse> getAllShows(
        Theatre.GetAllShowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllShowsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;
  private static final int METHODID_ADD_SHOW = 2;
  private static final int METHODID_DELETE_SHOW = 3;
  private static final int METHODID_UPDATE_SHOW = 4;
  private static final int METHODID_GET_ALL_SEATS = 5;
  private static final int METHODID_GET_RESERVED_SEATS = 6;
  private static final int METHODID_GET_SHOW_OF_TODAY = 7;
  private static final int METHODID_GET_SHOW_OF_ADAY = 8;
  private static final int METHODID_GET_ALL_SHOWS = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TheatreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TheatreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((Theatre.LoginRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((Theatre.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.LogoutResponse>) responseObserver);
          break;
        case METHODID_ADD_SHOW:
          serviceImpl.addShow((Theatre.AddShowRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.AddShowResponse>) responseObserver);
          break;
        case METHODID_DELETE_SHOW:
          serviceImpl.deleteShow((Theatre.DeleteShowRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.DeleteShowResponse>) responseObserver);
          break;
        case METHODID_UPDATE_SHOW:
          serviceImpl.updateShow((Theatre.UpdateShowRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.UpdateShowResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_SEATS:
          serviceImpl.getAllSeats((Theatre.GetAllSeatsRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.GetAllSeatsResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVED_SEATS:
          serviceImpl.getReservedSeats((Theatre.GetReservedSeatsRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.GetReservedSeatsResponse>) responseObserver);
          break;
        case METHODID_GET_SHOW_OF_TODAY:
          serviceImpl.getShowOfToday((Theatre.GetShowOfTodayRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.GetShowOfTodayResponse>) responseObserver);
          break;
        case METHODID_GET_SHOW_OF_ADAY:
          serviceImpl.getShowOfADay((Theatre.GetShowOfADayRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.GetShowOfADayResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_SHOWS:
          serviceImpl.getAllShows((Theatre.GetAllShowsRequest) request,
              (io.grpc.stub.StreamObserver<Theatre.GetAllShowsResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TheatreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TheatreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Theatre.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TheatreService");
    }
  }

  private static final class TheatreServiceFileDescriptorSupplier
      extends TheatreServiceBaseDescriptorSupplier {
    TheatreServiceFileDescriptorSupplier() {}
  }

  private static final class TheatreServiceMethodDescriptorSupplier
      extends TheatreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TheatreServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TheatreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TheatreServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .addMethod(getAddShowMethod())
              .addMethod(getDeleteShowMethod())
              .addMethod(getUpdateShowMethod())
              .addMethod(getGetAllSeatsMethod())
              .addMethod(getGetReservedSeatsMethod())
              .addMethod(getGetShowOfTodayMethod())
              .addMethod(getGetShowOfADayMethod())
              .addMethod(getGetAllShowsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
