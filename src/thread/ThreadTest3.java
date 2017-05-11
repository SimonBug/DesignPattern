package thread;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
public class ThreadTest3 extends Thread{
    private String name;
    public ThreadTest3(String name){
        this.name = name;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+"现成开始---");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}

class Test2{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        ThreadTest3 thread1 = new ThreadTest3("A");
        ThreadTest3 thread2 = new ThreadTest3("A");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
    }
}
