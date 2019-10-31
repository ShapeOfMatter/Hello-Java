import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpContext;

/*
 * a simple static http server
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //Set up the database
        SQLite.withConnection(Database.makeTable());
        
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        HttpContext contextGet = server.createContext("/get/", new HandleGet());
        HttpContext contextSet = server.createContext("/set/", new HandleSet());
        Log.log(String.format("paths: %s %s", contextGet.getPath(), contextSet.getPath()));
        
        server.setExecutor(null); // creates a default executor
        server.start();
    }

}
