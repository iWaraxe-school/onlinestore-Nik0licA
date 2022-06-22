package bg.coherent.store;

import bg.coherent.domain.Category;
import bg.coherent.domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Store {
    private List<Category> categoryList = new ArrayList<>();
    Map<Category, Integer> categoryProductsMap;
    public void fillStore(Map<Category, Integer> categoryProductsMap) {
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        for (Map.Entry<Category, Integer> entry : categoryProductsMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                Product product = new Product(randomStorePopulator.setName("Food"), randomStorePopulator.setRate(), randomStorePopulator.setPrice());
                entry.getKey().addProduct(product);
            }
        }
        this.categoryProductsMap = categoryProductsMap;
    }

    public List<Category> getCategoryList() {
       return categoryList;
    }
}