package bg.coherent.store;

import bg.coherent.domain.Product;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadOrder extends Thread {
    private final Store store = Store.getInstance();
    @Override
    public void run(){
        System.out.println("Thread name : " + Thread.currentThread().getName());
        Product purchasedProducts = PurchasedProducts.getRandomProduct(store);
        System.out.println("Ordered product : "+ purchasedProducts);
        PurchasedProducts.getInstance().addProduct(purchasedProducts);
        PurchasedProducts.getInstance().printOrderList();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(30));
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "finished execution.");
    }
}
