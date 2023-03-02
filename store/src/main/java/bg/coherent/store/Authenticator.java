package bg.coherent.store;

import com.sun.net.httpserver.BasicAuthenticator;
public class Authenticator extends BasicAuthenticator {
    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public Authenticator(String realm) {
        super(realm);
    }

    @Override
    public boolean checkCredentials(String user, String password) {
        return user.equals(USER) && password.equals(PASSWORD);
    }
}
