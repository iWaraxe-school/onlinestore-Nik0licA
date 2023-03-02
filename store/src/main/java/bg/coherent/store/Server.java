package bg.coherent.store;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static final int PORT = 8080;
    public static final String HOST = "localhost";

    public static final String REALM = "store_realm";
    HttpServer server = null;
    private Server() {
    }

    private static class ServerHolder {
        private static final Server server = new Server();
    }

    public static Server getInstance() {
        return ServerHolder.server;
    }

    public void startServer() throws IOException {
        Store store =  Store.getInstance();
        server = HttpServer.create(new InetSocketAddress(HOST,PORT), 5);
        HttpContext contextCat = server.createContext("/categories", new CategoryHelper());
        HttpContext contextProd = server.createContext("/products", new ProductsHelper());
        HttpContext contextAddCart = server.createContext("/add-cart", new CartHelper());
        HttpContext contextShowCart = server.createContext("/show-cart", new ShowCartHelper());

        contextCat.setAuthenticator(new Authenticator(REALM));
        contextProd.setAuthenticator(new Authenticator(REALM));
        contextAddCart.setAuthenticator(new Authenticator(REALM));
        contextShowCart.setAuthenticator(new Authenticator(REALM));

        server.start();
        System.out.println(server.getAddress());
    }

    public void stopServer() {
        server.stop(0);
    }
}
