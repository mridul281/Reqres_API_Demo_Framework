package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Utilities.Resources;
import io.restassured.response.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
public class GetSingleUserNotFound {

    String parameter = "/users/23";
    String GET_SingleUsers_NotFound_EndPoint = Resources.Service_End_Point + Resources.Resource_End_Point + parameter;

    @Test
    public void getSingleUserNotFound() {
        System.out.println("GET_SingleUsers_NotFound_EndPoint: " + GET_SingleUsers_NotFound_EndPoint);

        Response getSingleUserNotFound = given().
                when().
                get(GET_SingleUsers_NotFound_EndPoint);
        getSingleUserNotFound.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Clint_Error_Not_Found);
    }
}
