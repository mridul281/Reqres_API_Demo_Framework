package com.internet.reqres_Api.tests.Configuration;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.baseURI;


public class BaseURL {

    @BeforeMethod
    public void beforeMethode() {
        baseURI = "https://reqres.in/";
    }

}
