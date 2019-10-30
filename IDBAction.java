import java.sql.Connection; 
import java.sql.SQLException;

public interface IDBAction {
    public boolean doWith(Connection conn) throws SQLException;
}

