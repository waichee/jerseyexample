package org.wai.jerseyexample.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.wai.jerseyexample.domain.Order;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class AdhocOrderService implements OrderService {

  public static final String ADHOC_ADDRESS= "Tiny village";

  //Stubbing the response as we're not building the persistence for our domains yet....
  public Order getOrder(Long orderId) {
    Order myOrder = createDefaultOrder();
    myOrder.setAddress(ADHOC_ADDRESS);
    myOrder.setOrderId(orderId);
    return myOrder;
  }

  public Order modifyOrder(Order order){
    Function<String, String> reverseFunction = (s)-> new StringBuilder(s).reverse().toString();
    Function<String, String> replaceSizeFunction = (s) -> StringUtils.replace(s, "Tiny", "Big");

    Function<Order, Order> modifyOrderFunction = (o)-> {
      o.setAddress(replaceSizeFunction.andThen(reverseFunction).apply(o.getAddress()));
      return o;
    };

    return  modifyOrderFunction.apply(order);
  }

  @Override
  public List<Order> findAllOrders() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }


  public boolean isValid(Order order) {
    Predicate<Order> orderPredicate = (o) -> o.getOrderId() != null && o.getOrderId() > 0;
    return orderPredicate.test(order);

  }


}
