package com.example.testjavatools.controller;

import com.example.testjavatools.deadlock.WmcDeadLockClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    //内存溢出测试；
    @RequestMapping("/index4")
    public String   hh4(){
        System.out.println("start");
        List<User> list = new ArrayList<User>();
        for (int i = 1; i < 10000; i++) {
            User o = new User(i + "", System.currentTimeMillis() + "");
            list.add(o);
            o = null;
        }
        System.out.println("end");
        try {
            Thread.sleep(100000000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "endend ";
    }


}
