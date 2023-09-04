package services;

import implementations.Book;
import implementations.Loan;
import implementations.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataManipulation {
    private ArrayList<Student> students;
    private ArrayList<Book> books;
    private ArrayList<Loan> loans;

    public DataManipulation() {};

    public DataManipulation
            (
                    ArrayList<Student> students,
                    ArrayList<Book> books,
                    ArrayList<Loan> loans
            )
    {
        this.students = students;
        this.books = books;
        this.loans = loans;
    };

    public void updateFile(ArrayList<Loan> loans) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Loans.txt"))) {
            for(Loan loan : loans) {
                writer.write(String.valueOf(loan.getStudent().getRa()));
                writer.newLine();
                writer.write(String.valueOf(loan.getBook().getIsbn()));
                writer.newLine();
                writer.write(loan.getBookWithdrawal().toString());
                writer.newLine();
                writer.write(loan.getBookReturnal().toString());
                writer.newLine();
                writer.write(loan.getStatus().toString());
                writer.newLine();
            }
        }
        catch (IOException e) {
            System.err.println("Error updating the file 'Loans.txt' ");
            e.printStackTrace();
        };
    };
};
