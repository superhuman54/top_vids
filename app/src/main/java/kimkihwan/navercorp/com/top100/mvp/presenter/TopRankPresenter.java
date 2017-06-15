package kimkihwan.navercorp.com.top100.mvp.presenter;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import kimkihwan.navercorp.com.top100.api.VolleyApiClient;
import kimkihwan.navercorp.com.top100.api.request.GetTopRankRequest;
import kimkihwan.navercorp.com.top100.api.response.TopRankResponse;
import kimkihwan.navercorp.com.top100.mvp.model.RankItem;
import kimkihwan.navercorp.com.top100.mvp.view.Ui;
import kimkihwan.navercorp.com.top100.main.toprank.filter.Filter;
import kimkihwan.navercorp.com.top100.utils.FilterLoader;

/**
 * Created by NAVER on 2017-06-08.
 */

public class TopRankPresenter
        extends Presenter<TopRankPresenter.TopRankUi> {

    private final static String TAG = TopRankPresenter.class.getSimpleName();

    private Filter mApplied = FilterLoader.DEFAULT;

    @Override
    public void onUiReady(TopRankUi ui) {
        super.onUiReady(ui);
        fetch();
    }

    /**
     * 100순위 랭킹 영상정보를 가져온다.
     *
     * @param filter 리스트를 필터할 필터 객체
     */
    public void fetch(Filter filter) {
        getUi().showProgress();
        mApplied = filter;
        VolleyApiClient.getInstance()
                .add(new GetTopRankRequest(GetTopRankRequest.buildParams(mApplied.parameter),
                        new Response.Listener<TopRankResponse>() {
                            @Override
                            public void onResponse(TopRankResponse response) {
                                getUi().populate(response.mRankItems);
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

    public void fetch() {
        fetch(mApplied);
    }

    public interface TopRankUi extends Ui {
        void populate(List<RankItem> items);
    }
}
