package tests;

import baseMethods.BaseClass;
import baseMethods.Credentials;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class DeleteAndPostMethods extends BaseClass {

    //Test delete request
    @Test
    public void deleteIsSuccessful() throws IOException {
        HttpDelete request = new HttpDelete("https://api.github.com/repos/emindedic/proba");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatusCode, 204);
    }

    //Test post request
    @Test
    public void createRepoReturn201() throws IOException {

        //Create an HttpPost with a valid endpoint
        HttpPost request = new HttpPost("https://api.github.com/user/repos");

        // Set the Basic Auth Header
        String auth = Credentials.EMAIL + ":" + Credentials.PASSWORD;

        //Encrypt password
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);


        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        // Define JSON to Post and set as Entity
        String json = "{\"name\": \"proba\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        //Send it
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 201);



    }
}
