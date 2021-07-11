package com.online.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.LoginDAOServlet;
@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(new LoginDAOServlet().login(req))
		{
			String fname=(String)this.getServletContext().getAttribute("fname");
			this.getServletContext().removeAttribute("fname");
			Cookie ck=new Cookie("name",fname);
			pw.println("<h1>WELCOME USER : "+fname+"</h1><br>");
			RequestDispatcher rd=req.getRequestDispatcher("link2.jsp");
			rd.include(req, res);
			res.addCookie(ck);
			
		}
		else
		{
			pw.print("<h1>Invalid Username And Password</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("ulogin.jsp");
			rd.include(req, res);
			
			
		}

}
}
