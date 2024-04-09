package com.user.management.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUpdateUserDetailsServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(req.getParameter("userId"));
		int userId=Integer.parseInt(req.getParameter("userId"));
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project_userManagement","root","Mysql@123");
			PreparedStatement psmt=con.prepareStatement("SELECT *FROM  user WHERE userId=?");
			psmt.setInt(1, userId);
			ResultSet res=psmt.executeQuery();
			req.setAttribute("getUpdateDetails", res);
			//con.close();
			RequestDispatcher dispatcher=req.getRequestDispatcher("UpdateUser.jsp");
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
