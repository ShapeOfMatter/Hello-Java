import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class SQLite {  
    /** 
     * Connect to a sample database 
     */  
    public static void connect() {  
        Connection conn = null;  
        try {  
            //Class.forName("org.sqlite.JDBC");
            // db parameters  
            String url = "jdbc:sqlite:app.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  

            System.out.println("Connection to SQLite has been established.");  

        //} catch (ClassNotFoundException e) {
        //    System.out.println(String.format("Unable to load class \"%s\".", e.getMessage()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    } 
}
