package tests;

import baseMethods.BaseClass;
import baseMethods.ResponseUtils;
import org.apache.http.client.methods.HttpOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Options204 extends BaseClass {

    //Test which method is supported
    @Test
    public void optionsReturnsCorrectMEthodList() throws IOException {
        String header = "Access-Control-Allow-Methods";
        String expectedReply = "GET, POST, PATCH, PUT, DELETE";

        HttpOptions request = new HttpOptions(BASE_ENDPOINT);
        response = client.execute(request);

        String actualValue = ResponseUtils.getHeader(response,header);

        Assert.assertEquals(actualValue, expectedReply);
    }
}
