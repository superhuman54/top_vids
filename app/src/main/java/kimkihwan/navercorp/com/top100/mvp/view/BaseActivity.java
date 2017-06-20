package kimkihwan.navercorp.com.top100.mvp.view;



import android.os.Bundle;


import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;


import kimkihwan.navercorp.com.top100.mvp.presenter.Presenter;
import kimkihwan.navercorp.com.top100.mvp.presenter.PresenterLoader;

/**
 * Created by jamie on 2017. 6. 19..
 */

public abstract class BaseActivity<P extends Presenter<U>, U extends Ui>
        extends AppCompatActivity implements LoaderManager.LoaderCallbacks<P> {

    protected final static int INIT_LOADER = 1;

    protected P mPresenter;

    public abstract P createPresenter();

    public abstract U getUi();

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportLoaderManager().initLoader(INIT_LOADER, null, this);
    }

    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<P>(this) {
            @Override
            public P initPresenter() {
                return createPresenter();
            }
        };
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {

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
    protected void onDestroy() {
        mPresenter.onUiUnready(getUi());
        super.onDestroy();
    }
}
