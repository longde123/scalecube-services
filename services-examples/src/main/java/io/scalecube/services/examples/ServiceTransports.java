package io.scalecube.services.examples;

import io.scalecube.services.Microservices.ServiceTransportBootstrap;
import io.scalecube.services.transport.rsocket.RSocketServiceTransport;
import io.scalecube.services.transport.rsocket.RSocketTransportResources;

public class ServiceTransports {

  private ServiceTransports() {
    // Do not instantiate
  }

  /**
   * Returns new {@code ServiceTransportBootstrap} object.
   *
   * @param opts options
   * @return new {@code ServiceTransportBootstrap} object
   */
  public static ServiceTransportBootstrap rsocketServiceTransport(ServiceTransportBootstrap opts) {
    return opts.resources(RSocketTransportResources::new)
        .client(RSocketServiceTransport.INSTANCE::clientTransport)
        .server(RSocketServiceTransport.INSTANCE::serverTransport);
  }
}
