package thread.Bank;

/**
 * Created by xlt on 20180309.
 *
 * 比较常见的例子，银行问题，我们对账户可以存钱也可以取钱，怎么保证这样的数据共享呢？
 *
 *
 场景抽象：

 每个线程执行的代码不同（比如上面的问题，对每个账户可以执行++操作和–操作），这时候需要用不同的Runnable对象，有如下两种方式来实现这些Runnable之间的数据共享
 解决方案：
 有两种方法来解决此类问题：

 将共享数据封装成另外一个对象中封装成另外一个对象中，然后将这个对象逐一传递给各个Runnable对象，每个线程对共享数据的操作方法也分配到那个对象身上完成，这样容易实现针对数据进行各个操作的互斥和通信
 将Runnable对象作为偶一个类的内部类，共享数据作为这个类的成员变量，每个线程对共享数据的操作方法也封装在外部类，以便实现对数据的各个操作的同步和互斥，作为内部类的各个Runnable对象调用外部类的这些方法。

 */
public class Bank {

    private int j = 0;

    public synchronized void add() {
        j++;
        System.out.println("线程" + Thread.currentThread().getName() + "j为：" + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println("线程" + Thread.currentThread().getName() + "j为：" + j);
    }

    public int getData() {
        return j;
    }

    public static void main(String[] args) {
        Bank data = new Bank();
        Runnable add = new AddRunnable(data);
        Runnable dec = new DecRunnable(data);
        for (int i = 0; i < 2; i++) {
            new Thread(add).start();
            new Thread(dec).start();
        }

    }
}
