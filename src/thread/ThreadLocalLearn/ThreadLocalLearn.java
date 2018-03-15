package thread.ThreadLocalLearn;

import java.util.function.Supplier;

/**
 * Created by xlt on 20180309.
 */
public class ThreadLocalLearn {

    static ThreadLocal<IntHolder> tl = ThreadLocal.withInitial(new Supplier<IntHolder>() {
        @Override
        public IntHolder get() {
            return new IntHolder();
        }
    });

    /*static ThreadLocal<IntHolder> tl = new ThreadLocal<IntHolder>(){

        @Override
        protected IntHolder initialValue() {

            return new IntHolder();
        }

    };*/

    public static void main(String args[]) {

        for(int i=0; i<5; i++) {

            Thread th = new Thread(new ThreadTest(tl, i));
            th.start();
        }
    }
}

class ThreadTest implements Runnable{

    /**
     * threadlocal变量
     */
    ThreadLocal<IntHolder> tl ;
    int i;

    //线程局部变量
    int a = 3;

    public ThreadTest(ThreadLocal<IntHolder> tl, int i) {
        super();
        this.tl = tl;
        this.i = i;
    }

    @Override
    public void run() {

        tl.get().increAndGet();
        a++;
        System.out.println(tl.get().getA() + " ");
        System.out.println("a : " + a);
    }

}

class IntHolder{

    int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int increAndGet() {

        return ++a;
    }
}
