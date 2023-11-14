package com.icms;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {
    public static void main(String[] args) {

        // Login and generate token via RestAsssured
      RequestSpecification request =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
                .setContentType(ContentType.JSON).build();
        //it will help to build login object
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("kabindora@gmail.com");
        loginRequest.setUserPassword("Kale.Dai1122");


        RequestSpecification regLogin = given().log().all().spec(request).body(loginRequest);
         LoginResponse loginResponse = regLogin.when().post("/api/ecom/auth/login")
                                        .then().log().all().extract().response().as(LoginResponse.class);
         //it will print the token
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getUserId());


    }
}
