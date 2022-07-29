package bg.coherent.store;
import bg.coherent.domain.Category;
import bg.coherent.domain.Product;


import java.util.*;

public class ProductComparator {


    public static List<Product> sortedProducs(Store store){

        List<Product> allProducts = store.getAllProducts();
        List<String> allKeys = new ArrayList<>();
        List<String> allValues = new ArrayList<>();
        for (Map.Entry<String, String> entry: XmlParser.getConfig().entrySet()){
            allKeys.add(entry.getKey());
            allValues.add(entry.getValue());
        }
        for (int i = allKeys.size() -1; i>= 0; i--){
            switch(allKeys.get(i)){
                    case "name":
                        if(allValues.get(i).equals("ASC")){
                            allProducts.sort(Comparator.comparing(Product::getName));
                        } else{allProducts.sort(Comparator.comparing(Product::getName).reversed());}
                        break;
                    case "price":
                        if(allValues.get(i).equals("ASC")){
                            allProducts.sort(Comparator.comparing(Product::getPrice));
                        } else{allProducts.sort(Comparator.comparing(Product::getPrice).reversed());}
                        break;
                    case "rate":
                        if(allValues.get(i).equals("ASC")){
                            allProducts.sort(Comparator.comparing(Product::getRate));
                        } else{allProducts.sort(Comparator.comparing(Product::getRate).reversed());}
                        break;

            }
        }
            return allProducts;
    }

    }

