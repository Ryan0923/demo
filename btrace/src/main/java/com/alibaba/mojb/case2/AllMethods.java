package com.alibaba.mojb.case2;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * This script traces method entry into every method of
 * every class in javax.swing package! Think before using
 * this script -- this will slow down your app significantly!!
 */
@BTrace
public class AllMethods {
    @OnMethod(
            clazz = "java.lang.Thread",
            method = "start"
    )
    public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod) {
        print(BTraceUtils.Strings.strcat("entered ", probeClass));
        println(BTraceUtils.Strings.strcat(".", probeMethod));
    }
}