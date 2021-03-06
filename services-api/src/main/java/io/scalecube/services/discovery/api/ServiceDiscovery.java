package io.scalecube.services.discovery.api;

import io.scalecube.services.ServiceEndpoint;
import io.scalecube.services.transport.api.Address;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceDiscovery {

  /**
   * Returns service discovery address.
   *
   * @return discovery address
   */
  Address address();

  /**
   * Returns service endpoint.
   *
   * @return service endpoint
   */
  ServiceEndpoint serviceEndpoint();

  /**
   * Function to subscribe and listen on {@code ServiceDiscoveryEvent} events.
   *
   * @return stream of {@code ServiceDiscoveryEvent} events
   */
  Flux<ServiceDiscoveryEvent> listenDiscovery();

  /**
   * Function to subscribe and listen on {@code ServiceGroupDiscoveryEvent} events.
   *
   * @return stream of {@code ServiceGroupDiscoveryEvent} events
   */
  Flux<ServiceGroupDiscoveryEvent> listenGroupDiscovery();

  /**
   * Starting this {@code ServiceDiscovery} instance.
   *
   * @return started {@code ServiceDiscovery} instance
   */
  Mono<ServiceDiscovery> start();

  /**
   * Shutting down this {@code ServiceDiscovery} instance.
   *
   * @return async signal of the result
   */
  Mono<Void> shutdown();
}
