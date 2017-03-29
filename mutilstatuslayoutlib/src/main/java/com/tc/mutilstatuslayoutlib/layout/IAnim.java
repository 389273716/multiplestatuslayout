package com.tc.mutilstatuslayoutlib.layout;

/**
 * author：   tc
 * date：     2017/3/16 & 下午3:09
 * version    1.0
 * description 动画接口，处理动画创建以及展示，销毁
 * modify by
 */
public interface IAnim {

    void initAnim();

    void start();

    void stop();

    void destroy();

}
