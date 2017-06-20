package kimkihwan.navercorp.com.top100.mvp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jamie on 2017. 6. 20..
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClipOption {

    public String title;
    public String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
