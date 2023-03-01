package bg.coherent.store;

import bg.coherent.domain.Product;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ProductsHelper implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Gson gson = new Gson();
        List<Product> products = Store.getInstance().getAllProducts();
        byte[] response = gson.toJson(products).getBytes();
        exchange.sendResponseHeaders(200, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.flush();
        os.close();
        exchange.close();
    }

}
