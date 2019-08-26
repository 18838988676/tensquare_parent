package com.example.testjavatools.controller;
import java.util.*;


/*

循环创建实例变量，不释放===》内存溢出demo；

可以让JVM在出现内存溢出(OOME)时候Dump出当前的内存堆文件地址
-Xmx1g -Xms1g -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=c:\a
以上生成*.hprof（java_pid9984.hprof）以后，就可以分析你的java线程里面对象占用堆内存的情况了
推荐使用Eclipse插件Memory Analyzer Tool来打开heap.hprof文件。



dump文件怎么生成和分析
获取JVM的dump文件方式：
第一种：
#出现 OOME 时生成堆 dump:
-XX:+HeapDumpOnOutOfMemoryError
#生成堆文件地址：
-XX:HeapDumpPath=/home/liuke/jvmlogs/
由于第一种方式是一种事后方式，需要等待当前JVM出现问题后才能生成dmp文件，实时性不高；

第二种方式
发现程序异常前通过执行指令，直接生成当前JVM的dmp文件，6214是指JVM的进程号
jmap -dump:format=b,file=/home/admin/logs/heap.hprof 6214
第二种方式在执行时，JVM是暂停服务的，所以对线上的运行会产生影响。所以建议第一种方式。

---------------------------------------------------------
导出整个JVM 中内存信息，可以利用其它工具打开dump文件分析，例如jdk自带的visualvm工具
jmap -dump:format=b,file=c:\a\文件名.dmp  10576(pid)
　　format=b指定为二进制格式文件
* */
public class OOMtest {
    private static List list = new ArrayList();
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("申请前的可用内存 = "+getFreeMemory());
        while(true){
            list.add(new byte[512*512]);//用实例变量申请1M内存，当方法执行完毕时，这个static的变量是不会被释放
            count++;
            if (count % 100 == 0) {
                System.out.println("当前list.size()="+list.size()+",可用内存 = "+getFreeMemory());
                Thread.sleep(500);
            }
        }
    }
    public static long getFreeMemory() {
        return Runtime.getRuntime().freeMemory() / (1024 * 1024);
    }
}
/*
*jdk1.8 Hotspot虚拟机参数通用配置
*
*16G内存 JDK8 生产服务器配置未验证，先丢完整配置

JAVA_OPTS="-server -Xmx4g -Xms4g -Xmn256m -Xss256k -XX:+DisableExplicitGC  -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -Duser.timezone=GMT+8"

-server//服务器模式
-Xmx4g //JVM最大允许分配的堆内存，按需分配
-Xms4g //JVM初始分配的堆内存，一般和Xmx配置成一样以避免每次gc后JVM重新分配内存。
-Xmn256m //年轻代内存大小，整个JVM内存=年轻代 + 年老代 + 持久代
-Xss512k //设置每个线程的堆栈大小
-XX:+DisableExplicitGC //忽略手动调用GC, System.gc()的调用就会变成一个空调用，完全不触发GC
-XX:+UseConcMarkSweepGC //并发标记清除（CMS）收集器
-XX:+CMSParallelRemarkEnabled //降低标记停顿
-XX:LargePageSizeInBytes=128m //内存页的大小
-XX:+UseFastAccessorMethods //原始类型的快速优化
-XX:+UseCMSInitiatingOccupancyOnly //使用手动定义初始化定义开始CMS收集
-XX:CMSInitiatingOccupancyFraction=70 //使用cms作为垃圾回收使用70％后开始CMS收集

-Duser.timezone=GMT+8 //设定GMT区域，避免CentOS坑爹的时区设置

*
*
*
*
*
*
*
*
* */