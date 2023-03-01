package bg.coherent.store;

import bg.coherent.domain.Category;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class CategoryHelper implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Gson gson = new Gson();
        List<Category> categories = Store.getInstance().getCategoryList();
        byte[] response = gson.toJson(categories).getBytes();
        exchange.sendResponseHeaders(200, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.flush();
        os.close();
        exchange.close();
    }

}
