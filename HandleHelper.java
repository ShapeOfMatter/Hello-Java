import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandleHelper {

    public static List<String> parseRequest(String base, HttpExchange t) {
        String path = t.getRequestURI().getRawPath();
        Log.log(String.format("Recieved request \"%s\".", path));
        return Arrays.stream(
                (path.startsWith(base) ? path.substring(base.length()) : path).split("/"))
            .map(URLDecode::decodeValue)
            .filter((fragment) -> { return !fragment.isEmpty(); })
            .collect(Collectors.toList());
    }

    public static boolean success(HttpExchange t) throws IOException {
        t.sendResponseHeaders(204, 0);
        OutputStream os = t.getResponseBody();
        os.close();
        return true;
    }

    public static boolean success(HttpExchange t, String message) throws IOException {
        byte [] response = message.getBytes();
        t.sendResponseHeaders(200, response.length);
        OutputStream os = t.getResponseBody();
        os.write(response);
        os.close();
        return true;
    }

    public static boolean error(HttpExchange t, String message) throws IOException {
        return error(t, message, 400);
    }

    public static boolean error(HttpExchange t, String message, int code) throws IOException {
        byte [] response = String.format("Error: ", message).getBytes();
        t.sendResponseHeaders(code, response.length);
        OutputStream os = t.getResponseBody();
        os.write(response);
        os.close();
        return true;
    }

}
