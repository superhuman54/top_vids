package kimkihwan.navercorp.com.top100.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jamie on 2017. 6. 15..
 */

public class RankItem extends Clip implements Parcelable {

    public String channelId;
    public String clipTitle;
    public long playCount;
    public long recommendPoint;
    public long likeItCount;
    public String channelEmblem;
    public String channelUrl;
    public String playTime;
    public String thumbnailUrl;
    public String videoId;
    public String channelTitle;
    public boolean multiTrack;
    public String rankStatus;
    public String rankRange;
    public String intentUrl;

    public int place;

    public RankItem() {
    }

    protected RankItem(Parcel in) {
        channelId = in.readString();
        clipTitle = in.readString();
        playCount = in.readLong();
        recommendPoint = in.readLong();
        likeItCount = in.readLong();
        channelEmblem = in.readString();
        channelUrl = in.readString();
        playTime = in.readString();
        thumbnailUrl = in.readString();
        clipNo = in.readLong();
        videoId = in.readString();
        channelTitle = in.readString();
        multiTrack = in.readByte() != 0;
        rankStatus = in.readString();
        rankRange = in.readString();
        intentUrl = in.readString();
        place = in.readInt();
    }

    public static final Creator<RankItem> CREATOR = new Creator<RankItem>() {
        @Override
        public RankItem createFromParcel(Parcel in) {
            return new RankItem(in);
        }

        @Override
        public RankItem[] newArray(int size) {
            return new RankItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(channelId);
        dest.writeString(clipTitle);
        dest.writeLong(playCount);
        dest.writeLong(recommendPoint);
        dest.writeLong(likeItCount);
        dest.writeString(channelEmblem);
        dest.writeString(channelUrl);
        dest.writeString(playTime);
        dest.writeString(thumbnailUrl);
        dest.writeLong(clipNo);
        dest.writeString(videoId);
        dest.writeString(channelTitle);
        dest.writeByte((byte) (multiTrack ? 1 : 0));
        dest.writeString(rankStatus);
        dest.writeString(rankRange);
        dest.writeString(intentUrl);
        dest.writeInt(place);
    }
}
