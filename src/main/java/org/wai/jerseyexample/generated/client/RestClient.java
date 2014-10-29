package org.wai.jerseyexample.generated.client;

import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.PostConstruct;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configurable;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.uri.UriTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.wai.jerseyexample.VersionedMediaType;

/**
 * Modified from the Generated code using WADL2java tool
 * https://wadl.java.net/wadl2java.html
 *
 * This generated code could still use some refactoring and customization...
 */
@Component
@Generated(value = {
    "wadl|file:/user/home/application.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2014-10-29T19:43:19.405+11:00")
public class RestClient {

  /**
   * The base URI for the resource represented by this proxy
   *
   */
  public static URI BASE_URI;


  @Value("${rest.service.uri}")
  private String serviceUri;


  @PostConstruct
  public void init() {
    URI originalURI = URI.create(serviceUri);
    // Look up to see if we have any indirection in the local copy
    // of META-INF/java-rs-catalog.xml file, assuming it will be in the
    // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
    try (InputStream is = RestClient.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml")) {
      if (is != null) {

        // Ignore the namespace in the catalog, can't use wildcard until
        // we are sure we have XPath 2.0
        String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
            "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI + "']/@uri",
            new org.xml.sax.InputSource(is));
        if (found != null && found.length() > 0) {
          originalURI = java.net.URI.create(found);
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    BASE_URI = originalURI;
  }

  public static RestClient.Order order(Client client, URI baseURI) {
    return new RestClient.Order(client, baseURI);
  }

  /**
   * Template method to allow tooling to customize the new Client
   *
   */
  private static void customizeClientConfiguration(Configurable cc) {
  }

  /**
   * Template method to allow tooling to override Client factory
   *
   */
  private static Client createClientInstance() {
    return ClientBuilder.newClient();
  }

  /**
   * Create a new Client instance
   *
   */
  public static Client createClient() {
    Client client = createClientInstance();
    customizeClientConfiguration(client);
    return client;
  }

  public static RestClient.Order order() {
    return order(createClient(), BASE_URI);
  }

  public static RestClient.Order order(Client client) {
    return order(client, BASE_URI);
  }

  public static class Order {

    private Client _client;
    private UriBuilder _uriBuilder;
    private Map<String, Object> _templateAndMatrixParameterValues;

    private Order(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
      _client = client;
      _uriBuilder = uriBuilder.clone();
      _templateAndMatrixParameterValues = map;
    }

    /**
     * Create new instance using existing Client instance, and a base URI and any parameters
     *
     */
    public Order(Client client, URI baseUri) {
      _client = client;
      _uriBuilder = UriBuilder.fromUri(baseUri);
      _uriBuilder = _uriBuilder.path("/order");
      _templateAndMatrixParameterValues = new HashMap<String, Object>();
    }

    public<T >T getAsJson(GenericType<T> returnType) {
      UriBuilder localUriBuilder = _uriBuilder.clone();
      WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
      javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request("application/json");
      Response response;
      response = resourceBuilder.build("GET").invoke();
      if (response.getStatus()>= 400) {
        throw new RestClient.WebApplicationExceptionMessage(response);
      }
      return response.readEntity(returnType);
    }

    public<T >T getAsJson(Class<T> returnType) {
      UriBuilder localUriBuilder = _uriBuilder.clone();
      WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
      javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request("application/json");
      Response response;
      response = resourceBuilder.build("GET").invoke();
      if (!Response.class.isAssignableFrom(returnType)) {
        if (response.getStatus()>= 400) {
          throw new RestClient.WebApplicationExceptionMessage(response);
        }
      }
      if (!Response.class.isAssignableFrom(returnType)) {
        return response.readEntity(returnType);
      } else {
        return returnType.cast(response);
      }
    }

    public<T >T getAsVndOrgWaiJerseyexampleV2Json(GenericType<T> returnType) {
      UriBuilder localUriBuilder = _uriBuilder.clone();
      WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
      javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request("application/vnd.org.wai.jerseyexample-v2+json");
      Response response;
      response = resourceBuilder.build("GET").invoke();
      if (response.getStatus()>= 400) {
        throw new RestClient.WebApplicationExceptionMessage(response);
      }
      return response.readEntity(returnType);
    }

    public<T >T getAsVndOrgWaiJerseyexampleV2Json(Class<T> returnType) {
      UriBuilder localUriBuilder = _uriBuilder.clone();
      WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
      javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request("application/vnd.org.wai.jerseyexample-v2+json");
      Response response;
      response = resourceBuilder.build("GET").invoke();
      if (!Response.class.isAssignableFrom(returnType)) {
        if (response.getStatus()>= 400) {
          throw new RestClient.WebApplicationExceptionMessage(response);
        }
      }
      if (!Response.class.isAssignableFrom(returnType)) {
        return response.readEntity(returnType);
      } else {
        return returnType.cast(response);
      }
    }

    public RestClient.Order.OrderId orderId(Long orderid) {
      return new RestClient.Order.OrderId(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), orderid);
    }

    public static class OrderId {

      private Client _client;
      private UriBuilder _uriBuilder;
      private Map<String, Object> _templateAndMatrixParameterValues;

      private OrderId(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
        _client = client;
        _uriBuilder = uriBuilder.clone();
        _templateAndMatrixParameterValues = map;
      }

      /**
       * Create new instance using existing Client instance, and a base URI and any parameters
       *
       */
      public OrderId(Client client, URI baseUri, Long orderid) {
        _client = client;
        _uriBuilder = UriBuilder.fromUri(baseUri);
        _uriBuilder = _uriBuilder.path("/{orderId}");
        _templateAndMatrixParameterValues = new HashMap<String, Object>();
        _templateAndMatrixParameterValues.put("orderId", orderid);
      }

      /**
       * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
       *
       */
      public OrderId(Client client, URI uri) {
        _client = client;
        StringBuilder template = new StringBuilder(BASE_URI.toString());
        if (template.charAt((template.length()- 1))!= '/') {
          template.append("/order/{orderId}");
        } else {
          template.append("order/{orderId}");
        }
        _uriBuilder = UriBuilder.fromPath(template.toString());
        _templateAndMatrixParameterValues = new HashMap<String, Object>();
        UriTemplate uriTemplate = new UriTemplate(template.toString());
        HashMap<String, String> parameters = new HashMap<String, String>();
        uriTemplate.match(uri.toString(), parameters);
        _templateAndMatrixParameterValues.putAll(parameters);
      }

      /**
       * Get orderId
       *
       */
      public Long getOrderid() {
        return ((Long) _templateAndMatrixParameterValues.get("orderId"));
      }

      /**
       * Duplicate state and set orderId
       *
       */
      public RestClient.Order.OrderId setOrderid(Long orderid) {
        Map<String, Object> copyMap;
        copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
        UriBuilder copyUriBuilder = _uriBuilder.clone();
        copyMap.put("orderId", orderid);
        return new RestClient.Order.OrderId(_client, copyUriBuilder, copyMap);
      }

      public<T >T getAsJson(GenericType<T> returnType) {
        UriBuilder localUriBuilder = _uriBuilder.clone();
        WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request("application/json");
        Response response;
        response = resourceBuilder.build("GET").invoke();
        if (response.getStatus()>= 400) {
          throw new RestClient.WebApplicationExceptionMessage(response);
        }
        return response.readEntity(returnType);
      }

      public<T >T getAsJson(Class<T> returnType) {
        UriBuilder localUriBuilder = _uriBuilder.clone();
        WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request("application/json");
        Response response;
        response = resourceBuilder.build("GET").invoke();
        if (!Response.class.isAssignableFrom(returnType)) {
          if (response.getStatus()>= 400) {
            throw new RestClient.WebApplicationExceptionMessage(response);
          }
        }
        if (!Response.class.isAssignableFrom(returnType)) {
          return response.readEntity(returnType);
        } else {
          return returnType.cast(response);
        }
      }

      public<T >T getAsVndOrgWaiJerseyexampleV2Json(GenericType<T> returnType) {
        UriBuilder localUriBuilder = _uriBuilder.clone();
        WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request(VersionedMediaType.JERSEY_EXAMPLE_V2_JSON);
        Response response;
        response = resourceBuilder.build("GET").invoke();
        if (response.getStatus()>= 400) {
          throw new RestClient.WebApplicationExceptionMessage(response);
        }
        return response.readEntity(returnType);
      }

      public<T >T getAsVndOrgWaiJerseyexampleV2Json(Class<T> returnType) {
        UriBuilder localUriBuilder = _uriBuilder.clone();
        WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request(VersionedMediaType.JERSEY_EXAMPLE_V2_JSON);
        Response response;
        response = resourceBuilder.build("GET").invoke();
        if (!Response.class.isAssignableFrom(returnType)) {
          if (response.getStatus()>= 400) {
            throw new RestClient.WebApplicationExceptionMessage(response);
          }
        }
        if (!Response.class.isAssignableFrom(returnType)) {
          return response.readEntity(returnType);
        } else {
          return returnType.cast(response);
        }
      }

      public<T >T getAsVndOrgWaiJerseyexampleV1Json(GenericType<T> returnType) {
        UriBuilder localUriBuilder = _uriBuilder.clone();
        WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON);
        Response response;
        response = resourceBuilder.build("GET").invoke();
        if (response.getStatus()>= 400) {
          throw new RestClient.WebApplicationExceptionMessage(response);
        }
        return response.readEntity(returnType);
      }

      public<T >T getAsVndOrgWaiJerseyexampleV1Json(Class<T> returnType) {
        UriBuilder localUriBuilder = _uriBuilder.clone();
        WebTarget resource = _client.target(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        javax.ws.rs.client.Invocation.Builder resourceBuilder = resource.request(VersionedMediaType.JERSEY_EXAMPLE_V1_JSON);
        Response response;
        response = resourceBuilder.build("GET").invoke();
        if (!Response.class.isAssignableFrom(returnType)) {
          if (response.getStatus()>= 400) {
            throw new RestClient.WebApplicationExceptionMessage(response);
          }
        }
        if (!Response.class.isAssignableFrom(returnType)) {
          return response.readEntity(returnType);
        } else {
          return returnType.cast(response);
        }
      }

    }

  }


  /**
   * Workaround for JAX_RS_SPEC-312
   *
   */
  private static class WebApplicationExceptionMessage
      extends WebApplicationException
  {


    private WebApplicationExceptionMessage(Response response) {
      super(response);
    }

    /**
     * Workaround for JAX_RS_SPEC-312
     *
     */
    public String getMessage() {
      Response response = getResponse();
      Response.Status status = Response.Status.fromStatusCode(response.getStatus());
      if (status!= null) {
        return (response.getStatus()+(" "+ status.getReasonPhrase()));
      } else {
        return Integer.toString(response.getStatus());
      }
    }

    public String toString() {
      String s = "javax.ws.rs.WebApplicationException";
      String message = getLocalizedMessage();
      return (s +(": "+ message));
    }

  }

}
