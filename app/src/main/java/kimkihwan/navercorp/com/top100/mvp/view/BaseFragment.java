package kimkihwan.navercorp.com.top100.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import kimkihwan.navercorp.com.top100.mvp.presenter.Presenter;
import kimkihwan.navercorp.com.top100.mvp.presenter.PresenterLoader;

/**
 * Created by NAVER on 2017-06-08.
 */

public abstract class BaseFragment<P extends Presenter<U>, U extends Ui>
        extends Fragment
        implements LoaderManager.LoaderCallbacks<P>{

    private final static int LOADER_INIT = 101;

    private P mPresenter;

    public abstract P createPresenter();

    public abstract U getUi();

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(LOADER_INIT, null, this);
    }

    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<P>(getActivity()) {
            @Override
            public P initPresenter() {
                return createPresenter();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P presenter) {
        mPresenter = presenter;
        onLoadFinished();
        mPresenter.onUiReady(getUi());
    }

    protected void onLoadFinished() {

    }

    @Override
    public void onLoaderReset(Loader<P> loader) {
        onLoadReset();
    }

    protected void onLoadReset() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onUiDestroy(getUi());
    }
}
