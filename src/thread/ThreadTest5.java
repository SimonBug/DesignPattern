package thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        List list = new LinkedList();
        Thread thread1 = new Thread(new ReadList(list));
        Thread thread2 = new Thread(new WriteList(list));
        thread1.start();
        thread2.start();
    }
}

class ReadList implements Runnable{
    private List list;

    public ReadList(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("ReadList begin at ---"+System.currentTimeMillis());
        synchronized (list){
            try {
                Thread.sleep(1000);
                System.out.println("ReadList list.wait() begin at ---"+System.currentTimeMillis());
                list.wait();
                System.out.println("ReadList list.wait() end at---"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ReadList end at ---"+System.currentTimeMillis());
    }
}

class WriteList implements Runnable{
    private List list;

    public WriteList(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("WriteList begin at ---"+System.currentTimeMillis());
        synchronized (list){
            System.out.println("WriteList get lock at ---"+System.currentTimeMillis());
            list.notify();
            System.out.println("WriteList list.notify(); at ---"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WriteList get out of lock at ---"+System.currentTimeMillis());
        }
        System.out.println("WriteList end at ---"+System.currentTimeMillis());
    }
}
