package com.hyt.lombok;

/**
 * @author hou
 * @create 2019-08-12 0:20
 **/
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(1);
        s1.setAge(11);
        Student s2 = new Student();
        s2.setId(2);
        s2.setAge(11);
        System.out.println(s1.equals(s2));
    }

}
