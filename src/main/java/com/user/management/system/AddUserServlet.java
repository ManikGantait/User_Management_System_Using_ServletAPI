package com.user.management.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

;

public class AddUserServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userId"));
		String userName=req.getParameter("userName");
		String userEmail=req.getParameter("userEmail");
		String userAddress=req.getParameter("userAddress");
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/servlet_project_userManagement", "root", "Mysql@123");
			PreparedStatement psmt=con.prepareStatement("INSERT INTO user values(?,?,?,?)");
			psmt.setInt(1, userId);
			psmt.setString(2, userName);
			psmt.setString(3, userEmail);
			psmt.setString(4, userAddress);
			int res=psmt.executeUpdate();
			con.close();
			resp.sendRedirect("index.jsp");
					
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
