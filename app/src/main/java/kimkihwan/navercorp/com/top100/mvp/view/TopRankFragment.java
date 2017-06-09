package kimkihwan.navercorp.com.top100.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kimkihwan.navercorp.com.top100.R;
import kimkihwan.navercorp.com.top100.mvp.presenter.TopRankPresenter;

/**
 * Created by NAVER on 2017-06-08.
 */

public class TopRankFragment
        extends BaseFragment<TopRankPresenter, TopRankPresenter.TopRankUi>
        implements TopRankPresenter.TopRankUi {

    public static TopRankFragment getInstance() {
        TopRankFragment fragment = new TopRankFragment();
        return fragment;
    }

    @Override
    public TopRankPresenter createPresenter() {
        return new TopRankPresenter();
    }

    @Override
    public TopRankPresenter.TopRankUi getUi() {
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toprank, container, false);
        init();
        return view;
    }

    private void init() {
        getPresenter().fetch();
    }

    @Override
    public void populate() {

    }
}
