package com.online.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.online.db.DBConnection;
public class InsertDAO 
{
	public int k;
	public int insert(HttpServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into train25 values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(req.getParameter("tno")));
			ps.setString(2, req.getParameter("tname"));
			ps.setString(3, req.getParameter("fstation"));
			ps.setString(4, req.getParameter("tstation"));
			ps.setString(5, req.getParameter("dtime"));
			ps.setString(6, req.getParameter("atime"));
			ps.setInt(7, Integer.parseInt(req.getParameter("avl")));
			ps.setFloat(8, Float.parseFloat(req.getParameter("price")));
			k=ps.executeUpdate();
						
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
