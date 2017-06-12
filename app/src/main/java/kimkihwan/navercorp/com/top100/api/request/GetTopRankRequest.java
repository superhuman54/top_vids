package kimkihwan.navercorp.com.top100.api.request;

import com.android.volley.Response;
import com.fasterxml.jackson.databind.JsonNode;

import kimkihwan.navercorp.com.top100.api.EndPoints;
import kimkihwan.navercorp.com.top100.api.response.TopRankResponse;
import kimkihwan.navercorp.com.top100.api.util.ResponseHeaderExtractor;
import kimkihwan.navercorp.com.top100.mvp.model.RankItem;

/**
 * Created by jamie on 2017. 6. 11..
 */

public class GetTopRankRequest extends JacksonRequest<TopRankResponse>{

    public final static String URL = EndPoints.BASE_URL + EndPoints.TopRank.API;
    public final static String PARAMS_MAP = "json={\"category\":\"%s\",\"count\":100}";

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
     * @param root 응답 json
     * @return
     */
    @Override
    protected TopRankResponse parse(JsonNode root) {
        TopRankResponse response = new TopRankResponse();

        JsonNode topPlayList = root.path("body").path("top100Playlist");

        response.mPlayListNo = topPlayList.path("playlistNo").asText();
        long dateTimeInMillSec = topPlayList.path("lastModifyDatetime").asLong();

        JsonNode criteriaDate = topPlayList.path("criteriaDate");
//        long startCriteriaDate = criteriaDate.get(0).asLong();
//        long endCriteriaDate = criteriaDate.get(1).asLong();

        JsonNode clips = topPlayList.path("clips");

        for (JsonNode clip : clips) {
            RankItem item = new RankItem();
            item.setThumbnailUrl(clip.path("thumbnailUrl").asText())
                    .setChannelUrl(clip.path("channelUrl").asText())
                    .setPlayTime(clip.path("playTime").asText())
                    .setPlayCount(String.format("%,d", clip.path("playCount").asInt()))
                    .setLikeItCount(String.format("%,d", clip.path("likeItCount").asInt()))
                    .setClipTitle(clip.path("clipTitle").asText())
                    .setRecommendPoint(String.format("%,d", clip.path("recommendPoint").asInt()))
                    .setRankStatus(clip.path("rankStatus").asText())
                    .setRankRange(clip.path("rankRange").asText())
                    .setIntentUrl(clip.path("intentUrl").asText())
                    .setChannelTitle(clip.path("channelTitle").asText())
                    .setClipNo(clip.path("clipNo").asInt())
                    .setIsMultiTrack(clip.path("multiTrack").asBoolean())
                    .setVideoId(clip.path("videoId").asText())
                    .setChannelId(clip.path("channelId").asText())
                    .setChannelEmblemUrl(clip.path("channelEmblem").asText());
            response.mRankItems.add(item);
        }

        return response;
    }

    public static String buildParams(String... args) {
        return String.format(PARAMS_MAP, args[0]);
    }

}
