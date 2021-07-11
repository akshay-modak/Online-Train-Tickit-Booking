package com.online.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.online.db.DBConnection;
public class AdminEditDAO
{
	public int z;
	public int edit(HttpServletRequest req) 
	{
		try
		{
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("update train25 set tno=?,tname=?,fstation=?,tstation=?,dtime=?,atime=?,avl=?,price=? where tno=?");
		ps.setInt(1, Integer.parseInt(req.getParameter("tno")));
		ps.setString(2, req.getParameter("tname"));
		ps.setString(3, req.getParameter("fstation"));
		ps.setString(4, req.getParameter("tstation"));
		ps.setString(5, req.getParameter("dtime"));
		ps.setString(6, req.getParameter("atime"));
		ps.setFloat(7, Float.parseFloat(req.getParameter("price")));
		ps.setInt(8, Integer.parseInt(req.getParameter("avl")));
		ps.setInt(9, Integer.parseInt(req.getParameter("tno")));
		
		z=ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		return z;
	}

}
