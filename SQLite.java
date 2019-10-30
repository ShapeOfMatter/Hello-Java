import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class SQLite {

    public static boolean executeStatement(Connection conn, String statement)
    throws SQLException
    {
        Statement s = conn.createStatement();
        s.executeUpdate(statement);
        s.close();
        return true;
    }
    
    public static boolean withConnection(IDBAction action) {  
        Connection conn = null;
        boolean retval = false;
        try {  
            // db parameters  
            String url = "jdbc:sqlite:app.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            Log.log("Connection to SQLite has been established.");  

            conn.setAutoCommit(false);
            retval = action.doWith(conn);
            
            if(retval) {
                conn.commit();
            } else {
                conn.rollback();
            }
            
        } catch (SQLException e) {
            Log.log(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();
                    Log.log("Connection to SQLite has been closed.");
                }  
            } catch (SQLException ex) {  
                Log.log(ex.getMessage());  
            }
            return retval;
        }
    } 
}
