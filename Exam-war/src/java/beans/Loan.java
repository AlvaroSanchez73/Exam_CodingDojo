/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Usuario
 */
public class Loan {
    
    private String lenderEmail;
    private String borrowerEmail;
    private int amount;

    public Loan(String lenderEmail, String borrowerEmail, int amount) {
        this.lenderEmail = lenderEmail;
        this.borrowerEmail = borrowerEmail;
        this.amount = amount;
    }

    public Loan() {
    }

    public String getLenderEmail() {
        return lenderEmail;
    }

    public void setLenderEmail(String lenderEmail) {
        this.lenderEmail = lenderEmail;
    }

    public String getBorrowerEmail() {
        return borrowerEmail;
    }

    public void setBorrowerEmail(String borrowerEmail) {
        this.borrowerEmail = borrowerEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
    
    
}
