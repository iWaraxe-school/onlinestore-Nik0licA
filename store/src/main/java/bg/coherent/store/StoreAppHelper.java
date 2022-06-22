package bg.coherent.store;

import bg.coherent.domain.Category;
import bg.coherent.domain.Product;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class StoreAppHelper {
    Store store;
    public void StoreHelper(Store store){this.store =store;}

    public void fillUpStore() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        RandomStorePopulator storePopulator = new RandomStorePopulator();
        Map<Category, Integer> productCategoryToAdd = createProductList();

        for (Map.Entry<Category, Integer> entry: productCategoryToAdd.entrySet()){
            for(int i =0; i< entry.getValue(); i++ ){

                Product product = new Product(
                        storePopulator.getProductName(entry.getKey().name),
                        storePopulator.getPrice(),
                        storePopulator.getRate());
                entry.getKey().addProducts(product);
            }
                this.store.getCategoryList().add(entry.getKey());
        }
    }

    private static Map<Category, Integer> createProductList() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<Category, Integer> productsToAdd = new HashMap<>();
        Reflections reflections = new Reflections();

        Set<Class<? extends Category>> categories = reflections.getSubTypesOf(Category.class);
        for ( Class<? extends Category> type: categories){
            Random random = new Random();
            productsToAdd.put(type.getConstructor().newInstance(), random.nextInt(10));

        }

    }
}
