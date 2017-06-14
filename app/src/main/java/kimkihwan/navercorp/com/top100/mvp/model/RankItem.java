package kimkihwan.navercorp.com.top100.mvp.model;

/**
 * Created by jamie on 2017. 6. 9..
 */

public class RankItem {

    private String mThumbnailUrl;
    private String mChannelUrl;
    private String mPlayTime;
    private String mPlayCount;
    private String mLikeItCount;
    private String mClipTitle;
    private String mRecommendPoint;
    private RankStatus mRankStatus;
    private String mRankRange;
    private String mIntentUrl;
    private String mChannelTitle;
    private long mClipNo;
    private boolean mIsMultiTrack;
    private String mVideoId;
    private String mChannelId;
    private String mChannelEmblemUrl;
    private int mPlace;

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public RankItem setThumbnailUrl(String mThumbnailUrl) {
        this.mThumbnailUrl = mThumbnailUrl;
        return this;
    }

    public String getChannelUrl() {
        return mChannelUrl;
    }

    public RankItem setChannelUrl(String mChannelUrl) {
        this.mChannelUrl = mChannelUrl;
        return this;
    }

    public String getPlayTime() {
        return mPlayTime;
    }

    public RankItem setPlayTime(String mPlayTime) {
        this.mPlayTime = mPlayTime;
        return this;
    }

    public String getPlayCount() {
        return mPlayCount;
    }

    public RankItem setPlayCount(String mPlayCount) {
        this.mPlayCount = mPlayCount;
        return this;
    }

    public String getLikeItCount() {
        return mLikeItCount;
    }

    public RankItem setLikeItCount(String mLikeItCount) {
        this.mLikeItCount = mLikeItCount;
        return this;
    }

    public String getClipTitle() {
        return mClipTitle;
    }

    public RankItem setClipTitle(String mClipTitle) {
        this.mClipTitle = mClipTitle;
        return this;
    }

    public String getRecommendPoint() {
        return mRecommendPoint;
    }

    public RankItem setRecommendPoint(String mRecommendPoint) {
        this.mRecommendPoint = mRecommendPoint;
        return this;
    }

    public String getRankStatus() {
        return mRankStatus.name();
    }

    public RankItem setRankStatus(String rankStatus) {
        this.mRankStatus = RankStatus.valueOf(rankStatus.toUpperCase());
        return this;
    }

    public String getRankRange() {
        return mRankRange;
    }

    public RankItem setRankRange(String mRankRange) {
        this.mRankRange = mRankRange;
        return this;
    }

    public String getIntentUrl() {
        return mIntentUrl;
    }

    public RankItem setIntentUrl(String mIntentUrl) {
        this.mIntentUrl = mIntentUrl;
        return this;
    }

    public String getChannelTitle() {
        return mChannelTitle;
    }

    public RankItem setChannelTitle(String mChannelTitle) {
        this.mChannelTitle = mChannelTitle;
        return this;
    }

    public long getClipNo() {
        return mClipNo;
    }

    public RankItem setClipNo(long mClipNo) {
        this.mClipNo = mClipNo;
        return this;
    }

    public boolean isMultiTrack() {
        return mIsMultiTrack;
    }

    public RankItem setIsMultiTrack(boolean mIsMultiTrack) {
        this.mIsMultiTrack = mIsMultiTrack;
        return this;
    }

    public String getVideoId() {
        return mVideoId;
    }

    public RankItem setVideoId(String mVideoId) {
        this.mVideoId = mVideoId;
        return this;
    }

    public String getChannelId() {
        return mChannelId;
    }

    public RankItem setChannelId(String mChannelId) {
        this.mChannelId = mChannelId;
        return this;
    }

    public String getChannelEmblemUrl() {
        return mChannelEmblemUrl;
    }

    public RankItem setChannelEmblemUrl(String mChannelEmblemUrl) {
        this.mChannelEmblemUrl = mChannelEmblemUrl;
        return this;
    }

    public int getPlace() {
        return mPlace;
    }

    public RankItem setPlace(int mPlace) {
        this.mPlace = mPlace;
        return this;
    }

    enum RankStatus {
        UP,
        DOWN,
        NEW,
        KEEP
    }
}
