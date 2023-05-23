package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GetAllUsersPagedDelayed {

    String parameter = "/users?delay=3";
    String page = "page=";
    int one = 1;

    String GET_AllUsersPaged_Delay_EndPoint = Resources.Service_End_Point + Resources.Resource_End_Point + parameter + page + one;

    @Test
    public void getAllUsersPagedDelayed() {
        System.out.println("GETAllUsersPagedDelay_EndPoint: " + GET_AllUsersPaged_Delay_EndPoint);

        Response getAllUsersPagedDelayed = given().
                when().
                get(GET_AllUsersPaged_Delay_EndPoint);
        getAllUsersPagedDelayed.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Successfull_Status_Code)
                .body("page", equalTo(1),
                        "per_page", equalTo(6),
                        "total", equalTo (12),
                        "total_pages", equalTo (2));
    }
}
