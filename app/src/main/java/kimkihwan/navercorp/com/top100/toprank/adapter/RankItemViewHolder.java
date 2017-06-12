package kimkihwan.navercorp.com.top100.toprank.adapter;

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
    private TextView mTitle;
    private TextView mPlace;

    public RankItemViewHolder(ItemRankBinding binding) {
        super(binding);
        mThumbnail = binding.thumbnail;
        mTitle = binding.title;
        mPlace = binding.place;
    }

    @Override
    public void bind(RankItem item) {
        mTitle.setText(item.getClipTitle());
        mPlace.setText(item.getRankStatus());
        ImageFetcher.display(mThumbnail, item.getThumbnailUrl());
    }

    public static RankItemViewHolder create(ViewGroup parent) {
        ItemRankBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_rank, parent, false);
        return new RankItemViewHolder(binding);
    }
}
