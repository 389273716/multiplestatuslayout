package com.tc.multiplestatuslayout;

import android.view.View;

import com.tc.mutilstatuslayoutlib.layout.IAnim;
import com.tc.mutilstatuslayoutlib.layout.IBaseLayout;

/**
 * author：   tc
 * date：     2017/3/16 & 下午3:36
 * version    1.0
 * description 内容布局
 * modify by
 */
public class FailureLayout implements IBaseLayout {



    @Override
    public int getStatusViewId() {
        return 0;
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onHide() {

    }


    @Override
    public void onCreateView(View root) {

    }

    @Override
    public IAnim getAnim() {
        return null;
    }

    @Override
    public int getLayoutStatus() {
        return 0;
    }
}
