package baseClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RateLimit {

    private int coreLimit;
    private String searchLimit;

    public int getCoreLimit() {
        return coreLimit;
    }

    public String getSearchLimit() {
        return searchLimit;
    }

    //Create method for nested JSON
    @JsonProperty("resources")
    private void unmarshallNested(Map<String, Object> resources) {
        Map<String, Integer> core = (Map<String, Integer>) resources.get("core");
        coreLimit = core.get("limit");

    }
}
