package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDbConnection {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=fib;encrypt=false;";
    String user = "aluno";
    String password = "123";

    try {
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected!!");
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
