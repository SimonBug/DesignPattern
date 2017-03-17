package com.hxc.抽象工厂;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class AbstractFactoryBuliderDemo {
    public static void main(String[] args){
        //获取动物工厂
        AbstractAnimalFactory animal = AbstractFactoryBulider.getFactory("animal");
        Animal dog = animal.getAnimal("dog");
        dog.call();
        Animal pig = animal.getAnimal("pig");
        pig.call();
        Animal cat = animal.getAnimal("cat");
        cat.call();
        //获取颜色工厂
        AbstractAnimalFactory color = AbstractFactoryBulider.getFactory("color");
        Color red = color.getColor("red");
        red.color();
        Color yellow = color.getColor("yellow");
        yellow.color();
        Color white = color.getColor("white");
        white.color();
    }
}
