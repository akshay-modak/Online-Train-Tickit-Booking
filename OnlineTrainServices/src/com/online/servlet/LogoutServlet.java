package com.online.servlet;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LogoutServlet  extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie []c=req.getCookies();
		if(c==null)
		{
			pw.println("<h3>Please ! Login First....<br><h3>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.include(req, res);
		}
		else
		{
			c[0].setValue(" ");
			c[0].setMaxAge(0);
			pw.println("<h3>Logged Out Succesfully....<br></h3>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.include(req, res);
		}
	}

}
