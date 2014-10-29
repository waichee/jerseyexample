package org.wai.jerseyexample.resource;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import org.wai.BaseJerseyIntegrationTest;
import org.wai.jerseyexample.VersionedMediaType;
import org.wai.jerseyexample.domain.Order;
import org.wai.jerseyexample.service.AdhocOrderService;
import org.wai.jerseyexample.service.BatchOrderService;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

/**
 * Integration test using Jersey-test library
 */
public class OrderResourceIntegrationTest extends BaseJerseyIntegrationTest {


  @Override
  protected ResourceConfig initConfig() {
    return new ResourceConfig(OrderResource.class);
  }

  @Test
  public void testGetOrderList() throws Exception {
    GenericType<Collection<Order>> orderListType = new GenericType<Collection<Order>>(){};
    List<Order> orders = (List<Order>) target("order").request().accept(MediaType.APPLICATION_JSON_TYPE).get(orderListType);
    Assert.assertEquals(BatchOrderService.BATCH_SIZE.longValue(), orders.size());
    Assert.assertTrue(orders.parallelStream().allMatch((o) -> BatchOrderService.BATCH_NAME.equals(o.getName())));

  }


  @Test
  public void testGetOrder() throws Exception {
    Order order = target("order/10").request().accept(MediaType.APPLICATION_JSON_TYPE).get(Order.class);
    Assert.assertEquals(BatchOrderService.BATCH_NAME, order.getName());
    Assert.assertEquals(Long.valueOf(10L), order.getOrderId());

  }

  @Test
  public void testGetOrderWithVersionHeader() throws Exception {
    Order order = target("order/1").request().accept(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON).get(Order.class);
    Assert.assertEquals("John Smith", order.getName());
    Assert.assertEquals(Long.valueOf(1L), order.getOrderId());
    Assert.assertEquals(AdhocOrderService.ADHOC_ADDRESS, order.getAddress());


    order = target("order/2").request().accept(VersionedMediaType.JERSEY_EXAMPLE_V2_JSON).get(Order.class);
    Assert.assertEquals(Long.valueOf(2L), order.getOrderId());
    Assert.assertEquals(BatchOrderService.BATCH_ADDRESS, order.getAddress());

  }

}
