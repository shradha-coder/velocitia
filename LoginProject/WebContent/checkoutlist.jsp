<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Out List</title>
</head>
<body>
<tr align="center" bgcolor="#FFFFFF">
             
        <td align="center"><font color=Black><b>Product You Bought&nbsp;&nbsp;</b></font></td>
        <td align="center"><font color=Black><b>Price&nbsp;&nbsp;</b></br></br></font></td>
        
        </tr>
<%	
	ResultSet result_checkout = (ResultSet) request.getAttribute("checkout_result");
	int serialno = 1;
	int total_price = 0;
	while(result_checkout.next())
	{
		String product = result_checkout.getString("product");
		String price = result_checkout.getString("price");
		total_price = total_price+Integer.parseInt(price);

		%>
		 <tr align="center" bgcolor="FFFBD0">
            
            <td align="center" height="8"><font color="black" face="Verdana, Arial, Helvetica, sans-serif" size="2"><%=serialno+". "+product%></font></td>
            <td align="center" height="8"><font color="black" face="Verdana, Arial, Helvetica, sans-serif" size="2"><%=price%></font></br></td>
            
    	</tr>
		<%
		serialno++;
	}
%>
<td align="center"><font color=Black><b>Total Amount&nbsp;&nbsp;</b></font></td>
<td align="center"><font color=Black><b><%=total_price%>&nbsp;&nbsp;</b></br></br></font></td>
</br>
</br>
<form action="finalcheckout" method="post">  
<button>Final CheckOut</button>  
</form> 

</body>
</body>
</html>