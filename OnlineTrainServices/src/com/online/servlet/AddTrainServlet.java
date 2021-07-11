package com.online.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.InsertDAO;
@SuppressWarnings("serial")
public class AddTrainServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("Please ! Login First.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.include(req, res);
		}
		else
		{
			String fname=c[0].getValue();
			pw.print("<h1>WELCOME ADMIN : "+fname+"<br></h1>");
			RequestDispatcher rd=req.getRequestDispatcher("link1.jsp");
			rd.include(req, res);
			if(new InsertDAO().insert(req)>0)
			{
				pw.println("<h1><br> Train Added Successfull</h>");
			}
			
		}	
		
	}
		
		
}


