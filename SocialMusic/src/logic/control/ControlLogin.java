package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.entity.Login;

public class ControlLogin {

	public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: Data not found. Retry!");

		alert.showAndWait();
	}

	public String checkIfRegistered(String username, String password) {

		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		String result = login.checkIfRegistered();

		return result;
	}

}
