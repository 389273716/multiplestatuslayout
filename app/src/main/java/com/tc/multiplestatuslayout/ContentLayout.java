package com.tc.mutilstatuslayoutlib.layout;

import android.view.View;

/**
 * author：   tc
 * date：     2017/3/16 & 下午3:36
 * version    1.0
 * description 内容布局
 * modify by
 */
public class ContentLayout implements IBaselayout {

    

    @Override
    public int getStatusView() {
        return 0;
    }

    @Override
    public void onShow(View root) {

    }

    @Override
    public void onHide(View root) {

    }

    @Override
    public void onCreateView(View root) {

    }

    @Override
    public IAnim getAnim() {
        return null;
    }

    @Override
    public ILoadData getLoadData() {
        return null;
    }
}
