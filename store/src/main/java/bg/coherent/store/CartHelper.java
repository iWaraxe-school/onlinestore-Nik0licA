package bg.coherent.store;

import bg.coherent.domain.Product;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class CartHelper implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Product purchasedProducts = PurchasedProducts.getRandomProduct(Store.getInstance());
        PurchasedProducts.getInstance().addProduct(purchasedProducts);
        exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();
        os.flush();
        os.close();
        exchange.close();
    }

}
