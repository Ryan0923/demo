package atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by mojunbin on 2016/3/23.
 */
public class AtomicBooleanTest {
    public final static AtomicBoolean TEST_BOOLEAN = new AtomicBoolean();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (TEST_BOOLEAN.compareAndSet(false, true)) {
                        System.out.println("我成功了！");
                    }
                }
            }.start();
        }
    }

}
