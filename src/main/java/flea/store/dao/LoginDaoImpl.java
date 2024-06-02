package flea.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import flea.store.pojos.Login;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean validUser(Login user) {
		boolean status=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minor_project", "root",
					"Indore@123");
			
			PreparedStatement pStmt=con.prepareStatement("SELECT * FROM registration_page WHERE email_id=? and password=?");
			pStmt.setString(1, user.getUsername());
			pStmt.setString(2, user.getPassword());
			
			ResultSet rSet=pStmt.executeQuery();
			status=rSet.next();
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return status;
	}

	
}
