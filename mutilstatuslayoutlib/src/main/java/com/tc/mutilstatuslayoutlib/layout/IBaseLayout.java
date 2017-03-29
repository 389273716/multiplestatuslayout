package com.tc.mutilstatuslayoutlib.layout;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * author：   tc
 * date：     2017/3/16 & 下午2:43
 * version    1.0
 * description 所有不同状态的布局，都必须实现该接口
 * modify by
 */
public interface IBaseLayout {
    /**
     * 获取当前布局的资源id
     * @return
     */
    @LayoutRes
    int getStatusViewId();

    /**
     * 这里是当前布局被显示
     */
    void onShow();
    /**
     * 这里是当前布局被隐藏
     */
    void onHide();
    /**
     * 这里是当前布局第一次创建
     */
    void onCreateView(View root);

    /**
     * 如果布局有动画效果，这里会
     * @return
     */
    IAnim getAnim();


    int getLayoutStatus();
}
