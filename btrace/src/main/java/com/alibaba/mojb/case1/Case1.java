package com.alibaba.mojb.case1;

import java.util.Random;

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */


public class Case1 {

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        CaseObject object = new CaseObject();
        boolean result = true;
        while (result) {
            result = object.execute(random.nextInt(1000));
            Thread.sleep(1000);
        }
    }

}