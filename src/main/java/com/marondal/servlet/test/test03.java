package com.marondal.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test03")
public class test03 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		Date now = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 M월 d일");
		String dateString = formatter.format(now);
		
		out.println(""
			      + "<html>\n"
				  + "		<head><title>news</title></head>\n"
			      + "		<body>\n"
				  + "			<h1>[단독] 고양이가 야옹해</h1>\n"
			      + "     		<p>기사 입력시간 : " + dateString + "</p>"
			      + "			<hr>"
			      + "			끝"
				  + "		</body>\n"
				  + "</html>");
	
		
	
	}
	
	

}
