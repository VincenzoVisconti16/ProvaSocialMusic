package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.actors.AutenthicatedUser;
import logic.dao.RegisterDAO;

public class ControlRegister {

	public ControlRegister() {

	}

	public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}

	public void sendFirstNameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert First Name. Retry!");

		alert.showAndWait();
	}

	public void sendInstrPlayedAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert the Instrument Played. Retry!");

		alert.showAndWait();
	}

	public void sendNameBandAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Name of your Band. Retry!");

		alert.showAndWait();
	}

	public String checkUsernameAlreadyTaken(String username) {

		RegisterDAO registerDAO = new RegisterDAO();
		String result = registerDAO.checkUsername(username);

		return result;
	}

	public void sendUsernameAlreadyTakenAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Username already in use. Retry!");

		alert.showAndWait();
	}

	public void registerUser(String username, String password, String email, String firstName, String lastName,
			String subsDate, String birthDate, String zone, String instrPlayed, String bandFlag, String nameBand) {

		RegisterDAO registerDAO = new RegisterDAO();
		AutenthicatedUser user = new AutenthicatedUser();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setSubsDate(subsDate);
		user.setBirthDate(birthDate);
		user.setZone(zone);
		user.setInstrPlayed(instrPlayed);

		if (bandFlag.equals("band")) {

			user.setBand(1);
			user.setNameBand(nameBand);
		} else {

			user.setBand(0);
			user.setNameBand(null);
		}

		registerDAO.insertUtente(user);
	}

	public String checkEmailAlreadyTaken(String email) {

		RegisterDAO registerDAO = new RegisterDAO();
		String result = registerDAO.checkEmail(email);

		return result;
	}

	public void sendEmailAlreadyTakenAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Email already in use. Retry!");

		alert.showAndWait();
	}

	public void registrationAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration");
		alert.setContentText("Success! Your Account has been registrated!");

		alert.showAndWait();
	}
}
