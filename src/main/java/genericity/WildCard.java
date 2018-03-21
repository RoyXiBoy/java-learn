package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlt on 20180320.
 * 通配符
 */
public class WildCard {

    //存放任意的对象
    List<?> list;

    //存放AClass的子类
    List<? extends String> listSubAClass;

    //存放BClass的父类
    List<? extends String> listSuperBClass;

    /**
     * 通配符不能用在泛型类和泛型方法声明中
     */

    /**
     * 泛型关键字
     1、泛型关键字有二个 extends和super，分别表示类型上界和类型下界

     extends AClass 表示T继承自AClass类
     ? super AClass 表示?是AClass的父类，注意：super只能与通配符?搭配使用，我们不能写：

     public class GenericClass<T super AClass> { //错误
     }
     此例子中super换成extends是正确的，表示泛型T继承自AClass，T换成通配符?也是可以的，表示未知类型的下界是AClass。
     */

    /**
     * 下界
     */
    public static class People{

    }

    public static void main(String[] args) {
        List<? super People> list = new ArrayList<>();
        People people = new People();
        list.add(people);
        //编译出错，报错Object不能转为People
        // People data= list.get(0 );

        /**
         * 上界：
         */
        List<? extends People> list1 = new ArrayList<>();
        People people1 = new People();
        // 编译出错，不能向容器中添加确定的元素
        //list1.add(people1);
        People data1= list1.get(0);
    }


}
