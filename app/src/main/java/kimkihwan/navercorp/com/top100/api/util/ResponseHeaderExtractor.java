package kimkihwan.navercorp.com.top100.api.util;

import com.fasterxml.jackson.databind.JsonNode;

import kimkihwan.navercorp.com.top100.exception.ApiProtocolException;

/**
 * Created by jamie on 2017. 6. 11..
 */

public class ResponseHeaderExtractor extends HeaderExtractor {

    private final static String KEY_HEADER = "header";

    private final static String KEY_CODE = "code";
    private final static String KEY_MESSAGE = "message";

    private final static int SUCCESS = 1;

    @Override
    public void extract(JsonNode root) throws ApiProtocolException {
        JsonNode head = root.path(KEY_HEADER);
        if (head.isMissingNode()) {
            throw new ApiProtocolException("header must be contained.");
        }
        int code = head.path(KEY_CODE).asInt();
        if (isSucceeded(code) == false) {
            String message = head.path(KEY_MESSAGE).asText();
            throw new ApiProtocolException(message);
        }
    }

    private boolean isSucceeded(int code) {
        return code == SUCCESS;
    }
}
