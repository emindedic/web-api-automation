package tests;

import baseMethods.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Get401 extends BaseClass {

    HttpClient client = HttpClientBuilder.create().build();

    @DataProvider
    private Object[][] endpoints() {
        return new Object[][] {

    //incorrect endpoints
    {"/user"},
    {"/user/followers"},
    {"/notification"}
        };
    }

    @Test(dataProvider = "endpoints")
    public void userReturns401(String endpoint) throws IOException {

        HttpGet get = new HttpGet(BaseClass.BASE_ENDPOINT + endpoint);
        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actuasStatus,401);
    }
}
