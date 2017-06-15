package kimkihwan.navercorp.com.top100.main.toprank.filter;

/**
 * Created by jamie on 2017. 6. 13..
 */

public class Filter implements Comparable<Filter> {

    public String name;
    public int order;
    public String parameter;
    public boolean isDefault;

    public Filter setName(String name) {
        this.name = name;
        return this;
    }

    public Filter setOrder(int order) {
        this.order = order;
        return this;
    }

    public Filter setParameter(String parameter) {
        this.parameter = parameter;
        return this;
    }

    public Filter setDefault(boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    @Override
    public int compareTo(Filter that) {
        return this.order - that.order;
    }
}
