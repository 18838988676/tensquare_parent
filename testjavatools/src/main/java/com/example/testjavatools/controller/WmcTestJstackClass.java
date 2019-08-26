package com.example.testjavatools.controller;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
//占用大量CPU模拟，多线程竞争synchronized锁，
public class WmcTestJstackClass {

    public static Executor executor =Executors.newFixedThreadPool(5);
    public static  Object lock=new Object();
    static  class  Task implements  Runnable{
        @Override
        public void run() {
            synchronized (lock){
                wmcTestMethodByUseWhile();
            }
        }
        public void wmcTestMethodByUseWhile(){
            int i=0;
            while (true){
                i++;
            }
        }
    }
    //占用大量CPU模拟 锁
    public static String wmcTestJstackByHighCPUAndSynchronized () {
        System.out.println("开始");
        Task task1=new Task();
        Task task2=new Task();
        executor.execute(task1);
        executor.execute(task2);
        System.out.println("结算");
        return  "000000000000";
    }
    static class TestWait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lock.wait();
                    //TimeUnit.SECONDS.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //占用大量CPU模拟 等待
    public static String wmcTestJstackByHighCPUAndWait() {
        System.out.println("开始1111");
        TestWait TestWait1=new TestWait();
        TestWait TestWait2=new TestWait();
        executor.execute(TestWait1);
        executor.execute(TestWait2);
        System.out.println("结算111");
        return  "000000000000111";
    }







}
