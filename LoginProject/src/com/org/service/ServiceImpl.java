package com.org.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class ServiceImpl {
	
	DbConnect DbConnection = new DbConnect();

	public String ProcessReq(HttpServletRequest request) 
	{
		String STATUS = "";
		Connection conn = null;
		try
		{
			conn = DbConnection.DataBaseConnection();
			Statement statement = conn.createStatement();
			
			System.out.println("Hitting query");
			String Querry = "Select count(1) from tbl_login where username = '"+request.getParameter("uname")+"' "
					+ "and password = '"+request.getParameter("psw")+"'";
			
			System.out.println("Querry:"+Querry);
			
			ResultSet result = statement.executeQuery(Querry);
			if(result.next())
			{
				int count = result.getInt(1);
				if(count==1)
					STATUS = "SUCCESS";
				else
					STATUS = "FAIL";
			}
			else
			{
				STATUS = "FAIL";
			}
			conn.close();
		}
		catch(Exception e)
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return STATUS;
	}

	public String AddEntry(HttpServletRequest request) 
	{
		Connection conn = null;
		String status = "";
		try
		{
			conn = DbConnection.DataBaseConnection();
			Statement statement = conn.createStatement();
			
			String price = getPrice(request.getParameter("pname"));
			

				String Querry = "insert into tbl_cart (product,price,username) values ('"+request.getParameter("pname")+"','"+price+"','"+request.getParameter("uname")+"')";
				statement.executeUpdate(Querry);
				status="SUCCESS";
		
			
			conn.close();
			
		}
		catch(Exception e)
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}
		return status;
		
	}

	private String getPrice(String productname) 
	{
		Connection conn = null;
		String price = "";
		
		try
		{
			conn = DbConnection.DataBaseConnection();
			Statement statement = conn.createStatement();
						
			String Querry = "select price from tbl_product_list where product = '"+productname+"'";
			
			ResultSet rs = statement.executeQuery(Querry);
			
			if(rs.next())
				price = rs.getString("price");
				
			conn.close();
			
			
		}
		catch(Exception e)
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		
			
		}
		return price;
	}

	public ResultSet getcartlist(HttpServletRequest request) 
	{

		Connection conn = null;
		ResultSet rs = null;
		
		try
		{
			conn = DbConnection.DataBaseConnection();
			Statement statement = conn.createStatement();
						
			String Querry = "select product,price from tbl_cart";
			
			rs = statement.executeQuery(Querry);
						
			
		}
		catch(Exception e)
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		
			
		}
		return rs;
		
	}

	public void FinalCheck() {


		Connection conn = null;
		
		try
		{
			conn = DbConnection.DataBaseConnection();
			Statement statement = conn.createStatement();
						
			String Querry = "truncate tbl_cart";
			
			statement.executeUpdate(Querry);
						
			conn.close();
		}
		catch(Exception e)
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		
			
		}
		
	}

}
