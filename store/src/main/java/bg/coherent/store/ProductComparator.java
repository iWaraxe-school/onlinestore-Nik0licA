package bg.coherent.store;
import bg.coherent.domain.Category;
import bg.coherent.domain.Product;


import java.util.*;

public class ProductComparator {

    public static List<Product> sortedProducs(Store store) {
        return sortProducts(XmlParser.getConfig().descendingMap(), store.getAllProducts());

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
        List<String> keys = new ArrayList<>(rules.keySet());
        Collections.reverse(keys);
        for (String key : keys){
            String rule = rules.get(key);
            System.out.print("--------------------------------");
            System.out.println(rules.entrySet());
            System.out.println(rule);
            System.out.print("--------------------------------");

            switch(key){
                case "name":
                    if(rule.equals("ASC")){
                        allProducts.sort(Comparator.comparing(Product::getName));
                    } else{allProducts.sort(Comparator.comparing(Product::getName).reversed());}
                    break;
                case "price":
                    if(rule.equals("ASC")){
                        allProducts.sort(Comparator.comparing(Product::getPrice));
                    } else{allProducts.sort(Comparator.comparing(Product::getPrice).reversed());}
                    break;
                case "rate":
                    if(rule.equals("ASC")){
                        allProducts.sort(Comparator.comparing(Product::getRate));
                    } else{allProducts.sort(Comparator.comparing(Product::getRate).reversed());}
                    break;
            }
        }
            return allProducts;
        }


    }


