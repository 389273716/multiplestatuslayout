package com.tc.mutilstatuslayoutlib.layout;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewStub;
import android.widget.FrameLayout;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

/**
 * author：   tc
 * date：     2017/3/16 & 下午3:12
 * version    1.0
 * description 不同状态布局的控制器，
 * modify by
 */
public class StatusLayoutController extends FrameLayout implements IControl {


    /**
     * 状态布局初始化后的view集合，key是布局type，value为布局初始化后的view
     */
    private HashMap<Integer, IBaseLayout> mStatusLayoutViews = new HashMap<>();

    public StatusLayoutController(@NonNull Context context) {
        super(context);
    }

    public StatusLayoutController(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusLayoutController(@NonNull Context context, @Nullable AttributeSet attrs,
                                  @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void addStatusView(IBaseLayout baseLayout) {
        if (baseLayout == null) {
            throw new NullPointerException("layout is null! ");
        }
        if (mStatusLayoutViews.get(baseLayout.getLayoutStatus()) == null) {
            mStatusLayoutViews.put(baseLayout.getLayoutStatus(), baseLayout);
            this.addView(new ViewStub(getContext(), baseLayout.getStatusViewId()));
        } else {
            Log.i(TAG, "addStatusView:this status layout had add!");
        }
    }

    @Override
    public void setStatusLayout(int status) {
        for (Integer layoutStatus : mStatusLayoutViews.keySet()) {
            IBaseLayout iBaseLayout = mStatusLayoutViews.get(layoutStatus);
            if (iBaseLayout != null) {
                iBaseLayout.onShow();
            }
        }
    }

    @Override
    public void removeStatusLayout(int status) {

    }


}
