package object.clone.deepclone;

import com.google.gson.Gson;
import object.clone.shadowclone.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by xlt on 20180321.
 */
//深克隆是指复制一个对象的实例，而且这个对象中包含的其它的对象也要复制一份。
public class  Clone {
    private Clone() {
        throw new AssertionError();
    }

    public static <T> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        try{
            oos.writeObject(obj);
        }catch (Exception e){
            e.printStackTrace();
        }


        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
        //基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，
        // 这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用Object类的clone方法克隆对象。
    }

    public static  <T>T clone2(T obj)throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return (T) gson.fromJson(json, obj.getClass());
    }

    public static void main(String[] args) throws Exception {

        Person p1 = new Person("张灿", 23, new Person());
        Person p2 = Clone.clone(p1);

        p2.setAge(33);

        System.out.println(p1 == p2);
        System.out.println(p1.getAge() + " " + p2.getAge());
        System.out.println(p1.getClassmate() == p2.getClassmate());

        Person p3 = Clone.clone2(p2);

        p3.setAge(44);
        System.out.println(p3 == p2);
        System.out.println(p3.getAge() + " " + p2.getAge());
        System.out.println(p3.getClassmate() == p2.getClassmate());

        /*try {
                Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
                Person p2 = MyUtil.clone(p1);
                // 深度克隆
                p2.getCar().setBrand("BYD");
                // 修改克隆的Person对象p2关联的汽车对象的品牌属性
                // 原来的Person对象p1关联的汽车不会受到任何影响
                // 因为在克隆Person对象时其关联的汽车对象也被克隆了
                System.out.println(p1);
            } catch (Exception e) {
                e.printStackTrace();
            }*/

    }

}
