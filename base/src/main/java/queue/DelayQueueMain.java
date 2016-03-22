package queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by mojunbin on 2016/3/21.
 */
public class DelayQueueMain {
    public static void main(String[] args) {
        DelayQueue<DelayedObj> delayQueue=new DelayQueue<DelayedObj>();
        delayQueue.add(new DelayedObj());
        DelayedObj obj1 = delayQueue.poll();
    }


    static class DelayedObj implements Delayed{
        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
