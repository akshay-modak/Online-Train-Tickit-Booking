package com.online.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.online.db.DBConnection;
public class LoginDAOServlet
{
	public boolean z;
	public boolean login(HttpServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getCon();
			String sub=(String)req.getServletContext().getAttribute("sub");
			if(sub.equals("adminlogin"))
			{
				PreparedStatement ps=con.prepareStatement("select * from admin25 where uname=? and pword=?");
				ps.setString(1, req.getParameter("uname"));
				ps.setString(2, req.getParameter("pword"));
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					z=true;
					req.getServletContext().setAttribute("fname", rs.getString(1));
					
				}
			}
			else
				{
					PreparedStatement ps=con.prepareStatement("select * from usereg25 where uname=? and pword=?");
					ps.setString(1, req.getParameter("uname"));
					ps.setString(2, req.getParameter("pword"));
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						z=true;
						req.getServletContext().setAttribute("fname", rs.getString(3));
						
					}
				}
				
			}
		catch(Exception e) {e.printStackTrace();}
			req.getServletContext().removeAttribute("sub");
		return z;
		}
}

