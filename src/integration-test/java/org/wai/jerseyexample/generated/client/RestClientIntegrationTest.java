package org.wai.jerseyexample.generated.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wai.jerseyexample.domain.Order;
import org.wai.jerseyexample.service.AdhocOrderService;
import org.wai.jerseyexample.service.BatchOrderService;

import static org.junit.Assert.assertTrue;


/**
 * To run this tests, the REST service needs to be running
 * As part of the gradle build, jetty will run up the war before executing the integration tests
 * Refer to build.gradle integrationTest task for further info
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class RestClientIntegrationTest {

  @Test
  public void shouldGetOrderV1() throws Exception{

    Order order = RestClient.order().orderId(111L).getAsVndOrgWaiJerseyexampleV1Json(Order.class);
    assertTrue(order.getOrderId().equals(111L));
    assertTrue(order.getAddress().equals(AdhocOrderService.ADHOC_ADDRESS));
    assertTrue(order.getName().equals(AdhocOrderService.DEFAULT_NAME));
  }



  @Test
  public void shouldGetOrderV2() throws Exception{

    Order order = RestClient.order().orderId(1L).getAsVndOrgWaiJerseyexampleV2Json(Order.class);
    assertTrue(order.getOrderId().equals(1L));
    assertTrue(order.getAddress().equals(BatchOrderService.BATCH_ADDRESS));
    assertTrue(order.getName().equals(BatchOrderService.BATCH_NAME));
  }

}
