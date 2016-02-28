package com.alibaba.mojb.case1; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */

/**
 * @author hongfa
 */
public class CaseObject {

    private static int sleepTotalTime = 0;

    public boolean execute(int sleepTime) throws Exception {
        System.out.println("sleep: " + sleepTime);
        sleepTotalTime += sleepTime;
        Thread.sleep(sleepTime);
        return true;
    }

    public static boolean executeStatic(int sleepTime) throws InterruptedException {
        System.out.println("sleep: " + sleepTime);
        sleepTotalTime += sleepTime;
        Thread.sleep(sleepTime);
        return true;
    }
}

