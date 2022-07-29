package bg.coherent.consoleapp;


import bg.coherent.store.ProductComparator;
import bg.coherent.store.Store;
import bg.coherent.store.XmlParser;

public class StoreApp {
    public static void main(String[] args) {

        Store store = new Store();
        store.printStore();
        System.out.println(XmlParser.getConfig());
        System.out.println(ProductComparator.sortedProducs(store));
    }


}
