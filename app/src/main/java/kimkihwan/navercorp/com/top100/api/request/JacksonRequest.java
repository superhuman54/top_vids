package kimkihwan.navercorp.com.top100.api.request;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kimkihwan.navercorp.com.top100.api.util.HeaderExtractor;
import kimkihwan.navercorp.com.top100.exception.ApiProtocolException;

/**
 * Created by jamie on 2017. 6. 11..
 */

public abstract class JacksonRequest<T> extends Request<T> {

    private final static String TAG = JacksonRequest.class.getSimpleName();

    private final static String KEY_ENTRY_HEAD = "header";
    private final static String KEY_ENTRY_BODY = "body";

    protected ObjectMapper mMapper = new ObjectMapper();
    private HeaderExtractor mHeaderExtractor;

    private final Response.Listener<T> mListener;

    public JacksonRequest(int method,
                          String url,
                          Response.Listener<T> listener,
                          Response.ErrorListener errorListener,
                          HeaderExtractor extractor) {
        super(method, url, errorListener);
        mListener = listener;
        mHeaderExtractor = extractor;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=UTF-8");
        return header;
    }

    @Override
    protected final Response<T> parseNetworkResponse(NetworkResponse response) {
        JsonNode root = null;
        T responsePayload = null;
        try {
            root = mMapper.readTree(response.data);
            JsonNode header = root.path(KEY_ENTRY_HEAD);
            if (header.isMissingNode()) {
                throw new ApiProtocolException("header must be contained.");
            }
            mHeaderExtractor.extract(header);
            JsonNode body = root.path(KEY_ENTRY_BODY);
            if (body.isMissingNode()) {
                throw new ApiProtocolException("body must be contained.");
            }
            responsePayload = parse(body);
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        } catch (ApiProtocolException e) {
            return Response.error(new ParseError(e));
        }
        return Response.success(responsePayload,
                HttpHeaderParser.parseCacheHeaders(response));
    }

    protected abstract T parse(JsonNode body);

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
