// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.shopping.stubs.user;

public final class User {
  private User() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_shopping_stubs_user_UserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_shopping_stubs_user_UserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_shopping_stubs_user_UserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_shopping_stubs_user_UserResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nuser.proto\022\027com.shopping.stubs.user\"\037\n" +
      "\013UserRequest\022\020\n\010username\030\001 \001(\t\"\214\001\n\014UserR" +
      "esponse\022\n\n\002id\030\001 \001(\005\022\020\n\010username\030\002 \001(\t\022\014\n" +
      "\004name\030\003 \001(\t\022\013\n\003age\030\004 \001(\005\022/\n\006gender\030\005 \001(\016" +
      "2\037.com.shopping.stubs.user.Gender\022\022\n\nnoO" +
      "fOrders\030\006 \001(\005*)\n\006Gender\022\010\n\004MALE\020\000\022\n\n\006FEM" +
      "ALE\020\001\022\t\n\005OTHER\020\0022l\n\013UserService\022]\n\016getUs" +
      "erDetails\022$.com.shopping.stubs.user.User" +
      "Request\032%.com.shopping.stubs.user.UserRe" +
      "sponseB\033\n\027com.shopping.stubs.userP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_shopping_stubs_user_UserRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_shopping_stubs_user_UserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_shopping_stubs_user_UserRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_com_shopping_stubs_user_UserResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_shopping_stubs_user_UserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_shopping_stubs_user_UserResponse_descriptor,
        new java.lang.String[] { "Id", "Username", "Name", "Age", "Gender", "NoOfOrders", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
