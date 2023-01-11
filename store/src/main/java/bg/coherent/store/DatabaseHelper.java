package bg.coherent.store;
import bg.coherent.domain.Category;
import bg.coherent.domain.Product;

import java.sql. *;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

  public static  String url ="jdbc:postgresql://localhost:5432/postgres";
  public static  String username ="postgres";
  public static  String password ="postgres";

  public static Connection getConnection() {
        try {

            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
  public static void  fillDataBase (List<Product> allProducts,String categoryName){
      for (int i=0; i< allProducts.size(); i++){
          saveProduct(allProducts.get(i),categoryName );
      }
  }
  public static void saveProduct(Product product, String categoryName){
      Statement statement = null;
      String querye = "INSERT INTO products (name, rate, price, category_id) VALUES ('%s', '%f', '%f', (Select category_id FROM categories Where category_name = '%s'))";
      try {
          statement = getConnection().createStatement();
          String query = String.format(querye , product.getName().replace("'","''"), product.getRate(), product.getPrice(), categoryName);
          statement.execute(query);
          System.out.println("Product " + product.getName() + " was added to the database");
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }

  public static void fillCategories (List<Category> categories){
      Statement statement = null;
      String querye ="INSERT INTO categories (category_id,category_name) VALUES ('%d', '%s') ON CONFLICT DO NOTHING";
      Integer id =1;
      for (Category category: categories) {
          try {
              statement = getConnection().createStatement();
              String query = String.format(querye,id,category.getName());
              statement.execute(query);
              id++;
              System.out.println("Category " + category.getName() + " was added to the database");
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }

  }
    public static List<Product> getProducts(Category category) {
        Statement statement = null;
        List<Product> productList = new ArrayList<>();
        try {
            statement = getConnection().createStatement();
            String query = String.format("SELECT * FROM products WHERE category_id = (Select category_id FROM categories Where category_name = '%s')", category.getName());
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Category name: "+ category.getName());
            while (resultSet.next()) {
                Product product = new Product(resultSet.getString("name"), resultSet.getDouble("price"), resultSet.getDouble("rate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }


    public static void dropTable(String tableName){
      Statement statement = null;
      String query = String.format("DROP TABLE IF EXISTS %s",tableName);

        try {
          statement = getConnection().createStatement();
          statement.executeUpdate(query);
          System.out.println("Table with name : " +tableName + " successfully deleted");
      }
      catch (SQLException e) {
          throw new RuntimeException(e);
  }
}
    public static void  createCategoriesTable(){
        Statement statement = null;
        String query = "CREATE TABLE categories (category_id int primary key , category_name text)";
        try {
            statement = getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Table with categories is created");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void  createProductsTable(){
        Statement statement = null;
        String query = "CREATE TABLE products (name text, rate float, price float,category_id int)";
        try {
            statement = getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Table with products is created");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printStore(Store store){
        List<Category> categories = store.getCategoryList();
        System.out.println("-------------Printing store from database-------------");
        for (Category category :categories){
            System.out.println(DatabaseHelper.getProducts(category));
        }
        System.out.println("-------------------------------------");

    }

    public static void initializeDb(Store store){
        DatabaseHelper.dropTable("categories");
        DatabaseHelper.dropTable("products");
        DatabaseHelper.createCategoriesTable();
        DatabaseHelper.createProductsTable();
        List<Category> categories = store.getCategoryList();
        DatabaseHelper.fillCategories(categories);
        for (Category category: categories){
            List<Product> product_list = category.getProductList();
            DatabaseHelper.fillDataBase(product_list,category.getName());

        }

    }
}
