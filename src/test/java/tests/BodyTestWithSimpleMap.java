//import base.BaseClass;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//
//import java.io.IOException;
//
//public class BodyTestWithSimpleMap extends BaseClass {
//
//    private CloseableHttpResponse response;
//
//
//    @Test
//    public void returnCorrectLogin() throws IOException {
//
//        HttpGet get = new HttpGet(BASE_ENDPOINT + "/emindedic");
//
//        response = client.execute(get);
//
//        String jsoBody = EntityUtils.toString(response.getEntity());
//        System.out.println(jsoBody);
//
//    }
//
//}
