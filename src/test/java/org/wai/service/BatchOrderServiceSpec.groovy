package org.wai.service

import spock.lang.Specification;


class BatchOrderServiceSpec extends Specification {

  OrderService orderService;

  def setup() {
    orderService = new BatchOrderService();
  }


  def "should return order by id"() {
    given:
    Long orderId = 1L

    when:
    def result = orderService.getOrder(orderId)

    then:
    result.orderId == orderId
    result.address == BatchOrderService.BATCH_ADDRESS
    result.name == "John Smith"
  }

  def "should validate order when the details required is valid"() {
    given:
    Long orderId = 1L
    def order = orderService.getOrder(orderId)

    and:
    order.setAddress(addressInput)

    when:
    def result = orderService.isValid(order)

    then:
    result == expectedResult

    where:
    addressInput                      | expectedResult
    BatchOrderService.BATCH_ADDRESS   | true
    null                              | false
    "bla"                             | false
    "Tiny village"                    | false
  }


}