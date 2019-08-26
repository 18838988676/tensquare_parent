package com.example.testjavatools.controller;

import com.example.testjavatools.deadlock.WmcDeadLockClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping("/index")
    public String  hh(){
        System.out.println("123");
        return  "wmc";
    }
    //占用大量CPU模拟 锁
    @RequestMapping("/index1")
    public String  hh1(){
         return WmcTestJstackClass.wmcTestJstackByHighCPUAndSynchronized();
    }
    //占用大量CPU模拟 等待
    @RequestMapping("/index2")
    public String  hh2(){
        return WmcTestJstackClass.wmcTestJstackByHighCPUAndWait();
    }

    /**
     * 简单的应用,供测试JDK自带的jstack使用 本应用会造成deadlock，可能会导致系统崩溃
     * 逻辑：一旦两个线程互相等待的局面出现，死锁（deadlock）就发生了
     */
    @RequestMapping("/index3")
    public void   hh3(){
        System.out.println("start................");
         WmcDeadLockClass.testDeadLockMethod();
    }



}
