package kimkihwan.navercorp.com.top100.mvp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jamie on 2017. 6. 20..
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    public String clipCount;
    public boolean exposure;
    public String schedule;
    public String firstExposureDatetime;
    public String channelId;
    public String subscriptionCount;
    public String broadcastChannelName;
    public String channelName;
    public boolean playlistExposure;
    public String channelType;
    public String creatorChannelUrl;
    public boolean smartMirroring;
    public String channelHomeUrl;
    public String posterUrl;
    public String posterLabel;
    public String bannerImageUrl;
    public boolean contest;
    public String emblemUrl;

    public String getClipCount() {
        return clipCount;
    }

    public void setClipCount(String clipCount) {
        this.clipCount = clipCount;
    }

    public boolean isExposure() {
        return exposure;
    }

    public void setExposure(boolean exposure) {
        this.exposure = exposure;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getFirstExposureDatetime() {
        return firstExposureDatetime;
    }

    public void setFirstExposureDatetime(String firstExposureDatetime) {
        this.firstExposureDatetime = firstExposureDatetime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSubscriptionCount() {
        return subscriptionCount;
    }

    public void setSubscriptionCount(String subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
    }

    public String getBroadcastChannelName() {
        return broadcastChannelName;
    }

    public void setBroadcastChannelName(String broadcastChannelName) {
        this.broadcastChannelName = broadcastChannelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public boolean isPlaylistExposure() {
        return playlistExposure;
    }

    public void setPlaylistExposure(boolean playlistExposure) {
        this.playlistExposure = playlistExposure;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getCreatorChannelUrl() {
        return creatorChannelUrl;
    }

    public void setCreatorChannelUrl(String creatorChannelUrl) {
        this.creatorChannelUrl = creatorChannelUrl;
    }

    public boolean isSmartMirroring() {
        return smartMirroring;
    }

    public void setSmartMirroring(boolean smartMirroring) {
        this.smartMirroring = smartMirroring;
    }

    public String getChannelHomeUrl() {
        return channelHomeUrl;
    }

    public void setChannelHomeUrl(String channelHomeUrl) {
        this.channelHomeUrl = channelHomeUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPosterLabel() {
        return posterLabel;
    }

    public void setPosterLabel(String posterLabel) {
        this.posterLabel = posterLabel;
    }

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public void setBannerImageUrl(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
    }

    public boolean isContest() {
        return contest;
    }

    public void setContest(boolean contest) {
        this.contest = contest;
    }

    public String getEmblemUrl() {
        return emblemUrl;
    }

    public void setEmblemUrl(String emblemUrl) {
        this.emblemUrl = emblemUrl;
    }
}
