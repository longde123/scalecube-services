package io.scalecube.services.methods;

import io.scalecube.services.CommunicationMode;
import io.scalecube.services.api.Qualifier;
import io.scalecube.services.api.ServiceMessage;
import java.lang.reflect.Type;

public final class MethodInfo {

  private final String serviceName;
  private final String methodName;
  private final String qualifier;
  private final Type parameterizedReturnType;
  private final CommunicationMode communicationMode;
  private final int parameterCount;
  private final Class<?> requestType;

  /**
   * Create a new service info.
   *
   * @param serviceName the name of the service
   * @param methodName the name of the methof
   * @param parameterizedReturnType the return type (with generics support)
   * @param communicationMode the directions of the method
   * @param parameterCount amount of parameters
   * @param requestType the type of the request
   */
  public MethodInfo(
      String serviceName,
      String methodName,
      Type parameterizedReturnType,
      CommunicationMode communicationMode,
      int parameterCount,
      Class<?> requestType) {

    this.parameterizedReturnType = parameterizedReturnType;
    this.communicationMode = communicationMode;
    this.serviceName = serviceName;
    this.methodName = methodName;
    this.qualifier = Qualifier.asString(serviceName, methodName);
    this.parameterCount = parameterCount;
    this.requestType = requestType;
  }

  public String serviceName() {
    return serviceName;
  }

  public String methodName() {
    return methodName;
  }

  public String qualifier() {
    return qualifier;
  }

  public Type parameterizedReturnType() {
    return parameterizedReturnType;
  }

  public CommunicationMode communicationMode() {
    return communicationMode;
  }

  public int parameterCount() {
    return parameterCount;
  }

  public boolean isRequestTypeServiceMessage() {
    return requestType.isAssignableFrom(ServiceMessage.class);
  }

  public boolean isRequestTypeVoid() {
    return requestType.isAssignableFrom(Void.TYPE);
  }

  public Class<?> requestType() {
    return requestType;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("MethodInfo{");
    sb.append("serviceName='").append(serviceName).append('\'');
    sb.append(", methodName='").append(methodName).append('\'');
    sb.append(", qualifier='").append(qualifier).append('\'');
    sb.append(", parameterizedReturnType=").append(parameterizedReturnType);
    sb.append(", communicationMode=").append(communicationMode);
    sb.append(", parameterCount=").append(parameterCount);
    sb.append(", requestType=").append(requestType);
    sb.append('}');
    return sb.toString();
  }
}
