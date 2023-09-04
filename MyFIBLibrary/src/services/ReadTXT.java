package services;

import eNum.Status;
import implementations.Book;
import implementations.Loan;
import implementations.Student;
import repositories.BookRepository;
import repositories.LoanRepository;
import repositories.StudentRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ReadTXT {

    public ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("Students.txt"))) {
            String ra;
            while( ( ra = reader.readLine() ) != null) {
                String name = reader.readLine();
                students.add(new Student(Integer.parseInt(ra), name));
            }

        }
        catch(IOException e) {
            System.err.println("Error reading the file 'Students.txt' ");
            e.printStackTrace();
        }

        return students;
    };


    public ArrayList<Book> readBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("Books.txt"))) {
            String isbn;
            while((isbn = reader.readLine()) != null) {
                String title = reader.readLine();
                String author = reader.readLine();
                books.add(new Book(Integer.parseInt(isbn), title, author));
            }
        }
        catch (IOException e) {
          System.err.println("Error reading the file 'Books.txt' ");
          e.printStackTrace();
        }
        return books;
    };

    public ArrayList<Loan> readLoans() {
        ArrayList<Loan> loans = new ArrayList<>();

        StudentRepository studentRepository = new StudentRepository();
        BookRepository bookRepository = new BookRepository();

        try(BufferedReader reader = new BufferedReader(new FileReader("Loans.txt"))) {
            String ra;
            while((ra = reader.readLine()) != null) {
                Book book = bookRepository.searchBook(Integer.parseInt(reader.readLine()));
                LocalDate withdrawalDate = dateFormatter(reader.readLine());
                LocalDate returnDate = dateFormatter(reader.readLine());
                Status status = Status.valueOf(reader.readLine());

                loans.add(
                        new Loan
                                (
                                        studentRepository.searchStudent(Integer.parseInt(ra)),
                                        book,
                                        withdrawalDate,
                                        returnDate,
                                        status
                                )
                );

            }
        }
        catch(IOException e) {
            System.err.println("Error reading the file 'Loans.txt' ");
            e.printStackTrace();
        }

        return loans;
    };




    private LocalDate dateFormatter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(date, formatter);
    };
};