//package com.example.catdemo.utils;
//
//
//import net.bytebuddy.implementation.bind.annotation.*;
//
//import java.lang.reflect.Method;
//import java.util.concurrent.Callable;
//
//public class MonitorMethod {
//
//    @RuntimeType
//    public static Object intercept(@This Object obj, @Origin Method method, @SuperCall Callable<?> callable, @AllArguments Object... args) throws Exception {
//        long start = System.currentTimeMillis();
//        Object resObj = null;
//        try {
//            resObj = callable.call();
//            return resObj;
//        } finally {
//            System.out.println("方法名称：" + method.getName());
//            System.out.println("入参个数：" + method.getParameterCount());
//            for (int i = 0; i < method.getParameterCount(); i++) {
//                System.out.println("入参 Idx：" + (i + 1) + " 类型：" + method.getParameterTypes()[i].getTypeName() + " 内容：" + args[i]);
//            }
//            System.out.println("出参类型：" + method.getReturnType().getName());
//            System.out.println("出参结果：" + resObj);
//            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
//        }
//    }
//}
