package com.org.dbimpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.service.ServiceImpl;

/**
 * Servlet implementation class FinalCheckOut
 */
@WebServlet("/finalcheckout")
public class FinalCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceImpl service = new ServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalCheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service.FinalCheck();
        RequestDispatcher rd=request.getRequestDispatcher("thankyou.jsp");  
        rd.forward(request,response);
		
	}

}
