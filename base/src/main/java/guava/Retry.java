package guava;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by mojunbin on 2016/6/14.
 */
public class Retry {


    static Callable<Boolean> callable = new Callable<Boolean>() {
        public Boolean call() throws Exception {
            System.out.println("==============================");
            return null; // do something useful here
        }
    };

    public static void main(String[] args) {


        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.<Boolean>isNull())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        try {
            retryer.call(callable);
        } catch (RetryException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
