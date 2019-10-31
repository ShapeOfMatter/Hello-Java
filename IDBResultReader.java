import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBResultReader {
    public boolean read(ResultSet results) throws SQLException;
}

