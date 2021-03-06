package org.med;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AlarmsResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/alarms/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Alarms resource!!"));
    }

}