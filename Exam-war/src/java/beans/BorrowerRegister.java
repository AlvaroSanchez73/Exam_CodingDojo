/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class BorrowerRegister {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/exam";
    private final String tabla = "borrowers";
    Connection conn = null;
    Statement stmt = null;
    
    public int addBorrower(Borrower borrower) throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,"root","");
        PreparedStatement ps;
        if(borrower!=null) {
            System.out.println("dentro del if addBorrower");    
            ps = conn.prepareStatement("INSERT INTO " + this.tabla + "(firstName, lastName, email, password, needMoneyFor, description, amountMoney) VALUES(?, ?, ?, ?, ?, ?, ?);");
            System.out.println("dentro del if addBorrower, despues del insert into");
            ps.setString(1, borrower.getFirstName());
            ps.setString(2, borrower.getLastName());
            ps.setString(3, borrower.getEmail());
            ps.setString(4, borrower.getPassword());
            ps.setString(5, borrower.getNeedMoneyFor());
            ps.setString(6, borrower.getDescription());
            ps.setInt(7, borrower.getAmountNeeded());    
            return ps.executeUpdate();
        }
     
        return 0;
    }
    
}
