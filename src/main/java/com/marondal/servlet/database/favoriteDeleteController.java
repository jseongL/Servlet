package com.marondal.servlet.database;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/db/favorite/delete")
public class favoriteDeleteController extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id");
		
		MysqlService mysqlService = MysqlService.getInstance();//객체가 무분별하게 많이생성되서 접속하는걸 방지
		
		mysqlService.connect();
		
		try {
			mysqlService.update("DELETE FROM `user_goods` WHERE `id` = " + id + ";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("/db/favorite/list.jsp");
		
		
	}

}
