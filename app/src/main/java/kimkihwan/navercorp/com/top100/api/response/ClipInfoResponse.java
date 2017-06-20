package kimkihwan.navercorp.com.top100.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import kimkihwan.navercorp.com.top100.mvp.model.Channel;
import kimkihwan.navercorp.com.top100.mvp.model.ClipInfo;
import kimkihwan.navercorp.com.top100.mvp.model.ClipOption;
import kimkihwan.navercorp.com.top100.mvp.model.Link;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClipInfoResponse {

    public String playableAuth;
    public String advertiseInfo;
    public String advertiseUrl;
    public ClipInfo clip;
    public List<Link> outLinks;
    public List<Link> inLinks;
    public List<ClipOption> clipOptions;
    public String trackingData;
    public Channel channel;

    public String getPlayableAuth() {
        return playableAuth;
    }

    public void setPlayableAuth(String playableAuth) {
        this.playableAuth = playableAuth;
    }

    public String getAdvertiseInfo() {
        return advertiseInfo;
    }

    public void setAdvertiseInfo(String advertiseInfo) {
        this.advertiseInfo = advertiseInfo;
    }

    public String getAdvertiseUrl() {
        return advertiseUrl;
    }

    public void setAdvertiseUrl(String advertiseUrl) {
        this.advertiseUrl = advertiseUrl;
    }

    public ClipInfo getClip() {
        return clip;
    }

    public void setClip(ClipInfo clip) {
        this.clip = clip;
    }

    public List<Link> getOutLinks() {
        return outLinks;
    }

    public void setOutLinks(List<Link> outLinks) {
        this.outLinks = outLinks;
    }

    public List<Link> getInLinks() {
        return inLinks;
    }

    public void setInLinks(List<Link> inLinks) {
        this.inLinks = inLinks;
    }

    public List<ClipOption> getClipOptions() {
        return clipOptions;
    }

    public void setClipOptions(List<ClipOption> clipOptions) {
        this.clipOptions = clipOptions;
    }

    public String getTrackingData() {
        return trackingData;
    }

    public void setTrackingData(String trackingData) {
        this.trackingData = trackingData;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
