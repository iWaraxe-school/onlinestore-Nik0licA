package bg.coherent.consoleapp;
import bg.coherent.store.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StoreApp {
    public static void main(String[] args) {

        Store store =  Store.getInstance();
        System.out.println(XmlParser.getConfig());
        ThreadClearOrder cleanThread = new ThreadClearOrder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Boolean flag = true;
            cleanThread.start();
            DatabaseHelper.initializeDb(store);

            while (flag) {
                System.out.println("Enter one of following commands sort/top/quit/order:");
                String command = reader.readLine();
                System.out.println("Your command is : " + command);

                switch (command) {
                    case "sort":
                        System.out.println("Sorted products list:");
                        System.out.println(ProductComparator.sortedProducs(store));
                        break;
                    case "top":
                        System.out.println("Top 5 store products are:");
                        System.out.println(ProductComparator.topFive(store));
                        break;
                    case "order":
                        System.out.println("You successfully ordered a product:");
                        System.out.println(ThreadOrder.currentThread());
                        ThreadOrder thread = new ThreadOrder();
                        thread.start();
                        break;
                    case "quit":
                        flag = false;
                        break;
                    default:
                        System.out.println("Command is not supported, try again");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: exception trown " + e.getMessage());
        }
        cleanThread.setExecuting(false);
    }

}