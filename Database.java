import java.sql.Connection;  
import java.util.Map;
import java.util.stream.Collectors;

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

    public static IDBAction setPair(String id, String payload) {
        return (conn) -> {
            String command = "REPLACE INTO pairs(id, payload) VALUES (\"%s\", \"%s\")";
            boolean success = SQLite.executeStatement(conn, String.format(command, id, payload));
            Log.log(success ? "The pair was set in the DB." : "Failed to set the pair in the DB.");
            return success;
        };
    }

    public static IDBAction readPairs(Map<String, String> results) {
        return (conn) -> {
            String command = "SELECT id, payload FROM pairs WHERE id in (%s)";
            boolean success = SQLite.executeStatement(
                    conn,
                    String.format(
                        command, 
                        String.join(", ",
                            results.keySet().stream()
                            .map((s) -> { return String.format("\"%s\"", s); })
                            .collect(Collectors.toList()))),
                    (resultSet) -> {
                        while (resultSet.next()) {
                            results.replace(resultSet.getString("id"), resultSet.getString("payload"));
                        }
                        return true;
                    });
            Log.log(success ? "Read pairs." : "Failed to read pairs.");
            return success;

        };
    }
}
