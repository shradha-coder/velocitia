package com.org.service;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnect 
{
	public Connection DataBaseConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","root");  
			System.out.println("Connection Created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
