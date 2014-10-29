package org.wai;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import org.junit.BeforeClass;
import org.wai.jerseyexample.VersionedMediaType;

public abstract class BaseRestAssuredIntegrationTest {

  protected  static final String API_BASE_URL = "/jerseyexample/api";


  @BeforeClass
  public static void init(){
    RestAssured.registerParser(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON, Parser.JSON);
    RestAssured.registerParser(VersionedMediaType.JERSEY_EXAMPLE_V2_JSON, Parser.JSON);
  }

}
