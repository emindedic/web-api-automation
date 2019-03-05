package base;

import com.sun.tools.internal.ws.processor.model.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import java.io.Closeable;
import java.io.IOException;


public class BaseClass {

    protected static final String BASE_ENDPOINT = "https://api.github.com";

    protected CloseableHttpClient client;
    protected CloseableHttpResponse response;


    @BeforeMethod
    public void  setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public  void closeResources() throws IOException {
        client.close();
        response.close();
    }
}
