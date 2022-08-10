package bg.coherent.store;
import bg.coherent.domain.Category;
import bg.coherent.domain.Product;


import java.util.*;

public class ProductComparator {


    public static List<Product> sortedProducs(Store store) {
        return sortProducts(XmlParser.getConfig(), store.getAllProducts());
    }
    public static List<Product> topFive (Store store){
        HashMap<String, String> priceRule = new HashMap<>();
        priceRule.put("price", "DESC");
        List<Product> allProducts = sortProducts(priceRule,store.getAllProducts());
        if(allProducts.size()>5) {
            return allProducts.subList(0, 5);
        }
        else{
            return allProducts;
        }

    }
    public static List<Product> sortProducts(Map<String, String> rules, List<Product> allProducts){
        for (Map.Entry<String, String> rule :rules.entrySet()){
            switch(rule.getKey()){
                case "name":
                    if(rule.getValue().equals("ASC")){
                        allProducts.sort(Comparator.comparing(Product::getName));
                    } else{allProducts.sort(Comparator.comparing(Product::getName).reversed());}
                    break;
                case "price":
                    if(rule.getValue().equals("ASC")){
                        allProducts.sort(Comparator.comparing(Product::getPrice));
                    } else{allProducts.sort(Comparator.comparing(Product::getPrice).reversed());}
                    break;
                case "rate":
                    if(rule.getValue().equals("ASC")){
                        allProducts.sort(Comparator.comparing(Product::getRate));
                    } else{allProducts.sort(Comparator.comparing(Product::getRate).reversed());}
                    break;
            }
        }
            return allProducts;
        }


    }


