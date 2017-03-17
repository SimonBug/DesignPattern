package com.hxc.单例模式;

import sun.security.jca.GetInstance;

/**
 * 懒汉式（需要实例的时候在创建）
 * Created by Administrator on 2017/3/17 0017.
 */
public class LazySingleton {
    private static LazySingleton instance =null;

    private LazySingleton(){}

    /**
     * 使用了同步化，以处理多线程环境
     * @return
     */
    private static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
