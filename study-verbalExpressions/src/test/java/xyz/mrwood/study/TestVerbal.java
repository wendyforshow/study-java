/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.junit.Test;
import ru.lanwen.verbalregex.VerbalExpression;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-08-13 23:59
 * 作者：Mr.Kiwi
 */
public class TestVerbal {

    @Test
    public void testDemo(){

//        VerbalExpression testRegex = VerbalExpression.regex().
//            startOfLine().then("a").
//            anything().
//            endOfLine().then("b").
//            build();
//        System.out.println(testRegex.toString());
//
//        String str = "a123dddb";
//        System.out.println(testRegex.test(str));

        VerbalExpression.Builder regex = VerbalExpression.regex();
        regex.startOfLine().then("<p>").anything().digit().anything().endOfLine().then("</p>");

        VerbalExpression build = regex.build();
        System.err.println(build.test("<p>aa1111aa</p>"));
        System.err.println(build.getText("<p>aa1111aa</p>"));

    }

}
