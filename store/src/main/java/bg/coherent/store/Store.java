package bg.coherent.store;

import bg.coherent.domain.Category;
import bg.coherent.domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Store {

    private static Store instance;


    public static Store getInstance() {
        if (instance == null) ;
        {
            instance = new Store();
        }
        return instance;
    }


    private List<Category> categoryList;
    private Store() {
        RandomStorePopulator storePopulator = new RandomStorePopulator();
        categoryList = storePopulator.generateCategories();

    }

    public List<Category> getCategoryList() {

        return categoryList;
    }
    public List<Product> getAllProducts(){
        List<Product> allProducts = new ArrayList<>();
        for (Category category: categoryList){
            allProducts.addAll(category.getProductList());
        }
        return allProducts;
    }

    public void printStore() {
        System.out.println(getCategoryList());
    }
}