package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import logic.entity.RecoverData;
import logic.utils.MailSender;

public class ControlRecoverData {

	public void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}

	public void mailSentAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data");
		alert.setContentText("Success! Your Data has been sent at your email!");

		alert.showAndWait();
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: Email not found. Retry!");

		alert.showAndWait();
	}

	public void sendEmail(String email) {

		MailSender ms = new MailSender();

		RecoverData recoverData = new RecoverData();
		recoverData.setEmail(email);
		String username = recoverData.getUserNameByEmail();
		String password = recoverData.getPasswordByEmail();

		ms.sendMail(email, username, password);
	}

	public String checkIfRegistered(String email) {

		RecoverData recoverData = new RecoverData();
		recoverData.setEmail(email);
		String result = recoverData.checkIfRegistered();

		return result;
	}

}
