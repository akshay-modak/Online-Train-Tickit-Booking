package com.online.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.online.db.DBConnection;
import com.online.dto.UserBean;
public class UserProfileDAO  
{
	public int z;
	public int insert(UserBean ub)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into usereg25 values(?,?,?,?,?,?,?)");
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getPword());
			ps.setString(3, ub.getFname());
			ps.setString(4, ub.getLname());
			ps.setString(5, ub.getAddr());
			ps.setLong(6, ub.getPhno());
			ps.setString(7, ub.getMid());
			
			z=ps.executeUpdate();
		}
	
	catch(Exception e) {e.printStackTrace();}
		return z;
	}
	

}
