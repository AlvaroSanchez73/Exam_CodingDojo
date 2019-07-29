
<%@page import="java.util.ArrayList"%>
<%@page import="services.LoanServices"%>
<%@page import="beans.Lender"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="beans.LoanReport"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="beans.Borrower" %>

        <title>Borrower Page</title>
    </head>
    <body bgcolor="#FFFFCC">
        <%
	  Borrower borrower = new Borrower();
	  borrower = (Borrower)request.getAttribute("borrower");
        %>

        <h1 align="center">Borrower</h1>
        <h2>Name: <%=borrower.getFirstName() + " " + borrower.getLastName()%></h2>
        <h2>Amount Needed: <%=borrower.getAmountNeeded() %></h2>
         
        <table border="2">
	<tbody>
        <caption>List of people who lent you money</caption>
	<tr>
            <th>Name</th>
            <th>Email</th>
            <th>Amount Lent</th>
	</tr>
        
        <%
        
           Map<String, LoanReport> mapLoanReport = new HashMap<>();
           LoanReport loanReport = null;
           LoanServices loanServices = new LoanServices();
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
        %>
           <tr>
            <td><%=loanReport.getNameLender() %></td>
            <td><%=loanReport.getLenderEmail()%></td>
            <td><%=loanReport.getAmount() %></td>
	  </tr>
        <%
           }
        %>
  
    </body>
</html>
