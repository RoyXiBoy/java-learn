package genericity;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlt on 20180320.
 */
public abstract class Generic {

    /**
     1）泛型类
     定义泛型类时，在类名后加<>，尖括号内可以定义一个或多个泛型参数，并指定泛型参数的取值范围，多个参数用逗号(,)分割，
     泛型类中定义的泛型全类可用（静态方法、静态代码块、静态成员变量除外）
     父类定义的泛型参数子类无法继承，所以子类得自己写
     * @param <T>
     */
    public class GenericClass<T extends Object> {
        T data;
        void setData(T t) {
            data = t;
        }
        T getData() {
            return data;
        }
    }


    /**
      2）泛型方法
     定义泛型方法，在方法修饰符后，返回参数前加上<>，尖括号内可以定义一个或多个泛型参数，并指定泛型参数取值范围，多个参数用逗号(,)分割
     泛型方法中定义的泛型作用域在方法内

     定义泛型方法，更多是为了表达返回值和方法形参间的关系，本例中方法第一个参数T继承AClass，第二个参数S继承T，返回值是第一个参数。
     */

    public class GenericMethodClass {
        public <T extends Object, S extends T> T setData(T t, S s) {
            //do something
            return t;
        }
    }

    /**
     * 如果仅仅是为了实现了多态，应优先使用通配符
     */
    public void addList(List<?> list) {
        //todo
    }

    /**
     * 对泛型类的类型参数赋值包含两种方法：

     1）类变量或实例化：
     */
    List<String> listS = new ArrayList<String>();

    /**
     * 2）继承
     */
    /*public class MyList<S> extends ArrayList<S> implements Closeable<S> {
        @Override
        public void close() throws IOException {

        }
    }*/

    /**
     * 对泛型方法的赋值
     */
    public class People{

    }

    public <T> T testMethod1(T t, List<T> list) {
        return null;
    }

    public <T> T testMethod2(List<T> list1, List<T> list2){
        return null;
    }

   /* public static void main(String[] args) {
        People people = null;
        List<People> list1 = null;
        Generic generic = new Generic();
        generic.testMethod1(people, list1);

        List<Integer> list2 = null;
        generic.testMethod2(list1, list2);//编译报错
    }*/

}
