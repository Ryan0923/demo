/**
 * Created by mojunbin on 2017/6/22.
 */
public class Person {
    public static void main(String[] args) {
        Person[] arr = new Employee[5];
        arr[0] = new Student();
    }

    static class Employee extends Person {

    }

    static class Student extends Person {

    }
}
