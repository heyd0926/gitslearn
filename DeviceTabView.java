package cn.robotpen.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.robotpen.app.R;


/**
 * Created by heartinfei on 2015/12/23.
 */
public class DeviceTabView extends RelativeLayout {
    private CheckedTextView ctv;
    private TextView tv;

    public DeviceTabView(Context context) {
        super(context);
    }

    public DeviceTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setClickable(true);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DeviceTabView);
        String tabText = a.getString(R.styleable.DeviceTabView_device_tab_text);

        View contentView = LayoutInflater.from(context).inflate(R.layout.device_tabview_child, null);
        ctv = (CheckedTextView) contentView.findViewById(R.id.ctv);
        tv = (TextView) contentView.findViewById(R.id.tv);

        ctv.setText(tabText);
        addView(contentView);
    }//end init

    public void showMsg(String msg) {
        tv.setText(msg);
        tv.setVisibility(TextUtils.isEmpty(msg) ? GONE : VISIBLE);
    }

    public void setChecket(boolean b) {
        ctv.setChecked(b);
    }

    public void click() {
        ViewGroup viewGroup = ((ViewGroup) getParent());
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            DeviceTabView item = (DeviceTabView) viewGroup.getChildAt(i);
            item.setChecket(item.equals(this));
        }
    }
}
