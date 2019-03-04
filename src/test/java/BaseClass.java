import com.sun.tools.internal.ws.processor.model.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.testng.annotations.DataProvider;


import java.io.Closeable;


public class BaseClass {
    protected static final String BASE_ENDPOINT = "https://api.github.com";

    CloseableHttpClient client;
    CloseableHttpResponse response;



}
