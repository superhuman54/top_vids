package kimkihwan.navercorp.com.top100.api.response;

import java.util.ArrayList;
import java.util.List;

import kimkihwan.navercorp.com.top100.mvp.model.RankItem;

/**
 * Created by jamie on 2017. 6. 11..
 */

public class TopRankResponse {

    public int playlistNo;
    public long lastModifyDatetime;
    public List<RankItem> clips = new ArrayList<>();
    public long[] criteriaDate;

    public int getPlaylistNo() {
        return playlistNo;
    }

    public TopRankResponse setPlaylistNo(int playlistNo) {
        this.playlistNo = playlistNo;
        return this;
    }

    public long getLastModifyDatetime() {
        return lastModifyDatetime;
    }

    public TopRankResponse setLastModifyDatetime(long lastModifyDatetime) {
        this.lastModifyDatetime = lastModifyDatetime;
        return this;
    }

    public List<RankItem> getClips() {
        return clips;
    }

    public TopRankResponse setClips(List<RankItem> clips) {
        this.clips = clips;
        return this;
    }

    public long[] getCriteriaDate() {
        return criteriaDate;
    }

    public TopRankResponse setCriteriaDate(long[] criteriaDate) {
        this.criteriaDate = criteriaDate;
        return this;
    }
}
