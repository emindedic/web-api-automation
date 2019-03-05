package tests;

import base.BaseClass;
import base.ResponseUtils;
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

import static base.ResponseUtils.getHeader;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ResponseHeaders extends BaseClass {


    @Test
    public  void contentTypeJSON() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        Header contentType = response.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");
        ContentType content = ContentType.getOrDefault(response.getEntity());
        assertEquals(content.getMimeType(), "application/json");
    }

    // Check server name
    @Test
    public void  serverIsGithub() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        String headerValue = getHeader(response, "Server");
        assertEquals(headerValue,"GitHub.com");
    }

    @Test
    public void XRayLimitIsSixty() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        String limitVal = ResponseUtils.getHeaderJava8(response, "X-RateLimit-Limit" );
        assertEquals(limitVal, "60");
    }

    @Test
    public void eTagResponse() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        boolean tagIsPresent = ResponseUtils.headerIsPresent(response, "ETag");
        assertTrue(tagIsPresent);
    }
}
