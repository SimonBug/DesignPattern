package com.hxc.单例模式;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class Singleton1 {
    private Singleton1(){}

    /**
     *    类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     *    没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class Singleton1Holder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static Singleton1 instance = new Singleton1();
    }

    public static Singleton1 getInstance(){
        return Singleton1Holder.instance;
    }
}
