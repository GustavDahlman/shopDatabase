package db_connect;
import java.sql.*;
import java.util.*;

public class PgTest2 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:postgresql://pgserver.mah.se/test001?user=test001&password=hemligt");
        PreparedStatement stmt = conn.prepareStatement("insert into tjoff(x, y) values(390, 611)");
        int nRows = stmt.executeUpdate();
        System.out.println(nRows+" rows");
        conn.close();
    }
}
