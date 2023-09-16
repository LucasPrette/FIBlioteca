package repositories;

import implementations.Book;
import services.DbConnection;
import services.ReadTXT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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



    public void addBook(int isbn, String title, String author) {

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

};
