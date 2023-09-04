package implementations;

public class Book {
    private int isbn;
    private String author;
    private String title;

    public Book () {};

    public Book
            (
                    int isbn,
                    String title,
                    String author
            )
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public int getIsbn() {
        return this.isbn;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }


    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void showBook() {
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
    }

    public void showList() {
        for(int i = 0; i < 100; i++) {
            System.out.println("Hello World!!");
        };
    }


}