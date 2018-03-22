package object.clone.shadowclone;

import java.io.Serializable;

/**
 * Created by xlt on 20180322.
 */

//浅克隆
public class Person implements Cloneable, Serializable{

    private String name;

    private int age;

    private Person classmate;

    public Person(String name, int age, Person classmate){
        this.name = name;
        this.age = age;
        this.classmate = classmate;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getClassmate() {
        return classmate;
    }

    public void setClassmate(Person classmate) {
        this.classmate = classmate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("张灿", 23, new Person());
        Person p2 = (Person)p1.clone();

        System.out.println(p1 == p2);
        System.out.println(p1.getName() + " " + p2.getName());
        System.out.println(p1.getAge() + " " + p2.getAge());
        System.out.println(p1.classmate == p2.classmate);

        /*
         *明显可以得出的是 p1 和 p2 不同，但是他们的classmate依旧相同
         */
    }
}
