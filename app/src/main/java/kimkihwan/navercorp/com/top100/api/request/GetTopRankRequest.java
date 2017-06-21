package kimkihwan.navercorp.com.top100.api.request;

import android.util.Log;

import com.android.volley.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import kimkihwan.navercorp.com.top100.api.EndPoints;
import kimkihwan.navercorp.com.top100.api.response.TopRankResponse;
import kimkihwan.navercorp.com.top100.api.util.ResponseHeaderExtractor;

/**
 * Created by jamie on 2017. 6. 11..
 */

public class GetTopRankRequest extends JacksonRequest<TopRankResponse>{

    private final static String TAG = GetTopRankRequest.class.getSimpleName();

    public final static String URL = EndPoints.BASE_URL + EndPoints.TopRank.API;
    public final static String PARAMS_MAP = "?json={\"category\":\"%s\",\"count\":100}";

    public GetTopRankRequest(String params,
                             Response.Listener<TopRankResponse> listener,
                             Response.ErrorListener errorListener) {
        super(Method.GET,
                URL + params,
                listener,
                errorListener,
                new ResponseHeaderExtractor());
        setTag(URL + params);
    }

    /**
     *  응답의 바디(body) 영역을 파싱한다.
     * @param body 응답 json
     * @return
     */
    @Override
    protected TopRankResponse parse(JsonNode body) {
        Log.d(TAG, "parse() -> " + Thread.currentThread().getName());
        TopRankResponse response = null;

        long started = System.currentTimeMillis();

        JsonNode topPlayList = body.path("top100Playlist");

        try {
            response = mMapper.treeToValue(topPlayList, TopRankResponse.class);
        } catch (JsonProcessingException e) {
            Log.e(TAG, e.getMessage(), e);
        }

        Log.d(TAG, "elapsed time: " + (System.currentTimeMillis() - started));

        return response;
    }

    public static String buildParams(String... args) {
        return String.format(PARAMS_MAP, args[0]);
    }

}
