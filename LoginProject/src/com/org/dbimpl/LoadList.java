package com.org.dbimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadProduct
 */
@WebServlet("/loadlist")
public class LoadList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoadProduct product = new LoadProduct();

    public LoadList() {
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
		
		
		ResultSet rslt = product.getProductlist();
		  
		System.out.println(request.getSession().getAttribute("uname"));
        RequestDispatcher rd=request.getRequestDispatcher("productlisting.jsp");  
        request.setAttribute("result", rslt);
        rd.forward(request,response);  

	}

}
