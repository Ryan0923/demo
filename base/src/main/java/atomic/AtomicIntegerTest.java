package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mojunbin on 2016/3/23.
 */
public class AtomicIntegerTest {

    public final static AtomicInteger TEST_INTEGER = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        final Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int num = i;
            threads[i] = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int now = TEST_INTEGER.incrementAndGet();
                    System.out.println("我是线程：" + num + "，我得到值了，增加后的值为：" + now);
                }
            };
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("最终运行结果：" + TEST_INTEGER.get());
    }
}
