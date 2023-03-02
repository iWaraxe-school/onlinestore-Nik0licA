package bg.coherent.domain;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private transient List<Product> productList =new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public String toString() {
        return String.format("Category name:%s" +"\n"+ "Products:%s ", name, productList);
    }
}
