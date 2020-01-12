package logic.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import logic.entity.Register;

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
	
	public void sendEmailNotValidAlert() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Email format not valid. Retry!");

		alert.showAndWait();		
	}

	public void sendUsernameAlreadyTakenAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Username already in use. Retry!");

		alert.showAndWait();
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

	public void registerUser(String username, String password, String email, String firstName, String lastName,
			String subsDate, String birthDate, String zone, String instrPlayed, String bandFlag, String nameBand) {

		Register register = new Register();

		register.setUsername(username);
		register.setPassword(password);
		register.setEmail(email);
		register.setFirstname(firstName);
		register.setLastname(lastName);
		register.setSubsDate(subsDate);
		register.setBirthDate(birthDate);
		register.setZone(zone);
		register.setInstrPlayed(instrPlayed);

		if (bandFlag.equals("band")) {

			register.setBandFlag(1);
			register.setNameBand(nameBand);
		} else {

			register.setBandFlag(0);
			register.setNameBand(null);
		}

		register.insertUtente(register);
	}

	public String checkUsernameAlreadyTaken(String username) {

		Register register = new Register();
		register.setUsername(username);
		String result = register.checkUsernameAlreadyTaken();

		return result;
	}

	public String checkEmailAlreadyTaken(String email) {

		Register register = new Register();
		register.setEmail(email);
		String result = register.checkEmailAlreadyTaken();

		return result;
	}

	public boolean checkIfEmailIsValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
