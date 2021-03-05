<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<tr align="center" bgcolor="#FFFFFF">
             
        <td align="center"><font color=Black><b>Product List&nbsp;&nbsp;</b></font></td>
        <td align="center"><font color=Black><b>Price&nbsp;&nbsp;</b></br></br></font></td>
        
        </tr>
<%	
	ResultSet result = (ResultSet) request.getAttribute("result");
	int serialno = 1;
	while(result.next())
	{
		String product = result.getString("product");
		String price = result.getString("price");

		%>
		 <tr align="center" bgcolor="FFFBD0">
            
            <td align="center" height="8"><font color="black" face="Verdana, Arial, Helvetica, sans-serif" size="2"><%=serialno+". "+product%></font></td>
            <td align="center" height="8"><font color="black" face="Verdana, Arial, Helvetica, sans-serif" size="2"><%=price%></font></br></td>
            
    	</tr>
		<%
		serialno++;
	}
%>
</br>
<form action="addition" method="post">  
<input type="text" name="pname"/>  
<param name="user" value=<%=request.getParameter("uname")%>/>
<button>ADD PRODUCT</button>  
</form> 
</br>
<form action="checkout" method="post">  
<button>CheckOut</button>  
</form> 

</body>
</body>
</html>