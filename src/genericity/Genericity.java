package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlt on 20180315.
 */
public class Genericity {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        //list.add(100);

        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // 1
            System.out.println("name:" + name);
        }

        /**
         * 定义了一个List类型的集合，先向其中加入了两个字符串类型的值，随后加入一个Integer类型的值。
         * 这是完全允许的，因为此时list默认的类型为Object类型。
         * 在之后的循环中，由于忘记了之前在list中也加入了Integer类型的值或其他编码原因，很容易出现类似于//1中的错误。
         * 因为编译阶段正常，而运行时会出现“java.lang.ClassCastException”异常。因此，导致此类错误编码过程中不易发现。
         */




    }


}

