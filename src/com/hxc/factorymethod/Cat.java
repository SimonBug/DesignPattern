package com.hxc.factorymethod;

/**
 * 具体产品
 * Created by Administrator on 2017/3/14 0014.
 */
public class Cat implements Animal {
    @Override
    public void call() {
        System.out.println("cat call miao miao!");
    }
}
