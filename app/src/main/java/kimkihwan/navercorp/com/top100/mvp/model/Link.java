package kimkihwan.navercorp.com.top100.mvp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jamie on 2017. 6. 20..
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    public boolean outLink;
    public String linkTypeName;
    public String url;
    public String linkTypeCode;
    public String description;

    public boolean isOutLink() {
        return outLink;
    }

    public void setOutLink(boolean outLink) {
        this.outLink = outLink;
    }

    public String getLinkTypeName() {
        return linkTypeName;
    }

    public void setLinkTypeName(String linkTypeName) {
        this.linkTypeName = linkTypeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLinkTypeCode() {
        return linkTypeCode;
    }

    public void setLinkTypeCode(String linkTypeCode) {
        this.linkTypeCode = linkTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
