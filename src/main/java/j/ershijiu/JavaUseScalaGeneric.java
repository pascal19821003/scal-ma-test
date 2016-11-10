package java.ershijiu;

import ershijiu.Student;

/**
 * Created by Pascal on 2016/11/8.
 */
public class JavaUseScalaGeneric {
    public static void main(String[] args){
        Student<String ,Integer> s  = new Student<String, Integer>("a",1);
        System.out.println(s.getName());
        System.out.println(s.name());
    }
}
