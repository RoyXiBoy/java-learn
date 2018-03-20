package reflect;

/**
 * Created by xlt on 20180315.
 */

/**
 * from:http://blog.csdn.net/sinat_38259539/article/details/71799078
 */
public class ClassSearch {

    public static void main(String[] args) {

        /*
        在运行期间，一个类，只有一个Class对象产生。
        三种方式常用第三种，第一种对象都有了还要反射干什么。
        第二种需要导入类的包，依赖太强，不导包就抛编译错误。
        一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法。
         */

        /*
        基本类型可以通过".class"语法获得相应的类，但也可以通过其包裹类的TYPE属性（field）获得。

        Class c = Double.TYPE; // 即 double.class

        Class c = Void.TYPE; // void.class
         */

        //第一种方式获取Class对象
        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。
        java.lang.Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        java.lang.Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        try {
            java.lang.Class stuClass3 = java.lang.Class.forName("reflect.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
