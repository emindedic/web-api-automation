import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

public class Get404 {
    public static final String BASE_ENDPOINT = "https://api.github.com";

    HttpClient client = HttpClientBuilder.create().build();

    @Test
    public void nonExistingUrlReturns404() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonexistingurl");
        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actuasStatus,404);
    }


}
