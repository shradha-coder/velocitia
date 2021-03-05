package com.org.dbimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.org.service.DbConnect;

public class LoadProduct 
{
	DbConnect DbConnection = new DbConnect();

	public ResultSet getProductlist()
	{
		Connection conn = null;
		ResultSet result = null;

		try
		{
			conn = DbConnection.DataBaseConnection();
			Statement statement = conn.createStatement();

			String getlist = "Select product,price from tbl_product_list";
			
			result = statement.executeQuery(getlist);
						
			System.out.println("list:"+result);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
