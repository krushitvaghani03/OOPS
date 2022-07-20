package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		PrintWriter pw = resp.getWriter();
//		pw.write("<h1> email : "+email+"</h1>");
//		pw.write("<h1> pass : "+pass+"</h1>");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","");
			PreparedStatement ps = cn.prepareStatement("select * from data where email = ? and pass = ?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs  = ps.executeQuery();
			if(rs.next())
			{
				pw.write("<h1>Welcome :"+rs.getString(2)+"</h1>");
			}
			else
			{
				pw.write("<h1>Invalid Username and Password</h1>");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
