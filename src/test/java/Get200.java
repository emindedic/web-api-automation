import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

public class Get200 extends BaseClass {


    HttpClient client = HttpClientBuilder.create().build();

    @Test
    public void baseUrlReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actuasStatus,200);

    }

    @Test
    public void rateLimitReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");

        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actuasStatus,200);

    }

    @Test
    public void searchRepoReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");

        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actuasStatus,200);

    }





}
