package com.hxc.abstractfactory;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class AbstractFactoryBulider {
    public static AbstractAnimalFactory getFactory(String factory){
        if("animal".equals(factory)){
            return new AnimalFactory();
        }else if("color".equals(factory)){
            return new ColorFactory();
        }else{
            return null;
        }
    }
}
