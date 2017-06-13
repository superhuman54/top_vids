package kimkihwan.navercorp.com.top100.toprank.adapter.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Set;

import kimkihwan.navercorp.com.top100.R;

/**
 * Created by jamie on 2017. 6. 12..
 */

public class FilterSelector extends FrameLayout implements RadioGroup.OnCheckedChangeListener{

    private final static String TAG = FilterSelector.class.getSimpleName();

    private RadioGroup mFilterRadioGroup;

    private OnFilterSelectedListener mListener;

    public FilterSelector(Context context) {
        super(context);
        init();
    }

    public FilterSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.filter_selector_layout, this);
        mFilterRadioGroup = (RadioGroup) findViewById(R.id.radiogroup_filter);
        mFilterRadioGroup.setOnCheckedChangeListener(this);
        RadioGroup.LayoutParams rprms;

        Set<Filter> filters = FilterLoader.getInstance().getFilters();
        for (Filter filter : filters) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(filter.name);
            radioButton.setTag(filter);
            radioButton.setBackgroundResource(R.drawable.filter_selector_radio_button_background);
            radioButton.setTextColor(getResources().getColorStateList(R.color.filter_selector_radio_button_font));
            radioButton.setButtonDrawable(null);
            rprms = new RadioGroup.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.top_rank_filter_item_width),
                    getResources().getDimensionPixelOffset(R.dimen.top_rank_filter_item_height));
            radioButton.setPadding(getResources().getDimensionPixelOffset(R.dimen.top_rank_filter_item_padding_left), 0, 0, 0);
            radioButton.setTextSize(13.50f);
//            if (filter.isDefault)
//                radioButton.setChecked(true);
            mFilterRadioGroup.addView(radioButton, rprms);
        }

    }

    public void setOnFilterSelectedListener(OnFilterSelectedListener listener) {
        mListener = listener;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton child = (RadioButton) group.findViewById(checkedId);
        Filter filter = (Filter) child.getTag();
        if (mListener != null) {
            mListener.onSelected(filter);
        }
    }

    public interface OnFilterSelectedListener {
        void onSelected(Filter filter);
    }
}
