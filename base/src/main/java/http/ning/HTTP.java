package http.ning;

import com.ning.http.client.*;
import com.ning.http.client.providers.netty.NettyAsyncHttpProviderConfig;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by mojunbin on 2016/6/14.
 */
public class HTTP {

    static AsyncHttpClient httpClient;

    static {
        com.ning.http.client.AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
        AsyncHttpClientConfig config = builder
                .build();
        httpClient = new AsyncHttpClient(config);

    }


    public static void doGet(Request request, int timeoutInSeconds, boolean useProxy)  {


        try {
            AsyncHttpClient.BoundRequestBuilder boundRequestBuilder = httpClient.prepareGet(request.url);
            if(useProxy){
//                boundRequestBuilder.setProxyServer()
            }
            ListenableFuture<com.ning.http.client.Response> future = boundRequestBuilder.execute();
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {


    }
}
