package com.tc.mutilstatuslayoutlib.layout;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
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
public class StatusLayout extends FrameLayout implements IControl {

    /**
     * 是否已经加载过，主要用来判断viewstub是否初始化了
     */
    private HashMap<Integer, Boolean> mLayoutInitType = new HashMap<>();
    /**
     * 用来存放viewstub对象。
     */
    private HashMap<Integer, ViewStub> mViewStubs = new HashMap<>();
    /**
     * 用来存放每个viewstub inflate后的view对象。
     */
    private HashMap<Integer, ViewStub> mRootViews = new HashMap<>();
    /**
     * 状态布局初始化后的view集合，key是布局type，value为布局初始化后的view
     */
    private HashMap<Integer, IBaseLayout> mStatusLayoutViews = new HashMap<>();

    public StatusLayout(@NonNull Context context) {
        super(context);
    }

    public StatusLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusLayout(@NonNull Context context, @Nullable AttributeSet attrs,
                        @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void addStatusView(IBaseLayout baseLayout) {
        if (baseLayout == null) {
            throw new NullPointerException("layout is null! ");
        }
        int layoutStatus = baseLayout.getLayoutStatus();
        if (mStatusLayoutViews.get(layoutStatus) == null) {
            mLayoutInitType.put(layoutStatus, false);
            mStatusLayoutViews.put(layoutStatus, baseLayout);
            ViewStub viewStub = new ViewStub(getContext(), baseLayout.getStatusViewId());
            mViewStubs.put(layoutStatus, viewStub);
            this.addView(viewStub);
        } else {
            Log.i(TAG, "addStatusView:this status layout had add!");
        }
    }

    @Override
    public void setCurrentStatusLayout(int status) {
        for (Integer layoutStatus : mStatusLayoutViews.keySet()) {
            IBaseLayout iBaseLayout = mStatusLayoutViews.get(layoutStatus);
            if (iBaseLayout != null) {
                if (!mLayoutInitType.get(status)) {
                    View inflate = mViewStubs.get(layoutStatus).inflate();
                    iBaseLayout.onCreateView(inflate);
                    mLayoutInitType.put(status, true);
                }
                if (status != layoutStatus) {
                    mRootViews.get(layoutStatus).setVisibility(GONE);
                    iBaseLayout.onHide();
                    continue;
                }
                mRootViews.get(layoutStatus).setVisibility(VISIBLE);
                iBaseLayout.onShow();

            }

        }
    }



}
