package com.online.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String sub=req.getParameter("sub");
		this.getServletContext().setAttribute("sub", sub);
		if(sub.equals("adminlogin"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
			rd.forward(req, res);
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("ulogin.jsp");
			rd.forward(req, res);
		}
	}

}
