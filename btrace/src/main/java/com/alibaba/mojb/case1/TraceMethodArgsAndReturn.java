package com.alibaba.mojb.case1;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceMethodArgsAndReturn {
    @OnMethod(clazz = "CaseObject", method = "execute", location = @Location(Kind.RETURN))
    public static void traceExecute(@Self Object instance, int sleepTime, @Return boolean result,
                                    @Duration long durationL) {
        println();
        println("======================================");
        println("call CaseObject.execute");
        println(strcat("sleepTime is:", str(sleepTime)));
        println(strcat("sleepTotalTime is:",
            str(get(field("CaseObject", "sleepTotalTime"), instance))));
        println(strcat("return value is:", str(result)));
        println(strcat("duration value is:", str(durationL)));
        println("======================================");
        println();
    }
}