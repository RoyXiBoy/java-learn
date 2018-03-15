package thread.Thread;


/**
 * Created by xlt on 20180315.
 */
public class Thread1 extends java.lang.Thread{

    private String name;

    public Thread1(String name){
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

    public static void main(String[] args) {
        System.out.println(" 主线程运行开始!");
        Thread1 a = new Thread1("A");
        Thread1 b = new Thread1("B");

        /*a.run();
        b.run();*/


        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" 主线程运行结束!");
        //直接点run是调用
        //点start()是启动新线程
    }
}


