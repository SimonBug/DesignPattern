package thread;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2017/5/4 0004.
 */
public class ThreadTest2 implements Runnable{
    private int count = 15;
    private String name;

    public ThreadTest2(String name){
        this.name= name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+name+"运行：count = "+count--);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test{
    public static void main(String[] args) {
//        new Thread(new ThreadTest2("张三")).start();
//        new Thread(new ThreadTest2("李四")).start();
        ThreadTest2 threadTest2 = new ThreadTest2("张三");
        new Thread(threadTest2,"A").start();
        new Thread(threadTest2,"B").start();
        new Thread(threadTest2,"C").start();
    }
}
