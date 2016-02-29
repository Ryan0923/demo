package com.alibaba.mojb.case2;

import java.util.concurrent.TimeUnit;

/**
 * Created by mojunbin on 2016/2/29.
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            TimeUnit.SECONDS.sleep(5);
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getId() + ":" + System.currentTimeMillis());
                }
            }).start();
        }
    }
}