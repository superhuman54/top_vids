package kimkihwan.navercorp.com.top100.utils;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import kimkihwan.navercorp.com.top100.R;
import kimkihwan.navercorp.com.top100.toprank.adapter.filter.Filter;

/**
 * Created by jamie on 2017. 6. 13..
 */

public class FilterLoader {

    private final static String TAG = FilterLoader.class.getSimpleName();
    private static FilterLoader sInstance;

    public static Filter DEFAULT;

    private Set<Filter> mFilters;

    public static FilterLoader getInstance() {
        if (sInstance == null) {
            sInstance = new FilterLoader();
        }
        return sInstance;
    }

    public void load(Context context) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mFilters = mapper.readValue(context.getResources().openRawResource(R.raw.toprank_filters),
                    mapper.getTypeFactory().constructCollectionType(TreeSet.class, Filter.class));
            for (Filter f : mFilters) {
                if (f.isDefault) {
                    DEFAULT = f;
                    break;
                }
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public Set<Filter> getFilters() {
        return mFilters;
    }

}
