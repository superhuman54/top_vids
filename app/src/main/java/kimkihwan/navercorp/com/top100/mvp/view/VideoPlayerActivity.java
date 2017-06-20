package kimkihwan.navercorp.com.top100.mvp.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import kimkihwan.navercorp.com.top100.R;
import kimkihwan.navercorp.com.top100.databinding.ActivityVideoplayerBinding;
import kimkihwan.navercorp.com.top100.mvp.model.RankItem;
import kimkihwan.navercorp.com.top100.mvp.presenter.VideoPlayerPresenter;
import kimkihwan.navercorp.com.top100.utils.VodEndIntentUtil;

/**
 * Created by jamie on 2017. 6. 16..
 */

public class VideoPlayerActivity
        extends BaseActivity<VideoPlayerPresenter, VideoPlayerPresenter.VideoPlayerUi>
        implements VideoPlayerPresenter.VideoPlayerUi, SurfaceHolder.Callback {

    private final static String TAG = VideoPlayerActivity.class.getSimpleName();
    public final static String EXTRA_CLIP_ITEM = "key_clip_item";

    private ActivityVideoplayerBinding mBinding;

    private SurfaceView mSurfaceView;
    private SurfaceHolder mHolder;
    private Button mPlayButton;
    private Button mStopButton;

    private MediaPlayer mMediaPlayer;

    private RankItem mRankItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_videoplayer);
        mPlayButton = mBinding.buttonPlay;
        mStopButton = mBinding.buttonStop;
        mHolder = mBinding.surface.getHolder();
        mHolder.addCallback(this);

    }

    @Override
    protected void onLoadFinished() {
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_CLIP_ITEM)) {
            mRankItem = intent.getParcelableExtra(EXTRA_CLIP_ITEM);
            getPresenter().getVodEndClip(mRankItem);
        }
    }

    @Override
    public VideoPlayerPresenter createPresenter() {
        return new VideoPlayerPresenter();
    }

    @Override
    public VideoPlayerPresenter.VideoPlayerUi getUi() {
        return this;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surface created -> " + Thread.currentThread().getName());
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
        } else {
            mMediaPlayer.reset();
        }

//        try {
//            mMediaPlayer.setDataSource(this);
//            mMediaPlayer.setDisplay(holder);
//            mMediaPlayer.prepareAsync();
//            mMediaPlayer.setOnCompletionListener(mCompleteListener);
//        } catch (IOException e) {
//            Log.e(TAG, e.getMessage(), e);
//        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private void startOrPause() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mPlayButton.setText("Play");
        } else {
            mMediaPlayer.start();
            mPlayButton.setText("Pause");
        }
    }

    private void stopNprepare() {
        mMediaPlayer.stop();
        mPlayButton.setText("Play");

        try {
            mMediaPlayer.prepare();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
        }
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button_play) {
                Log.i("main", "play");
                startOrPause();
            } else if (v.getId() == R.id.button_stop) {
                stopNprepare();
            }
        }
    };

    MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

        }
    };
}
