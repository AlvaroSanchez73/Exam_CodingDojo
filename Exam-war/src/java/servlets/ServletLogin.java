/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Borrower;
import beans.Lender;
import beans.LoanReport;
import beans.ValidateUsers;
import java.io.IOException;
import java.io.PrintWriter; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.LoanServices;

/**
 *
 * @author Usuario
 */
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("./borrower.jsp");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
	String password = request.getParameter("password");
        ValidateUsers validate = new ValidateUsers(email, password);
	Object found = validate.validateUser(validate.getEmail(), validate.getPassword());
	if (found==null) {
            out.println("<html>");
	    out.println("<body bgcolor=#FFFFCC>");
	    out.println("<h3><i><center>I am sorry, this email: " + validate.getEmail() + "</center></i></h3>");
	    out.println("<hr/>");
	    out.println("<h2><i><center>You are not a registered user</center></i></h2>");
	    out.println("<hr>");
	    out.println("<center><a href='index.jsp'><h2><i>To enter again</i></h2></a></center>");
	    out.println("</body></html>");

        }else if(found instanceof Lender) {
            Lender lender = (Lender)found;
            System.out.println("nombre: " + lender.getFirstName());
            System.out.println("apellido: " + lender.getLastName());
            System.out.println("email: " + lender.getEmail());
            System.out.println("paasword: " + lender.getPassword());
            System.out.println("monto: " + lender.getMoney());
            System.out.println("Es un lender....");
        } else {
            Borrower borrower = (Borrower)found;
            Map<String, LoanReport> mapLoanReport = new HashMap<>();
            LoanServices loanServices = new LoanServices();
            mapLoanReport = loanServices.findLoanByLenderAndBorrowerEmail(borrower);
            out.println("<html>");
	    out.println("<body bgcolor=#FFFFCC>");
            out.println("<h2 align='right'><a href='logout.jsp'><h2><i>Logout</i></h2></a></h2>");
	    out.println("<h1 align='center'>Borrower</h1>");
            out.println("<h2>Name: " + borrower.getFirstName() + " " + borrower.getLastName() + "</h2>");
	    out.println("<h2>Amount Needed: " + borrower.getAmountNeeded() + "</h2>");
            out.println("<table border='2'>");
	    out.println("<tbody>");
            out.println("<caption>List of people who lent you money</caption>");
	    out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Amount Lent</th>");
	    out.println("</tr>");
           LoanReport loanReport = null;
           ArrayList<Lender> arrayListLender = new ArrayList();
           arrayListLender = loanServices.findLendersAll();
           Lender lender = null;
           mapLoanReport = (Map<String, LoanReport>) request.getAttribute("loanReport");
           for(int i=1;i<= arrayListLender.size();i++) {
             loanReport = new LoanReport();
             lender = new Lender();
             lender = arrayListLender.get(i);
             if(mapLoanReport.containsKey(lender.getEmail())) {
                loanReport.setNameLender(mapLoanReport.get(lender.getEmail()).getNameLender());
                loanReport.setLenderEmail(mapLoanReport.get(lender.getEmail()).getLenderEmail());
                loanReport.setAmount(mapLoanReport.get(lender.getEmail()).getAmount());
             }
             out.println("<tr>");
             out.println("<td>" + loanReport.getNameLender() + "</td>");
             out.println("<td>" + loanReport.getLenderEmail() + "</td>");
             out.println("<td>" + loanReport.getAmount() + "</td>");
	     out.println("</tr>");
           } 
	     out.println("<hr>");
	     out.println("</body></html>");
         /*tem.out.println("email: " + borrower.getEmail());
            System.out.println("paasword: " + borrower.getPassword());
            System.out.println("motivo del prestamo: " + borrower.getNeedMoneyFor());
            System.out.println("descripcion: " + borrower.getDescription());
            System.out.println("monto del prestamo: " + borrower.getAmountNeeded());
            System.out.println("Es un borrower...."); */
            
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
