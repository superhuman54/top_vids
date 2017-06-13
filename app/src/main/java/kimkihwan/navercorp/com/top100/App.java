package kimkihwan.navercorp.com.top100;

import android.app.Application;

import kimkihwan.navercorp.com.top100.api.VolleyApiClient;
import kimkihwan.navercorp.com.top100.toprank.adapter.filter.FilterLoader;

/**
 * Created by jamie on 2017. 6. 11..
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VolleyApiClient.getInstance()
                .init(this);

        FilterLoader.getInstance()
                .load(this);
    }
}
