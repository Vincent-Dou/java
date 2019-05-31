package testInBit;
/**
 * Auther:vincent-Dou
 * Date: 2019/5/31
 * Time: 18:45
 * Description：
 */

/**
 *死锁：
 * 产生的原因：（一下四种必须同时满足才会导致死锁）
 *   1. 互斥： 共享资源只能同时被一个线程占用
 *   2. 占有且等待； 拿到一个锁时，不释放的同时在去申请一个锁
 *   3. 不可抢占： 线程Thread1拿到对象锁x后 ，其他线程无法强行抢占x锁
 *   4. 循环等待： 线程t1拿到资源x的锁，去申请y的锁； 线程2拿到资源y的锁，在去申请x的锁。
 *
 *
 * ThreadLocal- 线程本地的变量(属于线程私有资源，不与其他线程共享)
 *  set()设置线程私有属性值
 *  get()取得线程私有属性的值
 *
 * 每个Thread对象内部都有一个Threadlocal.ThreadLocalMap对象(存放元素) 该对象属于每个对象自己，因此保存的内容也是线程私有，在
 * 多线程场景下并不共享
 *
 * 同步：
 * Object ： wait() notify(); 必须搭配synchronized使用；这两个方法必须在同步方法或同步代码块中使用
 *
 *      wait(): 痴汉方法：持有锁的线程调用wait()方法后会一直阻塞，直到有别的线程调用notify()将其唤醒；
 *
 *      public final native void wait(long timeout)若还未被唤醒，继续执行， 默认单位为 ms
 *
 *      notify(): 唤醒任意一个处于wait()的线程（只能一个）
 *
 *      任意一个Object以及其子类对象都有两个队列：
 *          同步队列：所有尝试获取该对象Monitor失败的线程， 加入同步线程，排队获取锁
 *          等待对队列： 已经拿到锁的线程在等待其他资源时， 主动释放锁，置入该对象等待队列中，等待被唤醒
 *        当调用notify()会在等待队列中任意唤醒一个线程，将其置入同步队列的尾部，排队获取锁，
 *         当调用notifyall()
 */
class factory {
    public static Object goods = new Object();
    public static void getGoods(){
        if(goods == null){
            System.out.println("没了");
        }
        else{
            System.out.println(Thread.currentThread().getName() + "消费");
        }
    }
}

public class test0531 implements Runnable{



    public static  Object object = new Object();
    @Override
    public void run() {

    }
    public synchronized void get(){

    }
}
