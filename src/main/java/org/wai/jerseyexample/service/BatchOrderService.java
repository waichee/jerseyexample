package org.wai.jerseyexample.service;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.wai.jerseyexample.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


//Stubbing the response as we're not building the persistence for our domains yet....
//No database are added yet
@Service
public class BatchOrderService implements OrderService {

  public static final Integer BATCH_SIZE  = 100;

  public static final String BATCH_ADDRESS= "LA";

  public static final String BATCH_NAME= "Mary";


  public Order getOrder(Long orderId) {
    Order myOrder = createDefaultOrder();
    myOrder.setOrderId(orderId);
    myOrder.setAddress(BATCH_ADDRESS);
    return myOrder;
  }


  public List<Order> findAllOrders() {
    List<Order> orders = new ArrayList<>();
    for(int i = 0; i < BATCH_SIZE; i++){
      orders.add(getOrder((long)i));
    }

    return orders;
  }

  @Override
  public Order modifyOrder(Order order) {
    Preconditions.checkArgument(order != null, "Cant modify null order!");
    Function<Integer, String> intToString = String::valueOf;
    Function<Order, Order> appendNameFunction = (o) -> {
      o.setDescription("Default batch size is:" + intToString.apply(BATCH_SIZE));
      return  o;
    };
    return appendNameFunction.apply(order);
  }

  public boolean isValid(Order order) {
    Predicate<Order> orderPredicate = (o) -> o.getOrderId() != null && BATCH_ADDRESS.equals(o.getAddress());
    OrderValidator validator = (i) ->  orderPredicate.test(i);    //or we could just return orderPredicate.test()
    return validator.isValid(order);

  }

  @Override
  public Order createDefaultOrder(){
    Order order = new Order();
    order.setName(BATCH_NAME);
    return order;
  }


}
