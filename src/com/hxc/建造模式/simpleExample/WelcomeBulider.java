package com.hxc.建造模式.simpleExample;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class WelcomeBulider extends Builder{

    public WelcomeBulider(){
        msg = new WelcomeMessage();
    }

    @Override
    public void buildSubject() {
        msg.setSubject("欢迎标题");
    }

    @Override
    public void buildBody() {
        msg.setBody("欢迎内容");
    }
}
