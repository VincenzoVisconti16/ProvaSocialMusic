package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.actors.AutenthicatedUser;
import logic.utils.ConnectionDB;

public class RegisterDAO {

	public RegisterDAO() {

	}

	static Connection con;
	static Statement st;
	static ResultSet rs;

	public void insertUtente(AutenthicatedUser user) {

		try {
			con = ConnectionDB.dbConn();
			st = con.createStatement();
			String sql = "INSERT INTO utenti (idUtente,username,password,email,firstname,lastname,subsdate,birthdate,zone,instrplayed,band,nameband) "
					+ "VALUES ('" + idGenerator() + "','" + user.getUsername() + "','" + user.getPassword() + "','"
					+ user.getEmail() + "','" + user.getFirstname() + "','" + user.getLastname() + "','"
					+ user.getSubsDate() + "','" + user.getBirthDate() + "','" + user.getZone() + "','"
					+ user.getInstrPlayed() + "','" + user.getBand() + "','" + user.getNameBand() + "')";
			rs = st.executeQuery(sql);
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int idGenerator() {

		int result = 0;
		int count = 0;

		try {
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT idUtente FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);
			while (tempRs.next()) {
				count++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result = count;
		return result;
	}

	public String checkUsername(String usname) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT username FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			if (tempRs.next()) {
				String dummyUsName = tempRs.getString("username");
				if (dummyUsName.equals(usname)) {

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
