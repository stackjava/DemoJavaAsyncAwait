package stackjava.com.eaasync.demo;

import java.util.concurrent.*;

public class DemoCompleteFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> add(1, 2), executor);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> add(1, 3), executor);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> add(2, 3), executor);

        System.out.println("Done");
        executor.shutdown();
    }


    public static int add(int a, int b) {
        int sum = a + b;
        System.out.println("result: " + a + " + " + b + " = " + sum);
        return sum;
    }
}
