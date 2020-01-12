package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.utils.ConnectionDB;

public class LoginDAO {

	public String checkIfRegistered(String username, String password) {

		Connection con;

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT username,password FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while (tempRs.next()) {
				String dummyUsername = tempRs.getString("username");
				String dummyPassword = tempRs.getString("password");
				if (dummyUsername.equals(username) && dummyPassword.equals(password)) {

					status = "trovato";
					con.close();
					return status;
				}

			}

			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		status = "non trovato";
		return status;
	}

}
