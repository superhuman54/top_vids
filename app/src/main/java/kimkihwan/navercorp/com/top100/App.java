package kimkihwan.navercorp.com.top100;

import android.app.Application;

import com.facebook.stetho.Stetho;

import kimkihwan.navercorp.com.top100.api.VolleyApiClient;
import kimkihwan.navercorp.com.top100.utils.FilterLoader;
import kimkihwan.navercorp.com.top100.utils.ImageFetcher;

/**
 * Created by jamie on 2017. 6. 11..
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        VolleyApiClient.getInstance()
                .init(this);

        FilterLoader.getInstance()
                .load(this);
    }
}
