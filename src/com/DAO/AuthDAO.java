package com.DAO;
import com.devLearnsMVCModals.User;
import com.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class AuthDAO {
	Statement statement = null;
	ResultSet resultSet = null;
	Connection connection = null;
	PreparedStatement pts = null;
	public AuthDAO() throws SQLException, ClassNotFoundException { 
		connection = ConnectionUtils.getConnection();
		}
public User getUser(User user) throws SQLException {
		User userFromDb = new User();
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		pts = connection.prepareStatement(sql);
		pts.setString(1, user.getUsername());
		pts.setString(2, user.getPassword());
		resultSet = pts.executeQuery(); 
		while(resultSet.next()) {
			userFromDb.setUsername(resultSet.getString(2));
			userFromDb.setPassword(resultSet.getString(3));
		}
		return userFromDb;
	}
}
