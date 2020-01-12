package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.entity.Register;
import logic.utils.ConnectionDB;

public class RegisterDAO {

	static Connection con;

	public void insertUser(Register register) {

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "INSERT INTO utenti (idUtente,username,password,email,firstname,lastname,subsdate,birthdate,zone,instrplayed,band,nameband) "
					+ "VALUES ('" + idGenerator() + "','" + register.getUsername() + "','" + register.getPassword()
					+ "','" + register.getEmail() + "','" + register.getFirstname() + "','" + register.getLastname()
					+ "','" + register.getSubsDate() + "','" + register.getBirthDate() + "','" + register.getZone()
					+ "','" + register.getInstrPlayed() + "','" + register.getBandFlag() + "','"
					+ register.getNameBand() + "')";
			tempSt.executeQuery(sql);
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

	public String checkUsernameAlreadyTaken(String usname) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT username FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while (tempRs.next()) {
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

	public String checkEmailAlreadyTaken(String email) {

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
