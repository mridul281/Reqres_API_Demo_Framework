package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Utilities.Resources;
import io.restassured.response.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetSingleUser {

    String parameter = "/users/2";

    String GET_Single_Users_EndPoint = Resources.Service_End_Point + Resources.Resource_End_Point + parameter;


    @Test
    public void getSingleUser() {
        System.out.println("GETSingleUsersEndPoint: " + GET_Single_Users_EndPoint);

        Response getSingleuser = given().
                when().
                get(GET_Single_Users_EndPoint);
        getSingleuser.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Successfull_Status_Code)
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));




    }

}
