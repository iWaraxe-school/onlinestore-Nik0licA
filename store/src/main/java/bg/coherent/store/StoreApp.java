package bg.coherent.store;


public class StoreApp {
    public static void main(String[] args) {

        Store store = new Store();
        StoreAppHelper storeHelper = new StoreAppHelper(store);
        storeHelper.fillUpStore();


}
