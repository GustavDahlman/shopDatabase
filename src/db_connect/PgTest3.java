package db_connect;
import java.sql.*;
import java.util.*;


public class PgTest3 {
    private static String adress = "jdbc:postgresql://localhost/postgres";
    private static String username = "postgres";
    private static String password = "123";
    //"jdbc:postgresql://localhost/postgres?user=postgres&password=123&ssl=false"
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=123&ssl=false");
        System.out.println("connected");
        conn.close();
    }
}
