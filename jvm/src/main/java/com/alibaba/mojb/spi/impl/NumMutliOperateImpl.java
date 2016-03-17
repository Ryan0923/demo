package com.alibaba.mojb.spi.impl;


import com.alibaba.mojb.spi.INumOperate;

/**
 * Created by mojunbin on 2016/3/16.
 */
public class NumMutliOperateImpl implements INumOperate {
    public int operator(int a, int b) {
        int r = a * b;
        System.out.println("[SPI机制]乘法，结果：" + r);
        return r;
    }
}
