package thread;



/**
 * Created by Administrator on 2017/5/4 0004.
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("张三");
        Thread1 thread2 = new Thread1("李四");
//        Thread1 thread2 = thread1; //start方法重复调用的话，会出现java.lang.IllegalThreadStateException异常
        thread1.start();
        thread2.start();
    }


}

class Thread1 extends Thread{
    private int count = 5;
    private String name;
    public Thread1(String name){
        this.name=name;
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+name+"运行：count="+count--);
            try {

                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
