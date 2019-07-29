/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Borrower;
import beans.Lender;
import beans.LoanReport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class LoanServices {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/exam";
    private String email;
    Connection conn = null;
    Statement stmt = null;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<Lender> findLendersAll() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,"root","");
        ArrayList<Lender> arrayListLender = new ArrayList();
	Lender lender = null;
        this.setEmail(email);
	String query1 = "SELECT * FROM lenders";
	stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(query1);
        for (int i=0; i< rs.getRow(); i++) {
            rs.next();
            lender = new Lender();
            lender.setEmail(rs.getString(3));
            arrayListLender.add(lender);
        }
        return arrayListLender;
    }
    
    public Lender findLenderByEmail(String email) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,"root","");
	Lender lender = null;
        this.setEmail(email);
	String query1 = "SELECT * FROM lenders WHERE email='" + this.getEmail() + "'";
        
	stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(query1);
	if (rs.next()) {
            lender = new Lender();
            lender.setFirstName(rs.getString(1));
            lender.setLastName(rs.getString(2));
            lender.setEmail(rs.getString(3));
            lender.setPassword(rs.getString(4));
            lender.setMoney(rs.getInt(5));
        }
        return lender;
    }
    
    public Map<String, LoanReport> findLoanByLenderAndBorrowerEmail(Borrower borrower) throws ClassNotFoundException, SQLException {
        Map<String, LoanReport> mapLoanReport = new HashMap<>();
        this.setEmail(borrower.getEmail());
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,"root","");
	String query1 = "SELECT * FROM lending WHERE borrowerEmail='" + getEmail() + "'";
	stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(query1);
        int count = rs.getRow();
        LoanReport loanReport = null;
        LoanReport loanReplace = null;
        Lender lender = null;
        for (int i = 0; i < count; i++) {
            int amount = 0;
            lender = new Lender();
            rs.next();
            lender.setEmail(rs.getString(1));
            lender = findLenderByEmail(lender.getEmail());
            loanReport = new LoanReport();
            loanReport.setNameLender(lender.getFirstName() + " " + lender.getLastName());
            loanReport.setLenderEmail(lender.getEmail());
            loanReport.setAmount(rs.getInt(3));
            if(mapLoanReport.isEmpty()) {
              mapLoanReport.put(lender.getEmail(), loanReport);
            }else {
              if(mapLoanReport.containsValue(loanReport)) {
                loanReplace = mapLoanReport.get(loanReport.getLenderEmail());
                amount = loanReplace.getAmount();
                loanReport.setAmount(loanReport.getAmount()+amount);
                mapLoanReport.remove(lender.getEmail());
                mapLoanReport.put(lender.getEmail(), loanReport);  
              } 
            }
        }

        return mapLoanReport;
    }
}
