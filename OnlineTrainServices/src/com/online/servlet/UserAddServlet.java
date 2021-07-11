package com.online.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.UserProfileDAO;
import com.online.dto.UserBean;
@SuppressWarnings("serial")
public class UserAddServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		UserBean ub=new UserBean();
		ub.setUname(req.getParameter("uname"));
		ub.setPword(req.getParameter("pword"));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		ub.setMid(req.getParameter("mid"));


		if(new UserProfileDAO().insert(ub)>0)
		{
				RequestDispatcher rd=req.getRequestDispatcher("ulogin.jsp");
				rd.include(req, res);
				pw.print("<h1>Registration Successfull</h1>");
		}
		else
		{
				pw.print("</h3>Invalid details</h3>");
		}
			
			
		}
		
}


