package org.wai.resource;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import org.wai.domain.Order;
import org.wai.VersionedMediaType;
import org.wai.service.AdhocOrderService;
import org.wai.service.BatchOrderService;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

public class OrderResourceIntegrationTest extends JerseyTest {

  @Override
  protected Application configure() {
    enable(TestProperties.LOG_TRAFFIC);
    enable(TestProperties.DUMP_ENTITY);
    ResourceConfig rc = new ResourceConfig(OrderResource.class);
    rc.property("contextConfigLocation", "classpath:spring/applicationContext.xml");
    return rc;
  }

  @Test
  public void testGetOrder() throws Exception {
    Order order = target("order").request().accept(MediaType.APPLICATION_JSON_TYPE).get(Order.class);
    Assert.assertEquals("John Smith", order.getName());
    Assert.assertEquals(Long.valueOf(2L), order.getOrderId());

  }

  @Test
  public void testGetOrderWithVersionHeader() throws Exception {
    Order order = target("order").request().accept(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON).get(Order.class);
    Assert.assertEquals("John Smith", order.getName());
    Assert.assertEquals(Long.valueOf(1L), order.getOrderId());
    Assert.assertEquals(AdhocOrderService.ADHOC_ADDRESS, order.getAddress());


    order = target("order").request().accept(VersionedMediaType.JERSEY_EXAMPLE_V2_JSON).get(Order.class);
    Assert.assertEquals(Long.valueOf(2L), order.getOrderId());
    Assert.assertEquals(BatchOrderService.BATCH_ADDRESS, order.getAddress());

  }

}
