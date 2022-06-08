package bg.coherent.store;
import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.*;
import bg.coherent.store.Store;
import bg.coherent.domain.Category;

import static org.reflections.scanners.Scanners.SubTypes;


public class StoreApp {
    public static void main(String[] args) {

        Store store = new Store();
        Reflections reflections = new Reflections();

        Set<Class<? extends Category>> categories = reflections.getSubTypesOf(Category.class);
        System.out.println(categories);
        Map<Category, Integer> productsToAdd = new HashMap<>();
        productsToAdd.put(new FoodCategory(), 5);
        productsToAdd.put(new PetCategory(), 6);
        store.fillStore(productsToAdd);
    }

}
