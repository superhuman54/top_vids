package kimkihwan.navercorp.com.top100.mvp.presenter;

import kimkihwan.navercorp.com.top100.mvp.view.Ui;

/**
 * Created by NAVER on 2017-06-08.
 */

public abstract class Presenter<U extends Ui> {

    private U mUi;

    public void onUiReady(U ui) {
        mUi = ui;
    }

    public void onUiDestroy(U ui) {
        onUiUnready(ui);
        mUi = null;
    }

    public void onUiUnready(U ui) {

    }

    public U getUi() {
        return mUi;
    }
}
