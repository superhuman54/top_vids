package kimkihwan.navercorp.com.top100.mvp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jamie on 2017. 6. 20..
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClipInfo extends Clip {

    public String periodTime;
    public boolean adult;
    public int playTime;
    public boolean exposure;
    public String thumbnailUrl;
    public String firstExposureDatetime;
    public String registerDatetime;
    public String channelId;
    public String videoId;
    public String channelEmblem;
    public String clipTitle;
    public String recommendPoint;
    public String channelName;
    public String likeItCount;
    public String playCount;
    public String displayPlayTime;
    public int commentCount;
    public String vendor;
    public boolean vertical;
    public boolean threeQuartersThumb;
    public int messageId;
    public String firstExposureDate;
    public boolean multitrack;
    public boolean vr360;
    public String description;

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public boolean isExposure() {
        return exposure;
    }

    public void setExposure(boolean exposure) {
        this.exposure = exposure;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getFirstExposureDatetime() {
        return firstExposureDatetime;
    }

    public void setFirstExposureDatetime(String firstExposureDatetime) {
        this.firstExposureDatetime = firstExposureDatetime;
    }

    public String getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(String registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getChannelEmblem() {
        return channelEmblem;
    }

    public void setChannelEmblem(String channelEmblem) {
        this.channelEmblem = channelEmblem;
    }

    public String getClipTitle() {
        return clipTitle;
    }

    public void setClipTitle(String clipTitle) {
        this.clipTitle = clipTitle;
    }

    public String getRecommendPoint() {
        return recommendPoint;
    }

    public void setRecommendPoint(String recommendPoint) {
        this.recommendPoint = recommendPoint;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getLikeItCount() {
        return likeItCount;
    }

    public void setLikeItCount(String likeItCount) {
        this.likeItCount = likeItCount;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getDisplayPlayTime() {
        return displayPlayTime;
    }

    public void setDisplayPlayTime(String displayPlayTime) {
        this.displayPlayTime = displayPlayTime;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public boolean isThreeQuartersThumb() {
        return threeQuartersThumb;
    }

    public void setThreeQuartersThumb(boolean threeQuartersThumb) {
        this.threeQuartersThumb = threeQuartersThumb;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getFirstExposureDate() {
        return firstExposureDate;
    }

    public void setFirstExposureDate(String firstExposureDate) {
        this.firstExposureDate = firstExposureDate;
    }

    public boolean isMultitrack() {
        return multitrack;
    }

    public void setMultitrack(boolean multitrack) {
        this.multitrack = multitrack;
    }

    public boolean isVr360() {
        return vr360;
    }

    public void setVr360(boolean vr360) {
        this.vr360 = vr360;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
