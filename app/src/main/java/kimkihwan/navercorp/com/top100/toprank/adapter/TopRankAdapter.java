package kimkihwan.navercorp.com.top100.toprank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by NAVER on 2017-06-08.
 */

public class TopRankAdapter extends RecyclerView.Adapter<TopRankAdapter.RankItemViewHolder> {


    @Override
    public RankItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(RankItemViewHolder holder, int position) {

    }

    class RankItemViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumbnail;
        public TextView duration;
        public TextView title;
        public TextView channelName;
        public TextView count;
        public TextView likes;

        public RankItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
