package com.example.testjavatools.deadlock;

/**
 * 简单的应用,供测试JDK自带的jstack使用 本应用会造成deadlock，可能会导致系统崩溃
 * 逻辑：一旦两个线程互相等待的局面出现，死锁（deadlock）就发生了
 */
public class WmcDeadLockClass extends Thread {

    private DeadLockResource resourceManger;// 资源管理类的私有引用，通过此引用可以通过其相关接口对资源进行读写
    private int a, b;// 将要写入资源的数据

    public static void main(String[] args) throws Exception {
        DeadLockResource resourceManager = new DeadLockResource();
        WmcDeadLockClass stack1 = new WmcDeadLockClass(resourceManager, 1, 2);
        WmcDeadLockClass stack2 = new WmcDeadLockClass(resourceManager, 3, 4);
        stack1.start();
        stack2.start();
    }
    public static void testDeadLockMethod()  {
        System.out.println("开始测试死锁");
        DeadLockResource resourceManager = new DeadLockResource();
        WmcDeadLockClass stack1 = new WmcDeadLockClass(resourceManager, 1, 2);
        WmcDeadLockClass stack2 = new WmcDeadLockClass(resourceManager, 3, 4);
        stack1.start();
        stack2.start();
        System.out.println("结束测试死锁");
    }


    public WmcDeadLockClass(DeadLockResource resourceManager, int a, int b) {
        this.resourceManger = resourceManager;
        this.a = a;
        this.b = b;
    }

    public void run() {
        while (true) {
            this.resourceManger.read();
            this.resourceManger.write(this.a, this.b);
        }
    }

}