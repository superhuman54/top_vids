package kimkihwan.navercorp.com.top100.api.util;

import com.fasterxml.jackson.databind.JsonNode;

import kimkihwan.navercorp.com.top100.exception.ApiProtocolException;

/**
 * Created by jamie on 2017. 6. 11..
 */

public abstract class HeaderExtractor {

    public abstract void extract(JsonNode root) throws ApiProtocolException;

}
