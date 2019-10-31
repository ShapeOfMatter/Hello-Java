import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandleGet implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        List<String> parsedPath = HandleHelper.parseRequest(t.getHttpContext().getPath(), t);
        Map<String, String> results = parsedPath.stream()
            .collect(Collectors.toMap(
                        Function.identity(),
                        (s) -> { return ""; }));

        if (SQLite.withConnection(Database.readPairs(results))) {
            HandleHelper.success(
                    t,
                    String.join("\n", results.values()));
        } else {
            HandleHelper.error(
                    t,
                    "Could not read the requested IDs.",
                    500);
        }
    }
}
