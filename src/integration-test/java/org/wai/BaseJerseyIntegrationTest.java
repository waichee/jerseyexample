package org.wai;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import javax.ws.rs.core.Application;

public abstract class BaseJerseyIntegrationTest extends JerseyTest {

  @Override
  protected Application configure() {
    enable(TestProperties.LOG_TRAFFIC);
    enable(TestProperties.DUMP_ENTITY);
    ResourceConfig rc = initConfig();
    rc.property("contextConfigLocation", "classpath:spring/applicationContext.xml");
    return rc;
  }

  protected abstract ResourceConfig initConfig();
}
