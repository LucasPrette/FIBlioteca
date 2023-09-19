import eNum.Status;
import implementations.Library;
import repositories.BookRepository;
import repositories.LoanRepository;
import repositories.StudentRepository;
import services.DataManipulation;
import services.DbConnection;

import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    Scanner scanner = new Scanner(System.in);

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

    private void menu () {
        System.out.println("0 - EXIT");
        System.out.println("1 - LIST MENU");
        System.out.println("2 - LIBRARY MENU");
        System.out.println("3 - DB MENU");
        System.out.print("-> ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                listingMenu();
            }
            case 2 -> {
                libraryMenu();
            }
            case 3 -> {
                dbMenu();
            }
            case 0 -> {
                System.exit(1);
            }
        }
    }

    private void listingMenu() {
        System.out.println("1 - LIST STUDENTS");
        System.out.println("2 - LIST BOOKS");
        System.out.println("3 - LIST LOANS");
        System.out.println("4 - LIST LOANS NOT RETURNED");
        System.out.print("-> ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                studentRepository.listStudent();
            }
            case 2 -> {
                bookRepository.listBook();
            }
            case 3 -> {
                loanRepository.listLoan();
            }
            case 4 -> {
                loanRepository.listLoanNotReturned();
            }
            default -> {
                menu();
            }
        }
    }

    private void libraryMenu() {
        System.out.println("1 - LOAN BOOK");
        System.out.println("2 - RETURN BOOK");
        System.out.println("3 - UPDATE ACTIVE BOOKS");
        System.out.println("4 - UPDATE DELAYED BOOKS");
        System.out.print("-> ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                lib.takeBook();
            }
            case 2 -> {
                lib.returnLoan();
            }
            case 3 -> {
                lib.updateActiveLoan();
            }
            case 4 -> {
                lib.updateDelayedLoan();
            }
            default -> {
                menu();
            }
        }
    }

    private void dbMenu() {
        System.out.println("1 - ADD BOOK");
        System.out.println("2 - ADD STUDENT");
        System.out.println("3 - ADD LOAN");
        System.out.println("4 - GET ALL BOOKS FROM DB");
        System.out.print("-> ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                bookRepository.insertBook(111, "As Cronicas de Gelo e Fogo", "George R R Martin");
                //add book
            }
            case 2 -> {
                studentRepository.insertStudent(111, "Lucas Javeiro");
                //add student
            }
            case 3 -> {
                loanRepository.insertLoan
                        (
                                111,
                                111,
                                LocalDate.parse("2023-09-17"),
                                LocalDate.parse("2023-09-24"),
                                Status.RETURNED
                        );
                //add loan
            }
            case 4 -> {
                System.out.println(bookRepository.getAllBooks());
                //get all books db
            }
            case 5 -> {
                System.out.println("TODO");
                // get all student db
            }
            case 6 -> {
                System.out.println("TODO");
                // get all loan db
            }
            case 7 -> {
                bookRepository.clearTable();
                // clear tables
            }
            default -> {
                menu();
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        if (new DbConnection().getConnection() != null) {
            do{
                main.menu();
            }while(true);

        }

    }
};