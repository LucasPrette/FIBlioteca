package implementations;

import eNum.Status;
import repositories.BookRepository;
import repositories.LoanRepository;
import repositories.StudentRepository;
import services.DataManipulation;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    StudentRepository studentRepository = new StudentRepository();
    BookRepository bookRepository = new BookRepository();
    LoanRepository loanRepository = new LoanRepository();
    DataManipulation manipulator = new DataManipulation();

    public Library () {};

    public boolean studentUpToDate(int ra) {
        return loanRepository.studentNotDelayed(ra) && studentRepository.isStudentRegistered(ra);
    };

    public void takeBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("IBSN: ");
        int isbn = scanner.nextInt();
        if(!loanRepository.isLoaned(isbn)) {
            System.out.print("RA: ");
            int ra = scanner.nextInt();
            if(studentUpToDate(ra)) {
                takeLoan(ra, isbn);
            } else {
                System.err.println("Student not registered or is delayed!! ");
            }
        } else {
            System.out.println("Book not available! ");
            System.err.println("Return date: " + loanRepository.searchActiveLoan(isbn).getBookReturnal());
        }
    }

    public void takeLoan(int ra, int isbn) {
        Student student = studentRepository.searchStudent(ra);
        Book book = bookRepository.searchBook(isbn);
        Loan loan = new Loan(student, book);
        loanRepository.addLoan(loan);
        manipulator.updateFile(loanRepository.getLoans());

        System.out.println("Loan successfull!! ");

    };

    public void returnLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ISBN: ");
        int isbn = scanner.nextInt();

        if(loanRepository.isLoaned(isbn)) {
            ArrayList<Loan> loans = loanRepository.getLoans();
            Loan loan = loanRepository.searchActiveLoan(isbn);
            if(loan.getStatus() != Status.ACTIVE) {
                System.out.println("FINE HIS ASS $1000000 FUCKING DOLLARS");
            }
            int index = loans.indexOf(loan);
            loan.setStatus(Status.RETURNED);
            manipulator.updateFile(loans);
        } else {
            System.out.println("RETURNED ALREADY!!");
        }

    };

    public void updateActiveLoan() {
        ArrayList<Loan> loans = loanRepository.getLoans();

        for(Loan loan : loans) {
            if (loan.getStatus() == Status.ACTIVE) {
                if(LocalDate.now().isAfter(loan.getBookReturnal())) {
                    loan.setStatus(Status.DELAYED);
                    manipulator.updateFile(loans);
                    System.out.println("Loan updated: ");
                    loan.showLoan();
                }
            }
        }

    };

    public void updateDelayedLoan() {
        ArrayList<Loan> loans = loanRepository.getLoans();

        for(Loan loan : loans) {
            if (loan.getStatus() != Status.ACTIVE) {
                loan.setStatus(Status.ACTIVE);
                manipulator.updateFile(loans);
            }
        }
    }

};