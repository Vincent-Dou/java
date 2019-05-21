package testSomething;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Auther: Vincent-Dou
 * Date: 19-5-21
 * Time: 下午7:51
 * Description:
 */

class MyThread2 implements Callable<String>{
    private int tick = 20;
    public String call() throws Exception{
        while (tick > 0){
            tick--;
            System.out.println("还剩"+tick);
        }
        return "买完了";
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new MyThread2();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
