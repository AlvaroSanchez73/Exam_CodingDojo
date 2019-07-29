<%-- 
    Document   : register
    Created on : 28-jul-2019, 14:29:52
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body bgcolor="#dedefe">
        <h1 align="center">Register</h1>
        <br/>
        <form name="register" method="post" action="ServletRegister">	
	<table align="center" border="3">
	<tbody>
        <th>
            <tr>
                <td colspan="2" >Lender</td> 
                <td colspan="2">Borrower</td> 
            </tr>
        </th>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="lenderFirstName" size="15" maxlength="20" /></td>
            <td>First Name:</td>
            <td><input type="text" name="borrowerFirstName" size="15" maxlength="20" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lenderLastName" size="15" maxlength="20" /></td>
            <td>Last Name:</td>
            <td><input type="text" name="borrowerLastName" size="15" maxlength="20" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="lenderEmail" size="35" maxlength="30" /></td>
            <td>Email:</td>
            <td><input type="email" name="borrowerEmail" size="35" maxlength="30" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="lenderPassword" size="15" maxlength="20" /></td>
            <td>Password:</td>
            <td><input type="password" name="borrowerPassword" size="15" maxlength="20" /></td>
        </tr>
        <tr>
            <td>Money:</td>
            <td><input type="number" name="lenderMoney" maxlength="6" /></td>
            <td>Need Money for:</td>
            <td><input type="text" name="borrowerNeedMoneyFor" size="25" maxlength="30" /></td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td>Description:</td>
            <td>
                <textarea name="borrowerDescription"  rows="3" cols="35" maxlength="100">
                </textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td>Amount Needed:</td>
            <td><input type="number" name="borrowerAmountNeeded" min="1" /></td>
        </tr>
        <tr>
            <td colspan="2">
              <a href="./index.jsp" >Already a member</a>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="submit" name="lenderRegister" value="Register" />
            </td>
            <td colspan="2">
              <a href="./index.jsp" >Already a member</a>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="submit" name="borrowerRegister" value="Register" />
            </td>
	</tr>
        </tbody>
        </table>
    </body>
</html>
