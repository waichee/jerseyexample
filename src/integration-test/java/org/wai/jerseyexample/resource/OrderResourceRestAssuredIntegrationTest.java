package org.wai.jerseyexample.resource;


import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.wai.BaseRestAssuredIntegrationTest;
import org.wai.jerseyexample.VersionedMediaType;
import org.wai.jerseyexample.service.AdhocOrderService;
import org.wai.jerseyexample.service.BatchOrderService;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Integration test using REST assured library
 *
 * To run this tests, the REST service needs to be running
 * As part of the gradle build, jetty will run up the war before executing the integration tests
 * Refer to build.gradle integrationTest task for further info
 */
public class OrderResourceRestAssuredIntegrationTest extends BaseRestAssuredIntegrationTest {

  @Test
  public void testGetOrderHeaderV1() throws Exception {
    given().header("accept", VersionedMediaType.JERSEY_EXAMPLE_V1_JSON).
        expect().statusCode(HttpStatus.OK.value()).
        response().headers("Content-Type", VersionedMediaType.JERSEY_EXAMPLE_V1_JSON).
        body(
            "orderId", equalTo(1),
            "name", equalTo(AdhocOrderService.DEFAULT_NAME),
            "address", equalTo(AdhocOrderService.ADHOC_ADDRESS)).
        when().get(API_BASE_URL + "/order/1");



  }

  @Test
  public void testGetOrderHeaderV2() throws Exception {

    given().header("accept", VersionedMediaType.JERSEY_EXAMPLE_V2_JSON).
        expect().statusCode(HttpStatus.OK.value()).
        response().headers("Content-Type", VersionedMediaType.JERSEY_EXAMPLE_V2_JSON).
        body(
            "orderId", equalTo(10),
            "name", equalTo(BatchOrderService.BATCH_NAME),
            "address", equalTo(BatchOrderService.BATCH_ADDRESS)).
        when().get(API_BASE_URL + "/order/10");


  }


}
