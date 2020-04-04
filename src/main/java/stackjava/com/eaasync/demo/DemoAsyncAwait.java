package stackjava.com.eaasync.demo;

import java.util.concurrent.*;

import com.ea.async.Async;

public class DemoAsyncAwait {
    public static void main(String[] args) {
        Async.init();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> add(1,2), executor);
        Async.await(future1);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> add(1,3), executor);
        Async.await(future2);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> add(2,3), executor);
        Async.await(future3);
        
        System.out.println("Done");
        executor.shutdown();
    }


    public static int add(int a, int b) {
        int sum = a + b;
        System.out.println("result: " + a + " + " + b + " = " + sum);
        return sum;
    }
}
