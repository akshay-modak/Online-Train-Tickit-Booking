package com.online.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.online.db.DBConnection;
import com.online.dto.TrainBean;
@SuppressWarnings("serial")
public class RetriveDAO2 extends HttpServlet 
{
	ArrayList<TrainBean> al = new ArrayList<TrainBean>(); 
	public ArrayList<TrainBean> retrive (HttpServletRequest req)
	{
		
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from train25 where fstation=? and tstation=?");
			ps.setString(1, req.getParameter("fstation"));
			ps.setString(2, req.getParameter("tstation"));
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				TrainBean tb=new TrainBean();
				tb.settNo(rs.getInt(1));
				tb.settName(rs.getString(2));
				tb.setfStation(rs.getString(3));
				tb.settStation(rs.getString(4));
				tb.setdTime(rs.getString(5));
				tb.setaTime(rs.getString(6));
				tb.setAvl(rs.getInt(7));
				tb.setPrice(rs.getFloat(8));
				al.add(tb);
				
			}
			
		}
		catch(Exception e) {e.printStackTrace();}
		return al;
		
	}

}
