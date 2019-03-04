import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ResponseHeaders extends BaseClass {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;

    @BeforeMethod
    public void  setup() {
        client = HttpClientBuilder.create().build();
    }


    @AfterMethod
    public  void closeResources() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public  void contentTypeJSON() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        Header contentType = response.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        ContentType content = ContentType.getOrDefault(response.getEntity());
        assertEquals(content.getMimeType(), "application/json");
    }

}
