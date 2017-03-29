package com.tc.mutilstatuslayoutlib.layout;


/**
 * author：   tc
 * date：     2017/3/16 & 下午3:16
 * version    1.0
 * description 控制器需要实现的逻辑
 * modify by
 */
public interface IControl {

    /**
     * 增加一种状态布局
     */
    void addStatusView(IBaseLayout layout);

    /**
     * 根据类型设置当前要展示的布局
     *
     * @param status
     */
    void setCurrentStatusLayout(int status);

}
