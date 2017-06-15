package kimkihwan.navercorp.com.top100.main.toprank.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kimkihwan.navercorp.com.top100.R;
import kimkihwan.navercorp.com.top100.databinding.ItemRankBinding;
import kimkihwan.navercorp.com.top100.mvp.model.RankItem;
import kimkihwan.navercorp.com.top100.utils.ImageFetcher;

/**
 * Created by jamie on 2017. 6. 9..
 */

public class RankItemViewHolder extends BaseViewHolder<ItemRankBinding, RankItem>{

    private ImageView mThumbnail;
    private TextView mRunningTime;

    private TextView mPlace;
    private TextView mHistory;

    private TextView mTitle;

    private TextView mChannelTitle;
    private TextView mHits;
    private TextView mLikes;

    public RankItemViewHolder(ItemRankBinding binding) {
        super(binding);
        mThumbnail = binding.thumbnail;
        mTitle = binding.title;
        mPlace = binding.place;
        mRunningTime = binding.runningTime;
        mChannelTitle = binding.channelTitle;
        mHits = binding.hits;
        mLikes = binding.likes;
        mHistory = binding.history;
    }

    @Override
    public void bind(RankItem item) {
        mTitle.setText(item.getClipTitle());
        mPlace.setText(item.getRankStatus());
        mRunningTime.setText(item.getPlayTime());
        mChannelTitle.setText(item.getChannelTitle());
        mHits.setText(item.getPlayCount() + "");
        mLikes.setText(item.getLikeItCount() + "");
        mPlace.setText(String.valueOf(item.getPlace()));
        mHistory.setText(item.getRankStatus());
        ImageFetcher.display(mThumbnail,
                ImageFetcher.ImageSize.FULL,
                item.getThumbnailUrl());
    }

    public static RankItemViewHolder create(ViewGroup parent) {
        ItemRankBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_rank, parent, false);
        return new RankItemViewHolder(binding);
    }
}
