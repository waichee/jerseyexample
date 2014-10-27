package org.wai.service

import org.wai.domain.Order
import spock.lang.Specification;


class AdhocOrderServiceSpec extends Specification {

  OrderService orderService;

  def setup() {
    orderService = new AdhocOrderService();
  }


  def "should return order by id"() {
    given:
    Long orderId = 2L

    when:
    def result = orderService.getOrder(orderId)

    then:
    result.orderId == orderId
    result.address == AdhocOrderService.ADHOC_ADDRESS
    result.name == "John Smith"
  }

  def "should validate order when the details required is valid"() {
    given:
    def order = new Order()

    and:
    order.setOrderId(orderId)

    when:
    def result = orderService.isValid(order)

    then:
    result == expectedResult

    where:
    orderId         |  expectedResult
    1L              |  true
    null            |  false
    "10".toLong()  |  true
  }


}