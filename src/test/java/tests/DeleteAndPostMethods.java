package tests;

import baseMethods.BaseClass;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.krb5.Credentials;

import java.io.IOException;

public class DeleteAndPostMethods extends BaseClass {

    @Test
    public void deleteIsSuccessful() throws IOException {
        HttpDelete request = new HttpDelete("https://api.github.com/repos/emindedic/deleteMe");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + TOKEN);

        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatusCode, 204);




    }
}
