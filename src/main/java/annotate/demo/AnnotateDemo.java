package annotate.demo;

import annotate.ExcelField;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

public class AnnotateDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Excel excel1 = new Excel();
        Excel excel2 = new Excel();

        Field field = Excel.class.getDeclaredField("a");
        //获取val字段上的Foo注解实例

        ExcelField e = field.getAnnotation(ExcelField.class);
        System.out.println(e.red());

        //InvocationHandler memberValues储存了 map。 map内储存了注解上的值
        InvocationHandler h = Proxy.getInvocationHandler(e);
        Field hField = h.getClass().getDeclaredField("memberValues");
        // 因为这个字段事 private final 修饰，所以要打开权限
        hField.setAccessible(true);
        // 获取 memberValues
        Map memberValues = (Map) hField.get(h);
        // 修改 value 属性值
        memberValues.put("red", 1);

        System.out.println(e.red());

    }

}

