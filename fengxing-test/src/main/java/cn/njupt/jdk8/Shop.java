package cn.njupt.jdk8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by sunfei on 2018/1/30.
 */
public class Shop {

    private String name;

    private String desc;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = Math.max(10, 12) + Double.valueOf(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.currentTimeMillis();
        Future<Double> future = shop.getPriceAsync("123");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");

    }
}
