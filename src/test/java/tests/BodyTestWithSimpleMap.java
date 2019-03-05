package tests;

import base.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static base.User.ID;
import static base.User.LOGIN;


public class BodyTestWithSimpleMap extends BaseClass {

    @Test
    public void returnCorrectLogin() throws IOException {

        HttpGet getBody = new HttpGet(BASE_ENDPOINT + "/users/emindedic");
        response = client.execute(getBody);

        String jsonBody = EntityUtils.toString(response.getEntity());
        System.out.println(response);


        JSONObject jsonObject = new JSONObject(jsonBody);

        String loginValue = (String) getValueFor(jsonObject, LOGIN);
        Assert.assertEquals(loginValue, "emindedic");
    }


    @Test
    public void returnCorrectId() throws IOException {

        HttpGet getBody = new HttpGet(BASE_ENDPOINT + "/users/emindedic");
        response = client.execute(getBody);

        String jsonBody = EntityUtils.toString(response.getEntity());
        System.out.println(response);

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer loginValue = (Integer) getValueFor(jsonObject, ID);
        Assert.assertEquals(loginValue, Integer.valueOf(5750725));
    }

    private Object getValueFor(JSONObject jsonObject, String login) {
        return jsonObject.get(login);
    }
}
