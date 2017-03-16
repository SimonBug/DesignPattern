package com.hxc.factorymethod;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class AnimalFcatoryDemo {
    public static void main(String[] arg){
        AnimalFcatory animalFcatory = new AnimalFcatory();
        Animal dog = animalFcatory.getAnimal("dog");
        dog.call();

        Animal pig = animalFcatory.getAnimal("pig");
        pig.call();

        Animal cat = animalFcatory.getAnimal("cat");
        cat.call();
    }
}
