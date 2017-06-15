package kimkihwan.navercorp.com.top100.mvp.model;

/**
 * Created by jamie on 2017. 6. 15..
 */

public class RankItem {

    public String channelId;
    public String clipTitle;
    public long playCount;
    public long recommendPoint;
    public long likeItCount;
    public String channelEmblem;
    public String channelUrl;
    public String playTime;
    public String thumbnailUrl;
    public long clipNo;
    public String videoId;
    public String channelTitle;
    public boolean multiTrack;
    public String rankStatus;
    public String rankRange;
    public String intentUrl;

    public int place;

    public RankItem setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public RankItem setClipTitle(String clipTitle) {
        this.clipTitle = clipTitle;
        return this;
    }

    public RankItem setPlayCount(long playCount) {
        this.playCount = playCount;
        return this;
    }

    public RankItem setRecommendPoint(long recommendPoint) {
        this.recommendPoint = recommendPoint;
        return this;
    }

    public RankItem setLikeItCount(long likeItCount) {
        this.likeItCount = likeItCount;
        return this;
    }

    public RankItem setChannelEmblem(String channelEmblem) {
        this.channelEmblem = channelEmblem;
        return this;
    }

    public RankItem setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
        return this;
    }

    public RankItem setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    public RankItem setClipNo(long clipNo) {
        this.clipNo = clipNo;
        return this;
    }

    public RankItem setVideoId(String videoId) {
        this.videoId = videoId;
        return this;
    }

    public RankItem setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
        return this;
    }

    public RankItem setMultiTrack(boolean multiTrack) {
        this.multiTrack = multiTrack;
        return this;
    }

    public RankItem setRankStatus(String rankStatus) {
        this.rankStatus = rankStatus;
        return this;
    }

    public RankItem setRankRange(String rankRange) {
        this.rankRange = rankRange;
        return this;
    }

    public RankItem setIntentUrl(String intentUrl) {
        this.intentUrl = intentUrl;
        return this;
    }

    public RankItem setPlace(int place) {
        this.place = place;
        return this;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getClipTitle() {
        return clipTitle;
    }

    public long getPlayCount() {
        return playCount;
    }

    public long getRecommendPoint() {
        return recommendPoint;
    }

    public long getLikeItCount() {
        return likeItCount;
    }

    public String getChannelEmblem() {
        return channelEmblem;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public long getClipNo() {
        return clipNo;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public boolean isMultiTrack() {
        return multiTrack;
    }

    public String getRankStatus() {
        return rankStatus;
    }

    public String getRankRange() {
        return rankRange;
    }

    public String getIntentUrl() {
        return intentUrl;
    }

    public int getPlace() {
        return place;
    }

    public String getPlayTime() {
        return playTime;
    }

    public RankItem setPlayTime(String playTime) {
        this.playTime = playTime;
        return this;
    }
}
