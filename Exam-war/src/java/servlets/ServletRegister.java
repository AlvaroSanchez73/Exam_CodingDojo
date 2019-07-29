/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Borrower;
import beans.BorrowerRegister;
import beans.Lender;
import beans.LenderRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ServletRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String button = null;
        String firstName;
        String lastName;
        String email;
	String password;
        String needMoneyFor;
        String description;
        int money;
        int result;
       
        if(request.getParameter("lenderRegister") != null) {
           button = request.getParameter("lenderRegister");
           firstName = request.getParameter("lenderFirstName");
           lastName = request.getParameter("lenderLastName");
           email = request.getParameter("lenderEmail");
	   password = request.getParameter("lenderPassword");
           money = Integer.parseInt(request.getParameter("lenderMoney"));
           Lender lender = new Lender(firstName, lastName, email, password, money);
           LenderRegister lenderRegister = new LenderRegister();
           result = lenderRegister.addLender(lender);
           if(result==1){
              out.println("<html>");
	      out.println("<body bgcolor=#FFFFCC>");
	      out.println("<h2><i><center>Registered lender with success</center></i></h2>");
	      out.println("<hr>");
	      out.println("<center><a href='register.jsp'><h2><i>Click here to return</i></h2></a></center>");
	      out.println("</body></html>");
           }
        }  else {
           button = request.getParameter("borrowerRegister");
           firstName = request.getParameter("borrowerFirstName");
           lastName = request.getParameter("borrowerLastName");
           email = request.getParameter("borrowerEmail");
	   password = request.getParameter("borrowerPassword");
           needMoneyFor = request.getParameter("borrowerNeedMoneyFor");
	   description = request.getParameter("borrowerDescription");
           money = Integer.parseInt(request.getParameter("borrowerAmountNeeded"));
           Borrower borrower = new Borrower(firstName, lastName, email, password, needMoneyFor, description, money);
           BorrowerRegister borrowerRegister = new BorrowerRegister();
           result = borrowerRegister.addBorrower(borrower);
           if(result==1){
              out.println("<html>");
	      out.println("<body bgcolor=#FFFFCC>");
	      out.println("<h2><i><center>Registered borrower with success</center></i></h2>");
	      out.println("<hr>");
	      out.println("<center><a href='register.jsp'><h2><i>Click here to return</i></h2></a></center>");
	      out.println("</body></html>");
           }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
