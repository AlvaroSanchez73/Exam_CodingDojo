/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class ValidateUsers {
    
    private String email;
    private String password;
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/exam";
    
    Connection conn = null;
    Statement stmt = null;
    
    public ValidateUsers(String email, String password) {
           super();
           this.email = email;
           this.password = password;
	}
    
    public String getPassword() {
	return password;
    }
    
    public String getEmail() {
	return email;
    }
    
    public Object validateUser(String email, String password) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,"root","");
	Object found = null;
	String query1 = "SELECT * FROM lenders WHERE email='" + getEmail() + "' and password='" + getPassword()+ "'";
        
	stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(query1);
	if (rs.next()) {
            Lender lender = new Lender();
            lender.setFirstName(rs.getString(1));
            lender.setLastName(rs.getString(2));
            lender.setEmail(rs.getString(3));
            lender.setPassword(rs.getString(4));
            lender.setMoney(rs.getInt(5));
            found = lender;
            
        }else {
             String query2 = "SELECT * FROM borrowers WHERE email='" + getEmail() + "' and password='" + getPassword()+ "'";
             stmt = conn.createStatement();
	     rs = stmt.executeQuery(query2);
             if(rs.next()) {
                 Borrower borrower = new Borrower();
                 borrower.setFirstName(rs.getString(1));
                 borrower.setLastName(rs.getString(2));
                 borrower.setEmail(rs.getString(3));
                 borrower.setPassword(rs.getString(4));
                 borrower.setNeedMoneyFor(rs.getString(5));
                 borrower.setDescription(rs.getString(6));
                 borrower.setAmountNeeded(rs.getInt(7));
                 found = borrower;    
             }
        }       
	
        if (conn != null)
	    conn.close();
        
	return found;
	}
    
    public void setPassword(String password) {
	this.password = password;
    }
        
    public void setEmail(String email) {
 	this.email = email;
    }

}
