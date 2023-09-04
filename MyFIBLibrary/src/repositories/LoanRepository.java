package repositories;

import eNum.Status;
import implementations.Loan;
import services.ReadTXT;

import java.util.ArrayList;

public class LoanRepository {
    static ArrayList<Loan> loans;

    public LoanRepository() {
        ReadTXT reader = new ReadTXT();

        loans = reader.readLoans();
    };


    public ArrayList<Loan> getLoans() {
        return this.loans;
    };

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    };

    public void listLoan() {
        for(Loan loan : loans) {
            loan.showLoan();
        }
    };

    public void listLoanNotReturned() {
        for (Loan loan: loans) {
            if (loan.getStatus() != Status.RETURNED) {
                loan.showLoan();
            }
        }
    };

    public void addLoan (Loan loan) {
        loans.add(loan);
    };

    public Loan searchLoan(int ra, int isbn) {
        for(Loan loan : loans) {
            if( ( loan.getStudent().getRa() == ra ) && ( loan.getBook().getIsbn() == isbn ) ) {
                return loan;
            }
        }
        return null;
    };

    public Loan searchDelayedLoan(int isbn) {
        for(Loan loan : loans) {
            if (loan.getBook().getIsbn() == isbn) {
                if (loan.getStatus() == Status.DELAYED) {
                    return loan;
                }
            }
        }
        return null;
    };

    public Loan searchReturnedLoan(int isbn) {
        for(Loan loan : loans) {
            if (loan.getBook().getIsbn() == isbn) {
                if (loan.getStatus() == Status.RETURNED) {
                    return loan;
                }
            }
        }
        return null;
    };

    public Loan searchActiveLoan(int isbn) {
        for(Loan loan : loans) {
            if(loan.getBook().getIsbn() == isbn) {
                if(loan.getStatus() == Status.ACTIVE) {
                    return loan;
                } else if( (loan.getStatus() != Status.ACTIVE) && (loan.getBook().getIsbn() == isbn) ) {
                    return loan;
                }
            }
        }
        return null;
    };

    public boolean studentNotDelayed(int ra) {
        for (Loan loan : loans) {
            if (loan.getStudent().getRa() == ra) {
                if(loan.getStatus() == Status.DELAYED) {
                    return false;
                }
            }
        }
        return true;
    };

    public boolean isLoaned(int isbn) {
        for (Loan loan : loans) {
            if (loan.getBook().getIsbn() == isbn){
                if(loan.getStatus() != Status.RETURNED) {
                    return true;
                }
            }
        }
        return false;
    };


};
