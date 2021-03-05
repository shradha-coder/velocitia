package org.com.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.service.ServiceImpl;

/**
 * Servlet implementation class login
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceImpl service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
		response.setContentType("text/html");//setting the content type  
		PrintWriter out=response.getWriter();//get the stream to write the data  
		
		System.out.println("Username:"+request.getParameter("uname")+" Passord:"+request.getParameter("psw"));
		
		String status = service.ProcessReq(request);
		

		HttpSession session = request.getSession();
		session.setAttribute("uname", request.getAttribute("uname"));
		
		System.out.println("Staus:"+status);
		if(status.equalsIgnoreCase("SUCCESS")){  
	        RequestDispatcher rd=request.getRequestDispatcher("loadlist");  
	        rd.forward(request,response);  
	    }  
	    else{  
	    	out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	        rd.include(request,response);  
	    } 
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
