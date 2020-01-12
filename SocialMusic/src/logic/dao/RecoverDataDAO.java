package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.utils.ConnectionDB;

public class RecoverDataDAO {

	static Connection con;

	public String getUserNameByEmail(String email) {

		Statement st;
		ResultSet rs;
		String username = null;

		try {

			con = ConnectionDB.dbConn();
			st = con.createStatement();
			String sql = "SELECT * from utenti WHERE email = '" + email + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {

				username = rs.getString(2);

			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return username;
	}

	public String getPasswordByEmail(String email) {

		Statement st;
		ResultSet rs;
		String password = null;

		try {

			con = ConnectionDB.dbConn();
			st = con.createStatement();
			String sql = "SELECT * from utenti WHERE email = '" + email + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {

				password = rs.getString(3);

			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return password;
	}

	public String checkEmail(String email) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT email FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while (tempRs.next()) {
				String dummyEmail = tempRs.getString("email");
				if (dummyEmail.equals(email)) {

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
