import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpContext;

//import com.MyHandler;

/*
 * a simple static http server
 */
public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        HttpContext context = server.createContext("/", new MyHandler());
        log(context.getPath());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static void log(String s) {
        System.out.println(s);
    }

}
