package com.hxc.工厂方法;

/**
 * 工厂类
 * Created by Administrator on 2017/3/14 0014.
 */
public class AnimalFcatory {
    public Animal getAnimal(String animal){
        if("cat".equals(animal)){
            return new Cat();
        }else if("dog".equals(animal)){
            return new Dog();
        }else if("pig".equals(animal)){
            return new Pig();
        }else{
            return null;
        }
    }
}
