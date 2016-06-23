/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.lombok
 * 功能：
 * 时间：2016-06-23 12:17
 * 作者：Mr.Kiwi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private int age;
    private char sex;

}
