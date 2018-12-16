import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

public class Get401 {
    public static final String BASE_ENDPOINT = "https://api.github.com";

    HttpClient client = HttpClientBuilder.create().build();

    @Test
    public void userReturns401() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user");
        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actuasStatus,401);
    }

    @Test
    public void userFolowersReturns404() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user/followers");
        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actuasStatus,401);
    }

    @Test
    public void notificationsReturns404() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/notifications");
        HttpResponse response = client.execute(get);

        int actuasStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actuasStatus,401);
    }
}
