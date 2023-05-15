package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Configuration.BaseURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GetAllUsersPagedDelayed extends BaseURL {

    @Test
    public void getAllUsersPagedDelayed() {
        Response getAllUsersPagedDelayed = given().
                when().
                get("https://reqres.in/api/users?delay=3");
        getAllUsersPagedDelayed.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200)
                .body("page", equalTo(1),
                        "per_page", equalTo(6),
                        "total", equalTo (12),
                        "total_pages", equalTo (2));
    }
}
