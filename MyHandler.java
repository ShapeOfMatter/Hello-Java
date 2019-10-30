import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        URI request = t.getRequestURI();
        String query = request.getQuery();
        byte [] response = String.format("You requested \"%s\"", query).getBytes();
        t.sendResponseHeaders(200, response.length);
        OutputStream os = t.getResponseBody();
        os.write(response);
        os.close();
    }
}
