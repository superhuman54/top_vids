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

    private static final ObjectMapper sMapper = new ObjectMapper();
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
            root = sMapper.readTree(response.data);
            mHeaderExtractor.extract(root);
            responsePayload = parse(root);
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        } catch (ApiProtocolException e) {
            return Response.error(new ParseError(e));
        }
        return Response.success(responsePayload,
                HttpHeaderParser.parseCacheHeaders(response));
    }

    protected abstract T parse(JsonNode root);

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
