package genericity;

/**
 * Created by xlt on 20180315.
 */

/**
 * 类型通配符   类型通配符上限和类型通配符下限
 */
public class Genericity2 {
    public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        getData(name);
        getData(age);
        getData(number);

        //getUpperNumberData(name); // 1
        getUpperNumberData(age);    // 2
        getUpperNumberData(number); // 3

        //getUnderNumberData(name); // 1
        getUnderNumberData(age);    // 2
        getUnderNumberData(number); // 3
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    //通配符上限
    public static void getUpperNumberData(Box<? extends Number> data){
        System.out.println("data :" + data.getData());
    }

    public static void getUnderNumberData(Box<? super Integer> data){
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
