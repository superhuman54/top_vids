package kimkihwan.navercorp.com.top100.api.request;

import android.util.Log;

import com.android.volley.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import kimkihwan.navercorp.com.top100.api.EndPoints;
import kimkihwan.navercorp.com.top100.api.response.ClipInfoResponse;
import kimkihwan.navercorp.com.top100.api.util.ResponseHeaderExtractor;

/**
 * Created by jamie on 2017. 6. 20..
 */

public class GetVodEndClipRequest extends JacksonRequest<ClipInfoResponse>{

    private final static String TAG = GetVodEndClipRequest.class.getSimpleName();

    public final static String URL = EndPoints.BASE_URL + EndPoints.ClipEnd.API;
    public final static String PARAMS_MAP = "?json={\"clipNo\":\"%d\"}";

    public GetVodEndClipRequest(String params,
                                Response.Listener<ClipInfoResponse> listener,
                                Response.ErrorListener errorListener) {
        super(Method.GET,
                URL + params,
                listener,
                errorListener,
                new ResponseHeaderExtractor());
    }

    @Override
    protected ClipInfoResponse parse(JsonNode body) {
        ClipInfoResponse response = null;

        long started = System.currentTimeMillis();

        JsonNode clipInfo = body.path("clipInfo");

        try {
            response = mMapper.treeToValue(clipInfo, ClipInfoResponse.class);
        } catch (JsonProcessingException e) {
            Log.e(TAG, e.getMessage(), e);
        }

        Log.d(TAG, "elapsed time: " + (System.currentTimeMillis() - started));
        return response;
    }

    public static String buildParams(Long... args) {
        return String.format(PARAMS_MAP, args[0]);
    }
}
