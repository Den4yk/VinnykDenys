package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/hostelregister?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "12345";

    static Connection connection;

    public DBManager() {
        try{
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
