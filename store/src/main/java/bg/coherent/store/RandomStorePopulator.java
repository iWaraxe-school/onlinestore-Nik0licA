package bg.coherent.store;
import bg.coherent.domain.*;
import com.github.javafaker.Faker;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RandomStorePopulator {
    Faker faker;
    List<Class<? extends Category>> allCategories;

    public RandomStorePopulator() {
        faker = new Faker();

        Reflections reflections = new Reflections("bg.coherent.domain");
        allCategories = new ArrayList<>();
        Set<Class<? extends Category>> categoriesSet = reflections.getSubTypesOf(Category.class);
        for (Class<? extends Category> categoryClass: categoriesSet) {
            allCategories.add(categoryClass);
        }
    }

 public List<Category> generateCategories(){
     List<Category> categories = new ArrayList<>();

     for (Class<? extends Category> categoryClass: allCategories) {
         Category cat = generateCategory(categoryClass);
         categories.add(cat);
     }

     return categories;
 }

    public Category generateCategory(Class<? extends Category> categoryClass) {
        Category category;
        try {
            category = categoryClass.getConstructor().newInstance();
            int n = faker.number().numberBetween(1,3);
            for(int i=0;i<n;i++){
                Product p = randomProduct(category.getName());
                category.addProduct(p);
            }
            return category;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private Product randomProduct(String categoryName){
        String name;
        switch (categoryName) {
            case "BikeCategory":
                name = faker.book().title();
                break;

            case "MilkCategory":
                name = faker.food().dish();
                break;

            default:
                name = faker.funnyName().name();
                break;
        }

        Double rate = faker.number().randomDouble(2,1,5);
        Double price = faker.number().randomDouble(2,1,10000);
        Product p = new Product(name,rate,price);
        return p;
    }
}
