package kimkihwan.navercorp.com.top100.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import kimkihwan.navercorp.com.top100.mvp.presenter.Presenter;

/**
 * Created by NAVER on 2017-06-08.
 */

public abstract class BaseFragment<P extends Presenter<U>, U extends Ui> extends Fragment {

    private P mPresenter;

    public BaseFragment() {
        mPresenter = createPresenter();
    }

    public abstract P createPresenter();

    public abstract U getUi();

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.onUiReady(getUi());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onUiDestroy(getUi());
    }
}
