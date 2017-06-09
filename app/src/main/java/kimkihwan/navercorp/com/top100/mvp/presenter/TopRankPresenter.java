package kimkihwan.navercorp.com.top100.mvp.presenter;

import kimkihwan.navercorp.com.top100.mvp.view.Ui;

/**
 * Created by NAVER on 2017-06-08.
 */

public class TopRankPresenter extends Presenter<TopRankPresenter.TopRankUi>{

    public void fetch() {

    }


    public interface TopRankUi extends Ui {
        public void populate();
    }
}
