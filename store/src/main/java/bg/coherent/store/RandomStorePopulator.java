package bg.coherent.store;
import com.github.javafaker.Faker;
import bg.coherent.domain.Category;

public class RandomStorePopulator {
    Faker faker = new Faker();
    public String getProductName(CategoryNames category) {
        switch (category) {
            case BOOK: return faker.book().title();
            case SPICE: return faker.food().spice();
            case DISH: return faker.food().dish();
            case BEER: return faker.beer().name();
            case FRUIT: return faker.food().fruit();
            default: return null;
        }
    }
    public Double getRate() {
        return faker.number().randomDouble(2, 1, 10);
    }
    public Double getPrice() {
        return faker.number().randomDouble(2, 1, 100);
    }

}
