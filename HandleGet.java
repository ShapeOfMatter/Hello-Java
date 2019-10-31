import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandleGet implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        List<String> parsedPath = HandleHelper.parseRequest(this.getPath(), t);

        if(2 == parsedPath.length()) {
        }
        else {
            HandleHelper.error(String.format(
                        "Request to /get had %d arguments, exactly 2 required.",
                        parsedPath.length()));
        } 
    }
}
