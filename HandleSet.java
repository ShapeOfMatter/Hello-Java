import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandleSet implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        List<String> parsedPath = HandleHelper.parseRequest(this.getPath(), t);

        if(2 == parsedPath.length()) {
            String id = parsedPath.get(0);
            String payload = parsedPath.get(1);

            if (SQLite.withConnection(Database.setPair(id, payload))) {
                HandleHelper.success(t);
            } else {
                HandleHeler.error(
                        t,
                        String.format("Could not set value for id \"%d\".", id),
                        500);
            }
        }
        else {
            HandleHelper.error(t, String.format(
                        "Request to /set had %d arguments, exactly 2 required.",
                        parsedPath.length()));
        }
    }
}
