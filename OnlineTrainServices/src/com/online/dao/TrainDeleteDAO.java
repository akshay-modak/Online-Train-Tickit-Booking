package com.online.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.online.db.DBConnection;
public class TrainDeleteDAO 
{
	public int z;
	public int delete(HttpServletRequest req) 
	{
		try
		{
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("delete from train25 where tno=? ");
		ps.setInt(1, Integer.parseInt(req.getParameter("tno")));
		
		z=ps.executeUpdate();
		
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		return z;
		
	}

}
