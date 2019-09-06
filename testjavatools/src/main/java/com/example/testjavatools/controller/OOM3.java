package com.example.testjavatools.controller;


/**

 * @author LXA

 * 栈溢出
java.lang.StackOverflowError


Exception in thread "main" java.lang.StackOverflowError
at com.example.testjavatools.controller.OOM3.test(OOM3.java:24)
at com.example.testjavatools.controller.OOM3.test(OOM3.java:24)
at com.example.testjavatools.controller.OOM3.test(OOM3.java:24)
 */
public class OOM3 {
    public static void main(String[] args)
    {

        new OOM3().test();

    }

    public void test()

    {

        test();

    }

}
