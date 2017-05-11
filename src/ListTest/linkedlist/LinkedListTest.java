package ListTest.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public class LinkedListTest {

    public static void main(String [] args){
        List list1 = new LinkedList();
        List list2 = new LinkedList();

        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("DDD");
        list2.add("ddd");
        list2.add("eee");
        list2.add("fff");
        list2.add("ggg");

        ListIterator iterator1 = list1.listIterator();//使用add的时候是将元素添加到当前元素的前面
        Iterator iterator2 = list2.iterator();
        //将list2存入list1中
        while (iterator2.hasNext()){
            if(iterator1.hasNext()){
                iterator1.next();//跳过一个元素
                iterator1.add(iterator2.next());
            }
        }
        System.out.println("list1="+list1);
        //删除list2中第二个元素
        while (iterator2.hasNext()){
            iterator2.next();//跳过一个元素
            if(iterator2.hasNext()){
                iterator2.next();
                iterator2.remove();
            }
        }
        System.out.println("list2="+list2);

        list1.removeAll(list2);
        System.out.println("list1="+list1);
    }
}
