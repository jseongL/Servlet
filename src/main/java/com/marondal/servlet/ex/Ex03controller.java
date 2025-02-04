package com.marondal.servlet.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Ex03")
public class Ex03controller extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html")
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		
		//이름과 생년월일을 전갈받고
		//이름과 나이를 html로 표현
		
		// request로부터 name이란 이름으로 이름을 얻어다 쓸거니
		// 이 기능 쓰고싶으면 name이란 이름으로 이름을 전달해
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");	// 20040312
		
		//브라우저에서 입력할 때 값 전달해야 에러 안남
		// ?name=임지성&birth=20020826
		
		
		String yearString = birth.substring(0, 4);
		int year = Integer.parseInt(yearString);
		
		int age = 2025 - year + 1;
		
		// 이름:김인규, 나이:24
		// 데이터를 문자열로 표현하기 위한 규격
		// JASON (javascript object nonation)
		// {"name":"김인규", "age":24}
		
		out.println("{\"name\":\"" + name + "\", \"age\":" + age + "}");
		
		
//		out.println(""
//				+ "<html>\n"
//				+ "		<head><title>정보</title></head\n"
//				+ "			<body>\n"
//				+ "				<h3>이름 : " + name + "</h3>\n"
//				+ "				<h3>나이 : " + age + "</h3>\n"
//				+ "			</body>\n"
//				+ "</html>");
		
		
		
	}
	
}










