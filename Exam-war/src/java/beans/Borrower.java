/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Borrower implements Serializable {
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String needMoneyFor;
    private String description;
    private int amountNeeded;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNeedMoneyFor() {
        return needMoneyFor;
    }

    public void setNeedMoneyFor(String needMoneyFor) {
        this.needMoneyFor = needMoneyFor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountNeeded() {
        return amountNeeded;
    }

    public void setAmountNeeded(int amountNeeded) {
        this.amountNeeded = amountNeeded;
    }

    public Borrower(String firstName, String lastName, String email, String password, String needMoneyFor, String description, int amountNeeded) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.needMoneyFor = needMoneyFor;
        this.description = description;
        this.amountNeeded = amountNeeded;
    }

    public Borrower() {
    }
    
}
