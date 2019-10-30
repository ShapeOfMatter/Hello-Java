import java.sql.Connection;  

public class Database {
    
    public static IDBAction makeTable = (conn) -> {
        String command = "CREATE TABLE IF NOT EXISTS pairs ("
            + "id text PRIMARY KEY,"
            + "payload text NOT NULL"
            + ")";
        boolean success = SQLite.executeStatement(conn, command);
        Log.log(success ? "The `pairs` table exits." : "Failed to set up the `pairs` table.");
        return success;
    };
}
