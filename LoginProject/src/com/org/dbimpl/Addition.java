package com.org.dbimpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.service.ServiceImpl;

/**
 * Servlet implementation class Addition
 */
@WebServlet("/addition")
public class Addition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceImpl service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addition() {
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
		
		response.setContentType("text/html");//setting the content type  
		PrintWriter out=response.getWriter();//get the stream to write the data  
		
		String ProStatus = service.AddEntry(request);
		
		if(ProStatus.equalsIgnoreCase("SUCCESS"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("loadlist");  
			rd.forward(request,response);  
		}
		else if(ProStatus.equalsIgnoreCase("PRODUCT NOT AVAILABLE"))
		{
			out.print("Sorry Product Not listed here.");  
	        RequestDispatcher rd=request.getRequestDispatcher("loadlist");  
	        rd.include(request,response); 
		}
	}

}
