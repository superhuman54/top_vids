package kimkihwan.navercorp.com.top100.main;

import android.support.v7.widget.RecyclerView;

/**
 * Created by jamie on 2017. 6. 15..
 */

public abstract class OnDirectionalScrollListener extends RecyclerView.OnScrollListener {

    public final static int SCROLL_UP = 0;
    public final static int SCROLL_DOWN = 1;

    public static int SCROLL_STATE;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0) {
            SCROLL_STATE = SCROLL_UP;
        } else {
            SCROLL_STATE = SCROLL_DOWN;
        }
        onScrolled(recyclerView, SCROLL_STATE);
    }

    public abstract void onScrolled(RecyclerView view, int direction);

}
