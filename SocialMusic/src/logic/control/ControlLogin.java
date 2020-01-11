package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.actors.AutenthicatedUser;
import logic.dao.UserDAO;

public class ControlLogin {

	public ControlLogin() {
	}

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

	public int checkIfRegistered(String username, String password) {

		int result = 0;

		UserDAO userDAO = new UserDAO();
		AutenthicatedUser user = userDAO.getUtenteByUserPass(username, password);

		if (user != null && user.getUsername() != null) {

			result = 1;
		}

		return result;
	}

}
