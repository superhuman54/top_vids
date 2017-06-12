package kimkihwan.navercorp.com.top100.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jamie on 2017. 6. 11..
 */

public class VolleyApiClient {

    private static VolleyApiClient sInstance;

    private RequestQueue mQueue;

    public static VolleyApiClient getInstance() {
        if (sInstance == null) {
            sInstance = new VolleyApiClient();
        }
        return sInstance;
    }

    private VolleyApiClient() {

    }

    public void init(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public <T> Request<T> add(Request<T> request) {
        return mQueue.add(request);
    }

    public void cancelAll(Object tag) {
        mQueue.cancelAll(tag);
    }

}
