package com.hxc.单例模式;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){}

    /**
     * 静态工厂方法
     */
    public static EagerSingleton getInstance(){
        return instance;
    }
}
