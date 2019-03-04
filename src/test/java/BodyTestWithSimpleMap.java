import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLOutput;

public class BodyTestWithSimpleMap extends BaseClass {

    @Test
    public void returnCorrectLogin() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/emindedic");

        response = client.execute(get);

        String jsoBody = EntityUtils.toString(response.getEntity());
        System.out.println(jsoBody);

    }

}
