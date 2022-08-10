package bg.coherent.consoleapp;


import bg.coherent.store.ProductComparator;
import bg.coherent.store.Store;
import bg.coherent.store.XmlParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {

        Store store = new Store();
        store.printStore();
        System.out.println(XmlParser.getConfig());
        System.out.println(ProductComparator.sortedProducs(store));

        try {

            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Boolean flag = true;
            while (flag) {
                System.out.println("Enter one of following commands sort/top/quit:");
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
    }
}