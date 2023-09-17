package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=fib;encrypt=false;";
    String user = "aluno";
    String password = "123";

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection error!! " + e.getMessage());
            return null;
        }
    }


}
