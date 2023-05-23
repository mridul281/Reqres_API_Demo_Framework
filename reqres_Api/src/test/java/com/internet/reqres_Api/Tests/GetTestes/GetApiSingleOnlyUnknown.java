package com.internet.reqres_Api.Tests.GetTestes;

import com.internet.reqres_Api.Tests.Utilities.GlobalData;
import com.internet.reqres_Api.Tests.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GetApiSingleOnlyUnknown {
    String parameter = "/unknown/2";

    String GET_Api_SingleUnknown_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void getApiSingleOnlyUnknown() {
        System.out.println("GETApiSingleUnknownEndPoint: " + GET_Api_SingleUnknown_EndPoint);


        Response getApiSingleOnlyUnknown = given().
                when().
                get(GET_Api_SingleUnknown_EndPoint);
        getApiSingleOnlyUnknown.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Successfull_Status_Code).log().all()
                .body("data.id", equalTo(2))
                .body("data.name", equalTo("fuchsia rose"))
                .body("data.year", equalTo(2001))
                .body("data.color", equalTo("#C74375"))
                .body("data.pantone_value", equalTo("17-2031"));


    }
}
