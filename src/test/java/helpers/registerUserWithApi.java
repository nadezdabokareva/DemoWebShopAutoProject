package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.User;

import static data.Endpoints.register;
import static global.WebShopSetUpBasePage.BASE_URL;

public class registerUserWithApi {

    public Response registerUser(User user){
        Response registerUserResponse = RestAssured
                .given()
                .body(user)
                .post(BASE_URL + register)
                .then()
                .extract()
                .response();
        return registerUserResponse;
    }

}
