package kimkihwan.navercorp.com.top100.mvp.presenter;

import android.content.Context;
import android.support.v4.content.Loader;
import android.util.Log;

import kimkihwan.navercorp.com.top100.mvp.presenter.Presenter;

/**
 * Created by jamie on 2017. 6. 9..
 */

public abstract class PresenterLoader<P extends Presenter>
        extends Loader<P> {

    private final static String TAG = PresenterLoader.class.getSimpleName();

    private P mPresenter;

    public PresenterLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mPresenter != null) {
            deliverResult(mPresenter);
            return;
        }
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        mPresenter = initPresenter();
        deliverResult(mPresenter);
    }

    @Override
    protected void onReset() {
        super.onReset();
        mPresenter.destroy();
        mPresenter = null;
    }

    public abstract P initPresenter();
}
