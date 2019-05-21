package testSomething;

/**
 * Auther: Vincent-Dou
 * Date: 19-5-21
 * Time: 下午6:52
 * Description:
 */

/**
 * 笔记：
 *  多线程的实现
 *      1. 继承Thread类，重写run方法
 *      2.实现Runnable接口，然后重写run方法
 *      3. 实现Callable接口，然后重写call<v>方法；（线程执行任务后有返回值）
 *      4. 线程池
 *   1.无论使用哪种方式创建线程，启动线程一律使用start方式，run方法不能被用户直接使用
 *   2.一个线程的start方法只能使用一次， 执行多次会抛出Illegal```Exception
 *   3.javac中Thread类本身也实现了Runnable接口，与用户自定义的线程类共同组成代理设计模式，其中Thread类实现辅助操作，包括线程额资源调度等任务；自定义线程类完成真实业务
 *   继承Thread类与实现Runnable接口区别？
 *      1. 继承Thread类有单继承的局限
 *      2. 实现Runnable接口可以更好的实现程序共享的概念（Thread也可以，稍微麻烦）
 *   Future接口：接受Callable接口的返回值
            get方法，接收返回值
 *java常用的线程操作方法**
 *  1.取得当前jvm中正在执行的线程对象 public static native Thread currentThread();
 *  2.线程命名：public Thread(Runnable target, String name);   public final
 *
 *  4.线程休眠 sleep(long time) 指的是让线程暂缓执行，等到了预计时间之后在回复恢复执行，sleep方法会让当前线程立即交出cpu。但不会释放对象锁
 *  5.线程让步 yield()暂停当前正在执行的线程对象，并执行其他线程（只能让拥有相同优先级的线程获取cpu），当前线程不会立即交出cpu，交出时间由系统调度
 *  6.线程等待 join() 若一个线程1需
 */
class myThread implements Runnable{
    String name;
    private int tick  = 20;
    public myThread(String name){
        this.name = name;
    }
    public void run(){
        while (tick > 0){
            tick--;
            System.out.println(name+"抢到,还剩"+tick);
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
       myThread myThread1= new myThread("A");
//       myThread myThread2= new myThread("B");
//       myThread myThread3= new myThread("C");
//       myThread1.start();
//       myThread2.start();
//       myThread3.start();
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread1);
        Thread thread3 = new Thread(myThread1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}













