package org.wai.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wai.domain.Order;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class BatchOrderServiceIntegrationTest {

  @Autowired
  OrderService<BatchOrderService> batchOrderService;


  @Test
  public void testGetOrder(){

    Long orderId = 123L;
    Order order = batchOrderService.getOrder(orderId);

    assertTrue(order.getOrderId() == orderId);
    assertTrue(BatchOrderService.BATCH_ADDRESS.equals(order.getAddress()));
    assertTrue("John Smith".equals(order.getName()));
  }

  @Test
  public void shouldValidateOrder(){
    Order validOrder = new Order();
    validOrder.setOrderId(11L);
    validOrder.setAddress(BatchOrderService.BATCH_ADDRESS);
    assertTrue(batchOrderService.isValid(validOrder));

    Order invalidOrder = new Order();
    validOrder.setOrderId(11L);
    validOrder.setAddress("Wrong address");
    assertFalse(batchOrderService.isValid(invalidOrder));

  }

}
