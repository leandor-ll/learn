package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;


public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String text = request.getParameter("text");
		UserDao userDao = new UserDao();
		System.out.println("往数据库中添加的文本内容--------:"+text);
		userDao.insertText(text);
		request.getRequestDispatcher("demo.jsp").forward(request, response);
		return;
	}

}
