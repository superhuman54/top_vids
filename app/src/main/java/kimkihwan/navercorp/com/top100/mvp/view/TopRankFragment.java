package kimkihwan.navercorp.com.top100.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

import kimkihwan.navercorp.com.top100.databinding.FragmentToprankBinding;
import kimkihwan.navercorp.com.top100.main.OnDirectionalScrollListener;
import kimkihwan.navercorp.com.top100.main.toprank.adapter.TopRankAdapter;
import kimkihwan.navercorp.com.top100.main.toprank.filter.Filter;
import kimkihwan.navercorp.com.top100.main.toprank.filter.FilterSelector;
import kimkihwan.navercorp.com.top100.mvp.model.RankItem;
import kimkihwan.navercorp.com.top100.mvp.presenter.TopRankPresenter;

/**
 * Created by NAVER on 2017-06-08.
 */

public class TopRankFragment
        extends BaseFragment<TopRankPresenter, TopRankPresenter.TopRankUi>
        implements TopRankPresenter.TopRankUi,
        SwipeRefreshLayout.OnRefreshListener,
        FilterSelector.OnFilterSelectedListener,
        View.OnClickListener{

    private final static String TAG = TopRankFragment.class.getSimpleName();

    private FragmentToprankBinding mBinding;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private FilterSelector mFilterLayout;
    private ImageButton mFilterButton;

    private RecyclerView mRankTopRecyclerView;
    private TopRankAdapter mAdapter;

    public static TopRankFragment getInstance() {
        TopRankFragment fragment = new TopRankFragment();
        return fragment;
    }

    @Override
    public TopRankPresenter createPresenter() {
        return new TopRankPresenter();
    }

    @Override
    public TopRankPresenter.TopRankUi getUi() {
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentToprankBinding.inflate(inflater, container, false);
        mSwipeRefreshLayout = mBinding.swipeRefreshLayout;
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mFilterLayout = mBinding.filterSelector;
        mFilterLayout.setOnFilterSelectedListener(this);
        mFilterLayout.setOnClickListener(this);

        mFilterButton = mBinding.imagebuttonFilter;
        mFilterButton.setOnClickListener(this);

        mAdapter = new TopRankAdapter();
        mRankTopRecyclerView = mBinding.recyclerView;
        mRankTopRecyclerView.setNestedScrollingEnabled(true);
        mRankTopRecyclerView.addOnScrollListener(new OnDirectionalScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView view, int direction, int state) {
                switch (direction) {
                    case OnDirectionalScrollListener.SCROLL_UP:
                        mFilterButton.setVisibility(View.INVISIBLE);
                        break;
                    case OnDirectionalScrollListener.SCROLL_DOWN:
                        if (mFilterLayout.getVisibility() != View.VISIBLE) {
                            mFilterButton.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
        mRankTopRecyclerView.setAdapter(mAdapter);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return mBinding.getRoot();
    }

    @Override
    public void populate(List<RankItem> items) {
        mAdapter.swap(items);
    }

    @Override
    public void showProgress() {
        mBinding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        mBinding.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onRefresh() {
        getPresenter().fetch();
    }

    @Override
    public void onSelected(Filter filter) {
        getPresenter().fetch(filter);
        toggle();
        mRankTopRecyclerView.scrollToPosition(0);
    }

    @Override
    public void onClick(View v) {
        toggle();
    }

    private void toggle() {
        if (mFilterButton.getVisibility() == View.VISIBLE) {
            mFilterLayout.setVisibility(View.VISIBLE);
            mFilterButton.setVisibility(View.INVISIBLE);
        } else {
            mFilterLayout.setVisibility(View.INVISIBLE);
            mFilterButton.setVisibility(View.VISIBLE);
        }
    }
}
