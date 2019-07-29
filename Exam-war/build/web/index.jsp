<%-- 
    Document   : index
    Created on : 28-jul-2019, 13:43:20
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exam</title>
    </head>
    <body bgcolor="#dedefe">
	<form name="login" method="post" action="ServletLogin">	
	<table align="center" border="3">
	<tbody>
		<tr>
			<th colspan="2"><img border="0" src="img/lender.jpg" width="150"
				height="95"><img border="0" src="img/borrower.jpg" width="150"
				height="95"><img border="0" src="img/lender_borrower.jpg" width="150"
				height="95"></th>
		</tr>
		<tr>
			<th colspan="2"><h2><i>Sistema de Prestamo</i></h2>::.. Ayuda Financiera ..::</th>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" size="35" maxlength="30"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" size="20" maxlength="15"></td>
		</tr>
		<tr>
                    <td colspan="2">
                            <a href="./register.jsp" >Click here to register</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" name="login" value="Login" />
                        </td>
		</tr>
	</tbody>
	</table>
	</form>
</body>
</html>
