/**
 * Created by xlt on 20180309.
 *
 场景抽象：

 对于卖票系统每个线程的核心执行的代码都相同（就是票数–）。

 解决方法：

 只需创建一个Runnable,这个Runnable里有那个共享数据。

 虽然数据共享 但是会有竞争状态
 */
public class Ticket implements Runnable{

    private int ticket = 10;

    @Override
    public void run() {
        while(ticket>0){
            ticket--;
            System.out.println("当前票数为："+ticket);
        }
    }

    public static void main(String[] args) {
        Ticket t = new Ticket();
        new Thread(t).start();
        new Thread(t).start();
    }
}

