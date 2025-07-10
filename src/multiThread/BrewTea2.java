package multiThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/27 22:05
 */
public class BrewTea2 {

//    public static void main(String[] args) throws Exception {
//        // 任务 1：洗水壶 -> 烧开水
//        CompletableFuture<Void> f1 =
//                CompletableFuture.runAsync(()->{
//                    System.out.println("T1: 洗水壶...");
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    System.out.println("T1: 烧开水...");
//                    try {
//                        TimeUnit.SECONDS.sleep(15);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//
//        // 任务 2：洗茶壶 -> 洗茶杯 -> 拿茶叶
//        CompletableFuture<String> f2 =
//                CompletableFuture.supplyAsync(()->{
//                    System.out.println("T2: 洗茶壶...");
//                    sleep(1, TimeUnit.SECONDS);
//
//                    System.out.println("T2: 洗茶杯...");
//                    sleep(2, TimeUnit.SECONDS);
//
//                    System.out.println("T2: 拿茶叶...");
//                    sleep(1, TimeUnit.SECONDS);
//                    return " 龙井 ";
//                });
//
//        // 任务 3：任务 1 和任务 2 完成后执行：泡茶
//        CompletableFuture<String> f3 =
//                f1.thenCombine(f2, (__, tf)->{
//                    System.out.println("T1: 拿到茶叶:" + tf);
//                    System.out.println("T1: 泡茶...");
//                    return " 上茶:" + tf;
//                });
//
//    }
}
