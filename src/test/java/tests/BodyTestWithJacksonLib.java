package tests;

import base.BaseClass;
import base.ResponseUtils;
import base.User;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static base.ResponseUtils.unmarshall;

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
}
