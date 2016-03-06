package com.alibaba.mojb.case2;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import java.util.Map;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Created by mojunbin on 2016/3/5.
 */
@BTrace
public class ExpandCapacityBtrace {


    @OnMethod(clazz = "java.util.HashMap", method = "resize",
            location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    public static void traceMapExpandCapacity(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,
                                              @Self Object self,int newCapacity) {
        String point = Strings.strcat(Strings.strcat(probeClass, "."), probeMethod);//java/util/HashMap.resize
        Class clazz = classForName("java.util.HashMap");
        println(Strings.strcat(point, "========================================================================"));
        println(Strings.strcat("clazz:", str(clazz)));
        print(newCapacity);
        //获取实例protected变量
        Map.Entry[] entry = (Map.Entry[]) get(field(clazz, "table", true), self);
        int threshold = getInt(field(clazz, "threshold", true), self);
        println(Strings.strcat("threshold:", str(threshold)));
        println(Strings.strcat("entry.length:", str(entry.length)));
        println(Strings.strcat(point, "-------------------------------------------------------------------------"));
    }
}
