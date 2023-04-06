package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@QuarkusTest
public class GreetingResourceTest {

    @ConfigProperty(name = "url.web-base", defaultValue = "") 
    String url;

    @ConfigProperty(name = "url-base.web-base") 
    String urlBase;


    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is(String.format("Hello from RESTEasy Reactive: %s urlBase: %sv", url, urlBase)));
    }

}