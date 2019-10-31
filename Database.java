import java.sql.Connection;  

public class Database {

    public static IDBAction makeTable() {
        return (conn) -> {
            String command = "CREATE TABLE IF NOT EXISTS pairs ("
                + "id text PRIMARY KEY,"
                + "payload text NOT NULL"
                + ")";
            boolean success = SQLite.executeStatement(conn, command);
            Log.log(success ? "The `pairs` table exits." : "Failed to set up the `pairs` table.");
            return success;
        };
    }

    public static IDBAction setPair(String id, String payload){
        return (conn) -> {
            String command = "REPLACE INTO pairs(id, payload) VALUES (\"%s\", \"%s\")";
            boolean success = SQLite.executeStatement(conn, String.format(command, id, payload));
            Log.log(success ? "The pair was set in the DB." : "Failed to set the pair in the DB.");
            return success;
        };
    }
}
