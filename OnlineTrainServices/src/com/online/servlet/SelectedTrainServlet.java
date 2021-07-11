package com.online.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dto.TrainBean;
@SuppressWarnings("serial")
public class SelectedTrainServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
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
			pw.println("<h1>WELCOME USER : "+fname+"<br></hh1>");
			RequestDispatcher rd=req.getRequestDispatcher("link2.jsp");
			rd.include(req, res);
			ArrayList<TrainBean>al=(ArrayList<TrainBean>)this.getServletContext().getAttribute("JcfRef");
			System.out.println(req.getParameter("tno"));
			int tno=Integer.parseInt(req.getParameter("tno"));
			System.out.println("tno dfljnwejfhfewukb  "+tno);
			
			@SuppressWarnings("rawtypes")
			List l=al.stream().filter((k)->k.gettNo()==tno).collect(Collectors.toList());
			
			l.forEach((z)->{
				TrainBean tb=(TrainBean)z;
				pw.print("<h4>Train number : "+tb.gettNo()+"<br>"+
						"Train Name :"+tb.gettName()+"<br>"+
						"From Station :"+tb.getfStation()+"<br>"+
						"Source Station :"+tb.getfStation()+"<br>"+
						"Arrival Time :"+tb.getdTime()+"<br>"+
						"Departure Time :"+tb.getaTime()+"<br>"+
						"Avalibility : "+tb.getAvl()+"<br>"+
						"Fare : "+tb.getPrice()+"</h4><br>");
			});
			
		}
	

	}
}
