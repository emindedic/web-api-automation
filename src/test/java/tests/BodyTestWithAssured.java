package tests;

import baseMethods.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static baseMethods.RestAssured.BASE_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class BodyTestWithAssured extends  RestAssured  {


    @Test
    public void gitHubMessageBody()
    {
        RestAssured.baseURI = BASE_ENDPOINT;
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/users/emindedic");

        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());

        assertEquals(200, response.getStatusCode());
    }
}
