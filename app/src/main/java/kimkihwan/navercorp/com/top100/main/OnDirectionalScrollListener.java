package kimkihwan.navercorp.com.top100.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by jamie on 2017. 6. 15..
 */

public abstract class OnDirectionalScrollListener extends RecyclerView.OnScrollListener {

    private final static String TAG = OnDirectionalScrollListener.class.getSimpleName();

    public final static int SCROLL_UP = 0;
    public final static int SCROLL_DOWN = 1;

    public static int SCROLL_STATE;

    private int mState;

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        mState = newState;
    }

    private String getState(int code) {
        switch (code) {
            case RecyclerView.SCROLL_STATE_DRAGGING:
                return "DRAGGING";
            case RecyclerView.SCROLL_STATE_SETTLING:
                return "SETTLING";
            case RecyclerView.SCROLL_STATE_IDLE:
                return "IDLE";
        }
        return null;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0) {
            SCROLL_STATE = SCROLL_UP;
        } else {
            SCROLL_STATE = SCROLL_DOWN;
        }
        onScrollStateChanged(recyclerView, SCROLL_STATE, mState);
    }

    public abstract void onScrollStateChanged(RecyclerView view, int direction, int state);

}
