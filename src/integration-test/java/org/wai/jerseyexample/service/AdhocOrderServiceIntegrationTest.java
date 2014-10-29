package org.wai.jerseyexample.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wai.jerseyexample.domain.Order;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class AdhocOrderServiceIntegrationTest {

  @Autowired
  OrderService<AdhocOrderService> adhocOrderService;

  @Test
  public void shouldValidateOrder(){
    Order validOrder = new Order();
    validOrder.setOrderId(11L);
    assertTrue(adhocOrderService.isValid(validOrder));

    Order invalidOrder = new Order();
    assertFalse(adhocOrderService.isValid(invalidOrder));

  }

}
