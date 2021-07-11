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

import com.online.dao.RetriveDAO;
import com.online.dto.TrainBean;
@SuppressWarnings("serial")
public class ViewTrainServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("<h3>Please ! Login First.......</h3><br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.include(req, res);
			}
		else
		{
			String fname=c[0].getValue();
			pw.println("<h1>WELCOME ADMIN :"+fname+"<br></h1>");
			RequestDispatcher rd=req.getRequestDispatcher("link1.jsp");
			rd.include(req, res);
			ArrayList<TrainBean> al=new RetriveDAO().retrive();
			
			if(al.size()==0)
			{
				pw.println("<br><h3> No Trains Available.....</h3>");
			}
			else
			{
				al.forEach((p)->{TrainBean tb=(TrainBean)p;
				pw.println("<h4><br>"+tb.gettNo()+"&nbsp&nbsp"+tb.gettName()+"&nbsp&nbsp"+tb.getfStation()
				+"&nbsp&nbsp"+tb.gettStation()+"&nbsp&nbsp"+tb.getdTime()+"&nbsp&nbsp"+tb.getaTime()+"&nbsp&nbsp"
				+tb.getAvl()+"&nbsp&nbsp"+tb.getPrice()+"</h4>");
				});
			}
		}
		
	}
	
}
