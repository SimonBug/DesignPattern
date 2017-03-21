package com.hxc.建造模式.simpleExample;

/**
 * 导演者
 * Created by Administrator on 2017/3/21 0021.
 */
public class Director {
    Builder builder;
    /**
     * 构造子
     */
    public Director(Builder builder){
        this.builder = builder;
    }


    /**
     * 产品构造方法，负责调用各零件的建造方法
     * @param toAddress 收件人地址
     * @param fromAddress 发件人地址
     */
    public void construct(String toAddress , String fromAddress){
        this.builder.buildTo(toAddress);
        this.builder.buildFrom(fromAddress);
        this.builder.buildSubject();
        this.builder.buildBody();
        this.builder.buildSendDate();
        this.builder.sendMessage();
    }
}
