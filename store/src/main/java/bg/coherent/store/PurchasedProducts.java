package bg.coherent.store;

import bg.coherent.domain.Product;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class PurchasedProducts {
    private final CopyOnWriteArrayList<Product> orderList = new CopyOnWriteArrayList<>();
    private static PurchasedProducts instance;
    private static Random randomItem = new Random();
    public static PurchasedProducts getInstance(){
        if (instance == null)
        {
            instance = new PurchasedProducts();
        }
        return instance;
    }
    public static Product getRandomProduct (Store store){

        List<Product> RandomProducts = ProductComparator.sortedProducs(store);
        return  RandomProducts.get(randomItem.nextInt(RandomProducts.size()));

    }
    public synchronized void addProduct(Product product){
        orderList.add(product);

    }
    public synchronized void clearOrders(){
        orderList.clear();
        System.out.println("List is cleared");
    }

    public void printOrderList (){
        System.out.println("Current order list : " + orderList);
    }
}
