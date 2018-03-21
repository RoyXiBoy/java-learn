package reflect.introspector;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xlt on 20180320.
 */
public class IntroSpector {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        User user =new User("zhangcan", 21);
        String propertyName = "name";

        // 直接指定要访问的属性
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, user.getClass());
        //获取到读方法
        Method readMethod = propertyDescriptor.getReadMethod();
        //反射机制调用
        Object invoke = readMethod.invoke(user, null);
        System.out.println("名字：" + invoke);

        propertyDescriptor.getWriteMethod().invoke(user,"lixin");
        invoke = readMethod.invoke(user, null);
        System.out.println("名字："  + invoke);

        //获取bean信息
        BeanInfo beanInfo = null;
        // 在Object类时候停止检索，可以选择在任意一个父类停止
        beanInfo = Introspector.getBeanInfo(user.getClass(), Object.class);

        System.out.println("所有属性描述：");
        // 获取所有的属性描述
        PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getName());
        }

        System.out.println("所有方法描述：");
        for (MethodDescriptor methodDescriptor: beanInfo.getMethodDescriptors()) {
            System.out.println(methodDescriptor.getName());
        }
        }
}
