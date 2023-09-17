import implementations.Library;
import repositories.BookRepository;
import repositories.LoanRepository;
import repositories.StudentRepository;
import services.DataManipulation;
import services.DbConnection;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Library lib = new Library();
        StudentRepository studentRepository = new StudentRepository();
        BookRepository bookRepository = new BookRepository();
        LoanRepository loanRepository = new LoanRepository();

        DataManipulation manipulator = new DataManipulation
                (
                        studentRepository.getStudents(),
                        bookRepository.getBooks(),
                        loanRepository.getLoans()
                );

        if (new DbConnection().getConnection() != null) {

            Scanner scanner = new Scanner(System.in);
            int option;

            do{
                System.out.println("0 - EXIT");
                System.out.println("1 - LIST STUDENTS");
                System.out.println("2 - LIST BOOKS");
                System.out.println("3 - LIST LOANS");
                System.out.println("4 - LIST LOANS NOT RETURNED");
                System.out.println("5 - LOAN BOOK");
                System.out.println("6 - RETURN BOOK");
                System.out.println("7 - UPDATE ACTIVE BOOKS");
                System.out.println("8 - UPDATE DELAYED BOOKS");
                System.out.println("9 - ADD BOOK");
                System.out.print("--> ");
                option = scanner.nextInt();

                switch (option) {
                    case 1 : studentRepository.listStudent(); break;
                    case 2 : bookRepository.listBook(); break;
                    case 3 : loanRepository.listLoan(); break;
                    case 4 : loanRepository.listLoanNotReturned(); break;
                    case 5 : lib.takeBook(); break;
                    case 6 : lib.returnLoan(); break;
                    case 7 : lib.updateActiveLoan(); break;
                    case 8 : lib.updateDelayedLoan(); break;
                    case 9 : bookRepository.insertBook(111, "As Cronicas de Gelo e Fogo", "George R R Martin"); break;
                    case 10: bookRepository.clearTable(); break;
                }
            } while(option != 0);
        }

    };
};