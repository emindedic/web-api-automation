package tests;

import base.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import java.io.IOException;

public class BodyTestWithSimpleMap extends BaseClass {

    @Test
    public void returnCorrectLogin() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/emindedic");
        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());
        System.out.println(jsonBody);

    }

}
