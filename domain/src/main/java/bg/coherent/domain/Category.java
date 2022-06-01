package bg.coherent.domain;
import java.util.ArrayList;
import java.util.List;

public class Category {
        private String name;
        private List<Product> productList=new ArrayList<>();

        public List<Product> getProductList() {
            return productList;
         }
        public Category(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

}
