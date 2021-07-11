package com.online.db;
import java.sql.*;
public class DBConnection 
{
	private static Connection con=null;
	private DBConnection() {}
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akshay","root","root");
			System.out.println(con.hashCode());
		}
		catch(Exception ob)
		{
			ob.printStackTrace();
			
		}
	}
		public static Connection getCon()
		{
			return con;
		}
}


