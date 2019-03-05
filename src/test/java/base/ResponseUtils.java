package base;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ResponseUtils {

    public static String getHeader(CloseableHttpResponse response, String headerName) {

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
            throw new RuntimeException("Didn't find the header: " + headerName);
        }

        //Return header
        return returnHeader;
    }

    //Get all headers on easier way
    public static String getHeaderJava8(CloseableHttpResponse response, String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchHeaders = (Header) httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Didn't find a header"));

                return matchHeaders.getValue();
    }


    //Check if header returns Etag
    public static boolean headerIsPresent(CloseableHttpResponse response, String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        return httpHeaders.stream()
                .anyMatch(header -> header.getName().equalsIgnoreCase(headerName));

    }



    //Unmarshall method

    public static User unmarshall(CloseableHttpResponse response, Class<User> userClass) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                // Tell Jackson to not fail if it finds unused fields
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

                .readValue(jsonBody, userClass);
    }

    //HAve to make generic class
    public static <T> T unmarshallGeneric(CloseableHttpResponse response, Class<T> userClass) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                // Tell Jackson to not fail if it finds unused fields
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

                .readValue(jsonBody, userClass);
    }

}
