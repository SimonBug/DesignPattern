package com.hxc.抽象工厂;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class AnimalFactory extends AbstractAnimalFactory{
    @Override
        Animal getAnimal(String animal) {
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

    @Override
    Color getColor(String color) {
        return null;
    }
}
