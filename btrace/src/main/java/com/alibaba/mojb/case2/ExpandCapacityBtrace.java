package com.alibaba.mojb.case2;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;
import java.util.Map;

import static com.sun.btrace.BTraceUtils.*;
import static com.sun.btrace.BTraceUtils.println;

/**
 * Created by mojunbin on 2016/3/5.
 */
@BTrace
public class ExpandCapacityBtrace {


    @OnMethod(clazz = "java.util.HashMap", method = "resize",
            location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    public static void traceMapExpandCapacity(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,
                                              @Self java.util.HashMap self) {
        String point = Strings.strcat(Strings.strcat(probeClass, "."), probeMethod);
        println(Strings.strcat(point, "========================================================================"));
        Map.Entry[] entry = (Map.Entry[]) get(field("java.util.HashMap", "table"), self);
        //获取实例protected变量
        Strings.strcat("threshold:", get(field("java.util.HashMap", "threshold"), self).toString());
        Strings.strcat("entry:", entry.toString());
        println(Strings.strcat(point, "-------------------------------------------------------------------------"));
    }
}
