package kimkihwan.navercorp.com.top100.main.toprank.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by jamie on 2017. 6. 9..
 */

public abstract class BaseViewHolder<B extends ViewDataBinding, I>
        extends RecyclerView.ViewHolder {

    protected B mBinding;

    public BaseViewHolder(B binding) {
        super(binding.getRoot());
       mBinding = binding;
    }

    public abstract void bind(I item);
}
