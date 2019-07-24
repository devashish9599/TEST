package com.devLearnsMVCServices;

import java.sql.SQLException;

import com.DAO.AuthDAO;
import com.devLearnsMVCModals.User;

public class AuthServices {
	AuthDAO authDAO = null;
	public AuthServices(AuthDAO authDAO) {
		 this.authDAO=authDAO;
		 }

	public boolean authenticateUser(User user) throws SQLException {
		boolean status = false;
		
		User userFromDb = authDAO.getUser(user);
		if(userFromDb.getPassword().equals(user.getPassword())
				&& userFromDb.getUsername().equals(user.getUsername())) {
			status = true;
			
		}
		return status;
			
		}
	}
	
	
