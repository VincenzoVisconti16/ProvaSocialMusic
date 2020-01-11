package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import logic.actors.AutenthicatedUser;
import logic.utils.ConnectionDB;

public class UserDAO {

	public UserDAO() {

	}

	static Connection con;
	static Statement st;
	static ResultSet rs;

	public AutenthicatedUser getUtenteByUserPass(String username, String password) {

		AutenthicatedUser user = new AutenthicatedUser();
		try {

			con = ConnectionDB.dbConn();
			st = con.createStatement();
			String sql = "SELECT * from utenti WHERE username = '" + username + "' and password = '" + password + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setFirstname(rs.getString(5));
				user.setLastname(rs.getString(6));
				user.setSubsDate(rs.getDate(7));
				user.setBirthDate(rs.getDate(8));
				user.setZone(rs.getString(9));
				user.setInstrPlayed(rs.getString(10));
				user.setBand(rs.getBoolean(11));
				user.setNameBand(rs.getString(12));
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;
	}

}
