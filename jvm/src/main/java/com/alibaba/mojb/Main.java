package com.alibaba.mojb;

import com.alibaba.mojb.spi.INumOperate;
import com.alibaba.mojb.spi.impl.NumPlusOperateImpl;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {

        int a = 9;
        int b = 3;

        // 普通的实现类机制，加法
        INumOperate plus = new NumPlusOperateImpl();
        plus.operator(a, b);

        // SPI机制，寻找所有的实现类，顺序执行
        ServiceLoader<INumOperate> loader = ServiceLoader.load(INumOperate.class); // 查找SPI实现类，并加载到jvm
        Iterator<INumOperate> iter = loader.iterator();
        while (iter.hasNext()) {
            INumOperate op = iter.next();
            op.operator(a, b);
        }
    }
}
