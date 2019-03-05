package tests;

import baseClasses.RateLimit;
import baseMethods.BaseClass;
import baseClasses.NotFound;
import baseClasses.User;
import baseMethods.ResponseUtils;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static baseMethods.ResponseUtils.unmarshall;
import static baseMethods.ResponseUtils.unmarshallGeneric;
import static org.testng.AssertJUnit.assertEquals;

public class BodyTestWithJacksonLib extends BaseClass {

    @Test
    public void returnCorrectLogin() throws IOException {
        HttpGet get =  new HttpGet(BASE_ENDPOINT + "/users/emindedic");

        response = client.execute(get);

        User user = unmarshall(response, User.class);

        Assert.assertEquals(user.getLogin(), "emindedic");
    }

    @Test
    public void returnCorrectId() throws IOException {
        HttpGet get =  new HttpGet(BASE_ENDPOINT + "/users/emindedic");

        response = client.execute(get);

        User user = unmarshall(response, User.class);

        Assert.assertEquals(user.getId(), 5750725);
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {
        HttpGet get =  new HttpGet(BASE_ENDPOINT + "/users/emindedic45");

        response = client.execute(get);

        NotFound notFound = unmarshallGeneric(response, NotFound.class);

        Assert.assertEquals(notFound.getMessage(), "Not Found");
    }

    @Test
    public void correctRateLimitAreSet() throws IOException {
        HttpGet get =  new HttpGet(BASE_ENDPOINT + "/rate_limit");

        response = client.execute(get);

        RateLimit rateLimit = ResponseUtils.unmarshallGeneric(response, RateLimit.class);

        assertEquals(rateLimit.getCoreLimit(), 60);
    }
}
