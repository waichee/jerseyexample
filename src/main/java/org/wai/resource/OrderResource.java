package org.wai.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wai.domain.Order;
import org.wai.VersionedMediaType;
import org.wai.service.AdhocOrderService;
import org.wai.service.BatchOrderService;
import org.wai.service.OrderService;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
  public Order getOrderV2() {

    LOG.info("Returning v2 order....");
    return batchOrderService.getOrder(2L);
  }


  @GET
  @Consumes(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON)
  @Produces(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON)
  public Order getOrderV1() {

    LOG.info("Returning v1 order....");
    return adhocOrderService.getOrder(1L);
  }




}
