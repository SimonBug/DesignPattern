package thread;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 内置锁和显示锁
 * Created by Administrator on 2017/5/10 0010.
 */
public class ReentrantLockTest{


    public static void main(String[] args) {
        for(int i = 0;i<5;i++){
            rwTest();
        }
        for(int i = 0;i<5;i++){
            synTest();
        }
    }

    //显示锁
    private static void synTest() {
        LinkedList list = new LinkedList();
        for(int i=0;i<10000;i++){
            list.add(i);
        }
        final SynList synList = new SynList(list);

        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synList.put(i);
                }
            }
        });

        Thread reader1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<10000;i++){
                    synList.get(i);
                }
            }
        });
        Thread reader2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<10000;i++){
                    synList.get(i);
                }
            }
        });

        long beginTime = System.currentTimeMillis();
        writer.start();
        reader1.start();
        reader2.start();
        try {
            writer.join();
            reader1.join();
            reader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SynList need  "+(System.currentTimeMillis()-beginTime));
    }

    //读写锁测试
    private static void rwTest() {
        List list = new LinkedList();
        for(int i = 0;i<10000;i++){
            list.add(i);
        }
        final RWLockList rwLockList = new RWLockList(list);//初始化数据
        Thread writer = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<10000;i++){
                    rwLockList.put(i);
                }
            }
        });

        Thread reader1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<10000;i++){
                    rwLockList.get(i);
                }
            }
        });
        Thread reader2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<10000;i++){
                    rwLockList.get(i);
                }
            }
        });

        long beginTime = System.currentTimeMillis();
        writer.start();
        reader1.start();
        reader2.start();
        try {
            writer.join();
            reader1.join();
            reader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RWLockList need  "+(System.currentTimeMillis()-beginTime));
    }
}

class RWLockList{//读写锁
    private List list;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();//读锁
    private final Lock writeLock = lock.writeLock();//写锁

    public RWLockList(List list) {
        this.list = list;
    }

    public int get(int index){
        readLock.lock();
        try {
            return (int)list.get(index);
        }finally {
            readLock.unlock();
        }
    }

    public void put(int value){
        writeLock.lock();
        try {
            list.add(value);
        }finally {
            writeLock.unlock();
        }
    }

}

class SynList{//同步锁
    private List list;

    public SynList(List list) {
        this.list = list;
    }

    public synchronized int get(int index){
        return (int)list.get(index);
    }

    public synchronized  void put(int value){
        list.add(value);
    }
}
