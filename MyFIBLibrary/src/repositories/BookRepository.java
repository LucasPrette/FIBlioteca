package repositories;

import implementations.Book;
import services.DbConnection;
import services.ReadTXT;

import java.sql.*;
import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books;

    public BookRepository() {
        ReadTXT reader = new ReadTXT();

        books = reader.readBooks();
    };

    public ArrayList<Book> getBooks() {
        return this.books;
    };

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    };

    public void listBook() {
        for(Book book : books) {
            book.showBook();
        }
    };

    public Book searchBook(int isbn) {
        for(Book book : books) {
            if (isbn == book.getIsbn()) {
                return book;
            }
        }
        return null;
    };



    public void insertBook(int isbn, String title, String author) {

        try {
            Connection connection = new DbConnection().getConnection();
            String sqlQuery = "INSERT INTO fib.fiblioteca.livro(isbn, title, author) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, isbn);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, author);
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("line inserted sucessfully.");
            } else {
                System.out.println("Line insertion failed.");
            }

        } catch (SQLException e) {
            System.err.println("error!!");
        }
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            Connection connection = new DbConnection().getConnection();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT isbn, title, author FROM fiblioteca.livro";
            ResultSet result = statement.executeQuery(sqlQuery);

            while(result.next()) {
                int isbn = result.getInt("isbn");
                String author = result.getString("author");
                String title = result.getString("title");
                books.add(new Book(isbn, title, author));
            }

            connection.close();
        } catch (SQLException e) {
            System.err.println("SQL ERROR!!" + e.getMessage());
        }

        return books;
    }

    public void clearTable() {
        try {
            Connection connection = new DbConnection().getConnection();
            String sqlQuery = "DELETE FROM fib.fiblioteca.livro ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.executeUpdate();
            System.out.println("Table cleared sucessfully.");
        } catch (SQLException e) {
            System.err.println("Table clearing failed! " + e.getMessage());
        }
    }

};
