package tests;

import base.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class Get200 extends BaseClass {


    HttpClient client = HttpClientBuilder.create().build();


    @DataProvider
    private Object [][] endpoints() {
        return new Object[][] {
                {""},
                {"/rate_limit"},
                {"/search/repositories?q=java"}};
    }



    @Test(dataProvider = "endpoints")
    public void returns200(String endpoint) throws IOException {

        HttpGet get = new HttpGet(BaseClass.BASE_ENDPOINT + endpoint);
        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actuasStatus,200);
    }




}
