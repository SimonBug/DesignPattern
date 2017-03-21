package com.hxc.建造模式.simpleExample;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class Client {
    public static void main(String args[]){

        Director director = new Director(new WelcomeBulider());
        director.construct("toAddress@126.com","fromAddress@126.com");
    }
}
