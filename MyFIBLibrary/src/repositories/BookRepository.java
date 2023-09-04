package repositories;

import implementations.Book;
import services.ReadTXT;

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

};
