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
import java.util.Arrays;
import java.util.List;

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


    @Test
    public void  serverIsGithub() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        
        String headerValue = getHeader(response, "Server");
    }

    private String getHeader(CloseableHttpResponse response, String headerName) {

        //Get all headers
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";

        //Loop over headers list

        for (Header header : headers) {
            if(headerName.equalsIgnoreCase(header.getName())) {
                returnHeader = header.getValue();
            }
        }

        //If no header found - throw an exception
        if(returnHeader.isEmpty()) {
            throw new RuntimeException("Didn't fint the header: " + headerName);
        }

        //Return header
        return returnHeader;
    }


}
