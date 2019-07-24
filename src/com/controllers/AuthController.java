package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AuthDAO;
import com.devLearnsMVCModals.User;
import com.devLearnsMVCServices.AuthServices;
import com.utils.ValidateNormalData;


@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;     
       
    
	
	AuthServices authServices = null;
    public AuthController() throws SQLException, ClassNotFoundException  {
    	super();
    	authServices = new AuthServices(new AuthDAO());
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		;
		PrintWriter out = response.getWriter();
		//RequestDispatcher dispatcher = null;
		String pageUser = request.getParameter("username");
		String pagePassword = request.getParameter("password");
		  if (!ValidateNormalData.isValid(pageUser,pagePassword)) {
			  
			//dispatcher = request.getRequestDispatcher("//samepage");
			//dispatcher.forward(request, response);
			  out.print("error");
		}
		  else {
			User user = new User();
			user.setUsername(pageUser);
			user.setPassword(pagePassword);
			boolean status = false;
			
				try {
					status = authServices.authenticateUser(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (status) {
				out.println("Authenticated");
			}
			else {
				out.println("User does not exist");
			}
			
			}
		  
		}
}
