package implementations;

import eNum.Status;

import java.time.LocalDate;
public class Loan {
    private Student student;
    private Book book;
    private LocalDate bookWithdrawal;
    private LocalDate bookReturnal;
    private Status status;

    public Loan() {};

    public Loan
            (
                    Student student,
                    Book book
            )
    {
        this.student = student;
        this.book = book;
        this.bookWithdrawal = LocalDate.now();
        this.bookReturnal = bookWithdrawal.plusWeeks(1);
        this.status = Status.ACTIVE;
    };

    public Loan
            (
                    Student student,
                    Book book,
                    LocalDate bookWithdrawal,
                    LocalDate bookReturnal,
                    Status status
            )
    {
        this.student = student;
        this.book = book;
        this.bookWithdrawal = bookWithdrawal;
        this.bookReturnal = bookReturnal;
        this.status = status;
    };

    public Student getStudent() {
        return this.student;
    };

    public Book getBook() {
        return this.book;
    };

    public LocalDate getBookWithdrawal() {
        return this.bookWithdrawal;
    };

    public LocalDate getBookReturnal() {
        return this.bookReturnal;
    };

    public Status getStatus() {
        return this.status;
    };

    public void setStudent(Student student) {
        this.student = student;
    };

    public void setBook(Book book) {
        this.book = book;
    };

    public void setBookWithdrawal(LocalDate bookWithdrawal) {
        this.bookWithdrawal = bookWithdrawal;
    };

    public void setBookReturnal(LocalDate bookReturnal) {
        this.bookReturnal = bookReturnal;
    };

    public void setStatus(Status status) {
        this.status = status;
    };


    public void showLoan() {
        System.out.println("____Loans____ ");
        System.out.printf("Student: %s (%d) %n", this.student.getName(),this.student.getRa());
        System.out.printf("Book: %s (%d) %n", this.book.getTitle(),this.book.getIsbn());
        System.out.println("Withdrawal date: " + this.bookWithdrawal);
        System.out.println("Returnal date: " + this.bookReturnal);
        System.out.println("Status: " + this.status);
    }

};
