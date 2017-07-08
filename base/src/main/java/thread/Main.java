package thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created by mojunbin on 2017/7/6.
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            4,
            8,
            0,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(2),
            new ThreadFactoryBuilder().setNameFormat("test1-thread-%d").build(),
            new AbortPolicy());
        List<Future> futureList = addTasks(threadPoolExecutor, createTasks(10));
        display(futureList, 30);
        System.out.println(getThreadPoolInfo(threadPoolExecutor));
    }

    private static void display(List<Future> futureList, long timeout) {
        for (Future future : futureList) {
            Object o = null;
            try {
                o = future.get(timeout, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(future.isDone() + "->" + o);
            System.out.println();
        }
    }

    private static List<Future> addTasks(ThreadPoolExecutor threadPoolExecutor, List<Callable> tasks) {
        List<Future> futureList = Lists.newArrayList();
        for (Callable task : tasks) {
            Future future = threadPoolExecutor.submit(task);
            futureList.add(future);
        }
        return futureList;
    }

    private static List<Callable> createTasks(int size) {
        List<Callable> tasks = Lists.newArrayList();
        Callable callableObj = () -> {
            int timeout = RandomUtils.nextInt(1, 6);
            TimeUnit.SECONDS.sleep(timeout);
            return timeout;
        };
        for (int i = 0; i < size; i++) {
            tasks.add(callableObj);
        }
        return tasks;
    }

    public static String getThreadPoolInfo(ThreadPoolExecutor tp) {
        StringBuilder sb = new StringBuilder(512);
        appendLine(sb, new String[]{"CorePoolSize=", String.valueOf(tp.getCorePoolSize())});
        appendLine(sb, new String[]{"MaximumPoolSize=", String.valueOf(tp.getMaximumPoolSize())});
        appendLine(sb, new String[]{"PoolSize=", String.valueOf(tp.getPoolSize())});
        appendLine(sb, new String[]{"LargestPoolSize=", String.valueOf(tp.getLargestPoolSize())});
        appendLine(sb, new String[]{"QueueSize=", String.valueOf(tp.getQueue().size())});
        appendLine(sb, new String[]{"QueueRemainingCapacity=", String.valueOf(tp.getQueue().remainingCapacity())});
        appendLine(sb, new String[]{"TaskCount=", String.valueOf(tp.getTaskCount())});
        appendLine(sb, new String[]{"ActiveCount=", String.valueOf(tp.getActiveCount())});
        appendLine(sb, new String[]{"CompletedTaskCount=", String.valueOf(tp.getCompletedTaskCount())});
        appendLine(sb, new String[]{"KeepAliveTimeInSeconds=", String.valueOf(tp.getKeepAliveTime(TimeUnit.SECONDS))});
        return sb.toString();
    }

    private static void appendLine(StringBuilder sb, String... strings) {
        String[] arr = strings;
        int length = strings.length;

        for(int i = 0; i < length; ++i) {
            String str = arr[i];
            sb.append(str);
        }

        sb.append("\n");
    }
}
