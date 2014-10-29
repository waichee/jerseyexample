package org.wai.jerseyexample.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wai.jerseyexample.domain.Order;
import org.wai.jerseyexample.VersionedMediaType;
import org.wai.jerseyexample.service.AdhocOrderService;
import org.wai.jerseyexample.service.BatchOrderService;
import org.wai.jerseyexample.service.OrderService;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * REST resource/endpoints for accessing order(s)
 */
@Component
@Resource
@Path("/order")
public class OrderResource {

  private static final Logger LOG = LoggerFactory.getLogger(OrderResource.class);

  @Autowired
  private OrderService<AdhocOrderService> adhocOrderService;

  @Autowired
  private OrderService<BatchOrderService> batchOrderService;


  @GET
  @Consumes({MediaType.APPLICATION_JSON, VersionedMediaType.JERSEY_EXAMPLE_V2_JSON})
  @Produces({MediaType.APPLICATION_JSON, VersionedMediaType.JERSEY_EXAMPLE_V2_JSON})
  public List<Order> getOrders() {
    return batchOrderService.findAllOrders();
  }


  @GET
  @Path("/async")
  public void asyncGetWithTimeout(@Suspended final AsyncResponse asyncResponse) {
    asyncResponse.setTimeoutHandler((r) ->r.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("Operation time out.").build()));
    asyncResponse.setTimeout(20, TimeUnit.SECONDS);

    asyncResponse.register(new CompletionCallback() {
      @Override
      public void onComplete(Throwable throwable) {
        if (throwable == null) {
          // no throwable - the processing ended successfully
          // (response already written to the client)
          LOG.info("Completed async response all good");
        } else {
          LOG.info("Error in handling async response:" + throwable);

        }
      }
    });
  }


  @GET
  @Path("/{orderId}")
  @Consumes({MediaType.APPLICATION_JSON, VersionedMediaType.JERSEY_EXAMPLE_V2_JSON})
  @Produces({MediaType.APPLICATION_JSON, VersionedMediaType.JERSEY_EXAMPLE_V2_JSON})
  public Order getOrderV2(@PathParam("orderId") Long orderId) {

    LOG.info("Returning v2 order....");
    return batchOrderService.getOrder(orderId);
  }


  @GET
  @Path("/{orderId}")
  @Consumes(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON)
  @Produces(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON)
  public Order getOrderV1(@PathParam("orderId") Long orderId) {

    LOG.info("Returning v1 order....");
    return adhocOrderService.getOrder(orderId);
  }




}
