import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class SQLite {  
    
    public static void connect() {  
        Connection conn = null;  
        try {  
            // db parameters  
            String url = "jdbc:sqlite:app.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  

            Log.log("Connection to SQLite has been established.");  
        } catch (SQLException e) {
            Log.log(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                Log.log(ex.getMessage());  
            }  
        }  
    } 
}
