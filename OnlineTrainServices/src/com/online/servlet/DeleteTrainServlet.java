package com.online.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.TrainDeleteDAO;
@SuppressWarnings("serial")
public class DeleteTrainServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie []c=req.getCookies();
		if(c==null)
		{
			pw.println("<h3>Please ! Login First.....<br></h3>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.include(req, res);
		}
		else 
		{
			
			if(new TrainDeleteDAO().delete(req)>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("link1.jsp");
				rd.include(req, res);
				pw.println("<h1>Train delete Successfull....!</h1>");
			}
			else
			{
			RequestDispatcher rd=req.getRequestDispatcher("link1.jsp");
			rd.include(req, res);
			pw.println("Train not available as per train number");
			}
		}
	}
	}
