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
public class LoanReport {
    
    private String lenderEmail;
    private String nameLender;
    private int amount;

    public LoanReport() {
    }

    public LoanReport(String nameLender, String lenderEmail, int amount) {
        this.nameLender = nameLender;
        this.lenderEmail = lenderEmail;
        this.amount = amount;
    }

    public String getNameLender() {
        return nameLender;
    }

    public void setNameLender(String nameLender) {
        this.nameLender = nameLender;
    }

    public String getLenderEmail() {
        return lenderEmail;
    }

    public void setLenderEmail(String lenderEmail) {
        this.lenderEmail = lenderEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
