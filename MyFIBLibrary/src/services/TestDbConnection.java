package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDbConnection {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=fib;encrypt=false;";
    String user = "aluno";
    String password = "123";

    public boolean testConnection () {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!!");
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Connection error!!" + e.getMessage());
        }
        return false;

    }

}
