package testInBit;

/**
 * Auther:vincent-Dou
 * Date: 2019/5/24
 * Time: 18:44
 * Description：多线程练习02
 */

/**
 * 线程停止的方法
 *      1. 设置标志位（无法处理线程阻塞时停止的问题）
 *      2. 调用Thread类提供的stop方法强行关闭线程
 *              本方法现在已经不推荐使用，因为会产生不完整的数据
 *      3. 通过调用Thread类提供的interrupt();
 *              ①：若线程中没有使用类似sleep、wait、join时 调用此线程对象的interrupt方法并不会真正中断线程
 *                  只是简单的将线程的状态置为interrupt而已，我们可以根据此状态来进一步确定如何处理线程
                    Thread类提供的boolean isInterrupt()可以检测当前线程状态是否中断状态
                    若线程中调用了阻塞线程的方法（slee， wait， join）此时再调用interrupt方法时会抛出异常；
                    同时将线程状态还原（isInterrupt = false）
 *              ②：:
 * 线程的优先级；（线程的优先级指的是优先级越高的线程有可能先执行）
 *      1. 设置优先级setPriority(int priority)
 *          取得优先级int getPriority()
 *      2. jdk内置了三种优先级
 *          MAX_PRIORITY = 10;
 *          NORM_PRIORITY = 5;
 *          MIN_PRIORITY = 1;
 *      3. 线程的继承性
 *          若在线程中继承了子线程， 默认子线程与父线程的优先级相同
 * 守护线程DaemonThread
 *      java 中线程分为两类：用户线程， 守护线程
 *      守护线程为陪伴线程， 只要jvm中存在有任何一个用户进程没有终止，守护线程就一直在工作
 *      默认创建的线程都是用户线程，包括主线程
 *      1. 通过setDaemon(true)将线程设置为守护线程
 *      典型的守护线程： 垃圾回收线程
 * 线程互斥：
 *  分工
 *  同步： 线程间通信
 *  互斥： 多线程并发时，某一时刻只能有一个线程访问共享资源
 *
 * 锁： 一把锁保护一个相应资源， 不同锁保护不同的对象/资源
 * java中锁的实现：使用synchronized关键字为程序逻辑上锁
 *          synchronized两种用法
 *              ①：同步代码块
 *                  synchronized(锁的对象(必须是类对象)){
 *                      //此处代码块在任意时刻只能有一个线程进入
 *                  }
 *              ②：同步方法(默认锁的是当前对象this)
 *                  直接在方法声明上使用synchronized，此时表示同步方法在任意时刻，只能有一个线程进入
 *
 */
class tst implements Runnable{
    public static int tick = 50;
    public synchronized void selltick(){
        if(tick > 0)
        tick--;
        System.out.println(Thread.currentThread().getName()+":"+"还剩:"+tick);
    }

    @Override
    public void run() {
        for(int i = 0; i < 50; i++){
            selltick();
        }
    }
}

public class test0524 {
public static void main(String[] args){
    tst tstt = new tst();
    Thread thread11 = new Thread(tstt);
    Thread thread22 = new Thread(tstt);
    Thread thread33 = new Thread(tstt);
    thread11.start();
    thread22.start();
    thread33.start();
}
}
