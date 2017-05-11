package thread;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
public class ThreadTest4 extends Thread{
    private String name;
    private Object prev;
    private Object self;

    public ThreadTest4(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    public void run(){
        int count = 10;
        while (count>=0){
            synchronized (prev){
                synchronized (self){
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadTest4 pa = new ThreadTest4("A", c, a);
        ThreadTest4 pb = new ThreadTest4("B", a, b);
        ThreadTest4 pc = new ThreadTest4("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}


