package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Protocol_Design.PostUtils;
import com.internet.reqres_Api.tests.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PutUpdateTest {
    String parameter = "/users/2";

    String PUT_Update_EndPoint = Resources.Service_End_Point + Resources.Resource_End_Point + parameter;

    @Test
    public void putUpdateTest() {

        System.out.println("PUTUpdate_EndPoint: " + PUT_Update_EndPoint);


        Response putUpdateTest = given().
                contentType("application/json")
                .body(PostUtils.json_Put_Update)
                .when()
                .put(PUT_Update_EndPoint);
        putUpdateTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Successfull_Status_Code)
                .body("name", equalTo("mridul"))
                .body("job", equalTo("junior qa"));



    }
}
