package kimkihwan.navercorp.com.top100.mvp.presenter;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import kimkihwan.navercorp.com.top100.api.VolleyApiClient;
import kimkihwan.navercorp.com.top100.api.request.GetVodEndClipRequest;
import kimkihwan.navercorp.com.top100.api.response.ClipInfoResponse;
import kimkihwan.navercorp.com.top100.mvp.model.Clip;
import kimkihwan.navercorp.com.top100.mvp.view.Ui;

/**
 * Created by jamie on 2017. 6. 19..
 */

public class VideoPlayerPresenter extends Presenter<VideoPlayerPresenter.VideoPlayerUi> {

    private final static String TAG = VideoPlayerPresenter.class.getSimpleName();

    public void getVodEndClip(Clip clip) {
        VolleyApiClient.getInstance()
                .add(new GetVodEndClipRequest(GetVodEndClipRequest.buildParams(clip.getClipNo()),
                        new Response.Listener<ClipInfoResponse>() {
                            @Override
                            public void onResponse(ClipInfoResponse response) {

                                getUi().hideProgress();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                        getUi().hideProgress();
                    }
                }));
    }

    public interface VideoPlayerUi extends Ui {

    }
}
