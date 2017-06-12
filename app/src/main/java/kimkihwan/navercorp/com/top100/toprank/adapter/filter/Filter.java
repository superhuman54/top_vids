package kimkihwan.navercorp.com.top100.toprank.adapter.filter;

/**
 * Created by jamie on 2017. 6. 12..
 */

public enum Filter {

    ALL("전체", "ALL", true),
    ENTERTAINMENT("예능", "ENTER", false),
    DRAMA("영화/드라마", "DRAMA", false),
    MUSIC("음악", "ARTIS", false),
    SPORTS("게임/스포츠",  "SPORT", false),
    LIFE("라이프", "LIFE", false),
    CULTURE("교양", "CULTU", false),
    ANIMATION("애니메이션", "CHILD", false);

    public String name;
    public String parameter;
    public boolean isDefault;

    Filter(String name, String parameter, boolean isDefault) {
        this.name = name;
        this.parameter = parameter;
        this.isDefault = isDefault;
    }
}
