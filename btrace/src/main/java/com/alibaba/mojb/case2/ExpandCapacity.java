package com.alibaba.mojb.case2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by mojunbin on 2016/3/2.
 */
public class ExpandCapacity {

    public static final int ONE_MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        mapExpandCapacity();
    }

    public static void mapExpandCapacity() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        Map<Integer, Byte[]> map = new HashMap<Integer, Byte[]>();//16,0.75 16*0.75=12
        int size = 16;
        for (int i = 0; i < size; i++) {
            map.put(i, new Byte[ONE_MB]);
        }
        System.out.println("Expand SIZE = " + map.size());
        TimeUnit.SECONDS.sleep(20);
    }

}
