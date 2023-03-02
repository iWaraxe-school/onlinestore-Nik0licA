package bg.coherent.store;
import  static io.restassured.RestAssured.given;

public class Client {
    public void printCategory() {
        given()
                .auth()
                .basic("admin", "password")
                .when()
                .get("http://localhost:8080/categories")
                .then()
                .log().body();


    }
    public void printProducts() {
        given()
                .auth()
                .basic("admin", "password")
                .when()
                .get("http://localhost:8080/products")
                .then()
                .log().body();

    }
    public void ShowCart() {
        given()
                .auth()
                .basic("admin", "password")
                .when()
                .get("http://localhost:8080/show-cart")
                .then()
                .log().body();

    }
    public void AddCart() {
        given()
                .auth()
                .basic("admin", "password")
                .when()
                .get("http://localhost:8080/add-cart")
                .then()
                .log().body();

    }
}