package j.ershijiu;

import ershijiu.Student;
import ershijiu.Teacher;

/**
 * Created by Pascal on 2016/11/8.
 */
public class JavaUseScalaGeneric {
    public static void main(String[] args){
        Student<String ,Integer> s  = new Student<String, Integer>("a",1);
        System.out.println(s.getName());
        System.out.println(s.name());

        Teacher<String , Integer > t = new Teacher<String, Integer>("t", 1);
        System.out.println(t.name());
    }
}
