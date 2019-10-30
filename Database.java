import java.sql.Connection;  

public class Database {
    
    public static IDBAction makeTable = (conn) -> {
        String command = "CREATE TABLE IF NOT EXISTS pairs ("
            + "id text PRIMARY KEY,"
            + "payload text NOT NULL"
            + ")";
        return SQLite.executeStatement(conn, command);
    };
}
