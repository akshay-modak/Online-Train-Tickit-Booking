package com.online.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.RetriveDAO2;
import com.online.dto.TrainBean;
@SuppressWarnings("serial")
public class ViewTrainServlet2 extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie []c=req.getCookies();
		if(c==null)
		{
			pw.println("<h3>Please ! Login First.....</h3><br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.include(req, res);
		}
		else
		{
			String fname=c[0].getValue();
			pw.println("<h1>WELCOME USER : "+fname+"</h1><br>");
			RequestDispatcher rd=req.getRequestDispatcher("link2.jsp");
			rd.include(req, res);
			ArrayList<TrainBean>al=new RetriveDAO2().retrive(req);
			if(al.size()==0)
			{
				pw.println("<br>No Trains....");
			}
			else
			{
				this.getServletContext().setAttribute("JcfRef", al);
			}
			al.forEach(p->{
				TrainBean tb=(TrainBean)p;
				pw.print("<br><a href=select?tno="+tb.gettNo()+">"+tb.gettNo()+"</a>");
				
				pw.println("&nbsp&nbsp&nbsp"+tb.gettName()+"&nbsp&nbsp&nbsp");
				pw.println("<a href=BookiTickit.jsp>Book Tickit</a>");
				req.setAttribute("trainno",tb.gettNo());
				
				
				
			});
			
		
			
		}
		
	}
	

}
