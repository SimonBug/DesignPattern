package com.hxc.抽象工厂;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class ColorFactory extends AbstractAnimalFactory{
    @Override
    Animal getAnimal(String animal) {
        return null;
    }

    @Override
    Color getColor(String color) {
        if("red".equals(color)){
            return new Red();
        }else if("white".equals(color)){
            return new White();
        }else if("yellow".equals(color)){
            return new Yellow();
        }else{
            return null;
        }
    }
}
