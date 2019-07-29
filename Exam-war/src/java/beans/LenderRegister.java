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
public class LenderRegister {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/exam";
    private final String tabla = "lenders";
    Connection conn = null;
    Statement stmt = null;
    
    public int addLender(Lender lender) throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,"root","");
        PreparedStatement ps;
        if(lender!=null) {
            System.out.println("dentro del if addLender");    
            ps = conn.prepareStatement("INSERT INTO " + this.tabla + "(firstName, lastName, email, password, money) VALUES(?, ?, ?, ?, ?);");
            System.out.println("dentro del if addLender, despues del insert into");
            ps.setString(1, lender.getFirstName());
            ps.setString(2, lender.getLastName());
            ps.setString(3, lender.getEmail());
            ps.setString(4, lender.getPassword());
            ps.setInt(5, lender.getMoney());    
            return ps.executeUpdate();
        }
     
        return 0;
    }
    
}
