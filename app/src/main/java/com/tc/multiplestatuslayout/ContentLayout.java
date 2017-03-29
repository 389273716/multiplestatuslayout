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
public class ContentLayout implements IBaseLayout {



    @Override
    public int getStatusViewId() {
        return R.layout.base_content;
    }

    @Override
    public void onShow() {
        //这里是当前布局被显示
    }

    @Override
    public void onHide() {
        //这里是当前布局被隐藏
    }


    @Override
    public void onCreateView(View root) {
        //第一次创建布局会回调这个方法
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
