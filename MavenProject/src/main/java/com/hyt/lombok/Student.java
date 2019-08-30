package com.hyt.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hou
 * @create 2019-08-12 0:17
 **/
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class Student {

    private int id;

    private String name;

    private int age;
}
