package thread.Thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        Integer a = 5;
        //Integer b = 6;

        List<Integer> list = new ArrayList<>();
        list.add(a);
        //list.add(b);

        System.out.println(list.stream().min((x,y)->x>y?1:-1).get());
    }

}
