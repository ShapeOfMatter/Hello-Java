import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpContext;

/*
 * a simple static http server
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //test the DB connection
        SQLite.connect();
        
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        HttpContext context = server.createContext("/", new MyHandler());
        Log.log(context.getPath());
        
        server.setExecutor(null); // creates a default executor
        server.start();
    }

}
