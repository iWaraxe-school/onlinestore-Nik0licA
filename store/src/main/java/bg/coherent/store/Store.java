package bg.coherent.store;

import bg.coherent.domain.Category;
import java.util.ArrayList;
import java.util.List;




public class Store {
       private List<Category> categoryList = new ArrayList<>();


    public List<Category> getCategoryList() {
        return categoryList;
    }
}