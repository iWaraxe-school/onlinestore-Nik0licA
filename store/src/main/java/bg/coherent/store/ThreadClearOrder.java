package bg.coherent.store;

import java.util.concurrent.TimeUnit;

public class ThreadClearOrder extends Thread {
    private final PurchasedProducts purchasedProducts = PurchasedProducts.getInstance();
    private boolean isExecuting = true;
    public void setExecuting (boolean isExecuting){
        this.isExecuting = isExecuting;
    }
    @Override
    public void run(){
        while (isExecuting){
            try{
                TimeUnit.MINUTES.sleep(1);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("Order list was cleared");
            purchasedProducts.clearOrders();
            purchasedProducts.printOrderList();
        }
    }
}
