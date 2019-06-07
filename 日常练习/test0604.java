package testInBit;

/**
 * Date: 2019/6/4
 * Time: 18:47
 * Author: vincent-Dou
 * Description：
 */

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：持有锁的线程可以再次对锁的计数器加一；
 *  synchronized: 阻塞式获取锁
 * 公平锁：
 *      等待时间最长的线程最先获取到锁synchronized无法实现公平锁
 * Lock—JDK1.5
 *      基于java语言层面实现的线程锁
 *      产生背景： synchronized会出现死锁
 *      破坏不可抢占：
 *          1. synchronized不响应中断interrupt()（要相应中断）  ： void lockInterruptibly();
 *          2. synchronized不支持超时操作 （可以超市操作）      :   boolean tryLock(long time, TimeUntil until;
 *          3. synchronized阻塞式获取锁（可以非阻塞式获取锁）    :  boolean tryLock();
 *      Lock体系使用格式：
 *          try{
 *              //加锁
 *              lock.lock()
 *          }finally{
 *              //解锁
 *              lock.lock()
 *          }
 * 独占锁：synchronized，在任意时刻，只有一个线程可以拥有此锁
 * 共享锁：在同一时刻，可以有多个线程用有锁
 *          读锁共享, 写锁独占；
 *
 * synchronized 与 Lock
 *      同：
 *          synchronized与Lock都是对象锁，都支持可重入锁
 *      异：
 *          Lock可以是实现synchronized不具备的特性 如 相应中断 支持超时 非阻塞式获取锁  可实现公平锁
 *          可实现共享锁(读写锁 RentrantReadWriteLock实现)
 *          Lock体系的condition队列可以有多个（区分与synchronized只有一个等待队列）
 *              获取一Lock锁的condition队列；lock.newCondition: 产生一个新的Condition队列（可以进一步提高效率，减少线程阻塞与唤醒带来的开销）
 *Conditio: Lock体系的通信方式，类比Object wait与notify
 *      await(): 释放lock锁，将线程置入等待队列阻塞
 *      signal()：随机唤醒一个处于等待状态的线程
 *      signalAll(): 唤醒所有等待线程
 *到底用synchronized还是Lock？
 *  1. 若无特殊的应用场景，推荐使用synchronized，其使用方便（隐式加减锁） 并且由于synchronized时jvm层面的实现，在之后的JDK还有对其优化的空间；
 *  2. 若要使用公平锁， 读写锁， 超时获取锁等特殊场景，才会考虑使用Lock；
 *
 *线程池：（创建线程的方式，推荐使用线程池来创建线程）(线程池中的线程被包装为Work工作线程，具备可重复执行任务的能力)
 *     1. 降低资源消耗
 *     2. 提高响应速度
 *     3. 提高线程的可管理性
 *     线程池的两大核心接口
 *          ExecutorService：普通线程池
 *              void execute(Runnable command):
 *              <T>Future<T> sumbmit(Callable<T> task || Runnable)
 *          ScheduledExecutorService:定时线程池
 *              scheduleAtFixedRate(Runnable command, long initialDelay,long period, TimeUnit unit);
 *      线程池的一个核心类：
 *
 *      线程池工作流程：
 *          当一个任务提交给线程池时，
 *                  一、 首先判断核心线程池的线程数量是否达到corePoolSize，若为达到，创建新的线程执行
 *  *                   任务并将其置入核心池中，否则，判断核心池是否有空闲线程，若有，分配任务执行，否则进入步骤二。
 *                  二、 判断当前线程池中的线程数量有没有达到线程池的最大数量（maxmumPoolSize），若没有，创建
 *                      新的线程执行任务并将其置入线程池中，否则，进入步骤三
 *                  三、 判断阻塞队列是否已满，若未满，将任务置入阻塞队列中等待调度，否则进入步骤四】
 *                  四、 调用相应的拒绝策略打回任务（有四种策略，默认抛出异常给用户AbortPolicy）
 *          1. 核心线程池
 *          2. 最大线程池
 *          3. 阻塞队列
 *      关闭线程池： shutdown();
 *      合理配置线程池： 配置核心池以及最大下称吃线程数量
 *              cpu密集型任务： Ncpu + 1
 *              IO密集型任务： 2*Ncpu
 *
 *
 *          常见的阻塞队列：
 *              ArrayBlockingQueue：基于数组的有界阻塞队列：
 *              LinkedBlockingQueue： 基于链表的无界阻塞队列 内置线程池FixedThreadPool，SingleThreadPool都采用此队列
 *              SynchronousQueue: 一个不存储元素的无界阻塞队列(一个元素的插入操作必须要等待同时有一个元素的删除操作，否则插入操作就一直阻塞
 *                                  内置线程池CachedThreadPool就采用此队列
 *              ProiorityBlockingQueue: 基于优先级的阻塞队列
 *    JDK内置的四大线程池：
 *          Exectors : 线程池的工具类
 *         1. 固定大小线程池(适用于负载较重的服务器(配置较低），来满足资源分配的需求)
 *                  Exectors.newFixedThreadPool(int nThreads)
 *         2. 单线程池（只有一个线程）(当多线程场景下 需要让任务串行执行时)
 *                  Exectors.newSingleThreadExecutor()
 *         3. 缓存线程池（适用于负载较轻的服务器，或者执行很多短期的异步任务）
 *                  Exectuors.newCacheThreadPool();
 *                  当任务提交速度大于线程执行速度，会不断创建新的线程（有可能无线创建线程将内存写满）
 *                  当任务的执行速度大于任务提交速度， 只会创建若干个有限线程
 *         4. 定时调度池
 *                  1. Exectors.newScheduledThreadPool(int nThreads)
 *                      延迟period
 *
 *                  2. 延迟delay个单元后每隔period时间单元就执行一次command任务
 * FutureTask：可以保证多线程场景下，任务只会被一个线程执行一次，其他线程不在执行此任务
 *      Future接口中的get方法会阻塞当前线程直到取得callable的返回值
 *
 *
 * 拓展问题：
 *      jdk1.7 任务分工Fork/Join
 *      jdk1.8 StampLock
 *      JUC并发工具
 *          CountDownLatch 闭锁
 *          CyclicBarrier 循环栅栏
 *
 */

class Task implements Runnable{
    private int tick = 200;
    Lock ticklock = new ReentrantLock();
    @Override
    public void run() {
        for(int i = 0; i < tick; i++){
            try {
                ticklock.lock();
                if(tick > 0){
                    System.out.println(Thread.currentThread().getName()+": 还剩："+ --tick);
                }
            }finally {
                ticklock.unlock();
            }
        }
    }
}

public class test0604 {
//    public static void chagne(String s){
//        s = "23";
//    }
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        int[] arr = {0};
//        String s = "0";
//        chagne(s);
//        System.out.println(s);
//        Task task = new Task();
//        Thread thread1 = new Thread(task);
//        Thread thread2 = new Thread(task);
//        Thread thread3 = new Thread(task);
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }
}
