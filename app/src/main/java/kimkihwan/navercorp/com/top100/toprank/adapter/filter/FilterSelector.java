package kimkihwan.navercorp.com.top100.toprank.adapter.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import kimkihwan.navercorp.com.top100.R;

/**
 * Created by jamie on 2017. 6. 12..
 */

public class FilterSelector extends LinearLayout implements RadioGroup.OnCheckedChangeListener{

    private final static String TAG = FilterSelector.class.getSimpleName();

    private OnFilterSelectedListener mListener;
    private RadioGroup mFilterParent;

    public FilterSelector(Context context) {
        super(context);
        init();
    }

    public FilterSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FilterSelector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.filter_selector_layout, this);
        mFilterParent = (RadioGroup) findViewById(R.id.filter_parent);
        mFilterParent.setOnCheckedChangeListener(this);
        RadioGroup.LayoutParams rprms;

        Filter[] filters = Filter.values();
        for (Filter meta : filters) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(meta.name);
            radioButton.setTag(meta);
            radioButton.setBackgroundResource(R.drawable.filter_selector_radio_button_background);
            radioButton.setButtonDrawable(null);
            rprms = new RadioGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            mFilterParent.addView(radioButton, rprms);
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
