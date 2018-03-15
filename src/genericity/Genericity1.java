package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlt on 20180315.
 */
public class Genericity1 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        System.out.println(list1.getClass() == list2.getClass());
        /**
         * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
         */

        Box<Number> name = new Box<Number>(99);
        Box<Integer> age = new Box<Integer>(712);

        getData(name);

        //The method getData(Box<Number>) in the type GenericTest is
        //not applicable for the arguments (Box<Integer>)
        //getData(age);   // 1 我们知道Box<Number>在逻辑上不能视为Box<Integer>的父类

        //在逻辑上Box<Number>不能视为Box<Integer>的父类。
        //getData()方法取出数据时到底是什么类型呢？Integer? Float? 还是Number？且由于在编程过程中的顺序不可控性，导致在必要的时候必须要进行类型判断，且进行强制类型转换。

    }

    public static void getData(Box<Number> data) {
        System.out.println("data :" + data.getData());
    }

    public static  class Box<T> {

        private T data;

        public Box() {

        }

        public Box(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
