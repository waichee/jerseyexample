package org.wai.jerseyexample;

/**
 * Custom media type for specifying the version of the REST API
 */
public class VersionedMediaType {

  private static final String JERSEY_EXAMPLE_TYPE_PREFIX = "application/vnd.org.wai.jerseyexample-";

  public static final String JERSEY_EXAMPLE_V1_JSON = JERSEY_EXAMPLE_TYPE_PREFIX + "v1+json";

  public static final String JERSEY_EXAMPLE_V2_JSON = JERSEY_EXAMPLE_TYPE_PREFIX + "v2+json";


}
