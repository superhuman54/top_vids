package kimkihwan.navercorp.com.top100.toprank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kimkihwan.navercorp.com.top100.mvp.model.RankItem;

/**
 * Created by NAVER on 2017-06-08.
 */

public class TopRankAdapter extends RecyclerView.Adapter<RankItemViewHolder> {

    private List<RankItem> mItems = new ArrayList<>();

    @Override
    public RankItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RankItemViewHolder.create(parent);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(RankItemViewHolder holder, int position) {
        holder.bind(mItems.get(position).setPlace(++position));
    }

    public void swap(List<RankItem> items) {
        mItems.clear();
        mItems.addAll(items);

        notifyDataSetChanged();
    }

}
