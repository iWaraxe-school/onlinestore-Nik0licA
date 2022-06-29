package bg.coherent.store;

import bg.coherent.domain.Category;
import bg.coherent.domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Store {
    private List<Category> categoryList;
    public Store() {
        RandomStorePopulator storePopulator = new RandomStorePopulator();
        categoryList = storePopulator.generateCategories();

    }

    public List<Category> getCategoryList() {

        return categoryList;
    }

    public void printStore() {
        System.out.println(getCategoryList());
    }
}