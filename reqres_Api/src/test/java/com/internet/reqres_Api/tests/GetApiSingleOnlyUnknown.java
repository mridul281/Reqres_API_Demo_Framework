package com.internet.reqres_Api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GetApiSingleOnlyUnknown {

    @Test
    public void getApiSingleOnlyUnknown() {

        Response getApiSingleOnlyUnknown = given().
                when().
                get("https://reqres.in/api/unknown/2");
        getApiSingleOnlyUnknown.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.name", equalTo("fuchsia rose"))
                .body("data.year", equalTo(2001))
                .body("data.color", equalTo("#C74375"))
                .body("data.pantone_value", equalTo("17-2031"));


    }
}
