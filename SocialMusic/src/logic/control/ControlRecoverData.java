package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.dao.RecoverDataDAO;
import logic.dao.RegisterDAO;
import logic.utils.MailSender;

public class ControlRecoverData {

	public ControlRecoverData() {

	}

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

	public void sendEmail(String email) {

		MailSender ms = new MailSender();
		RecoverDataDAO recDataDAO = new RecoverDataDAO();
		String username = recDataDAO.getUserNameByEmail(email);
		String password = recDataDAO.getPasswordByEmail(email);

		ms.sendMail(email, username, password);
	}

	public String checkIfRegistered(String email) {

		RecoverDataDAO recDataDAO = new RecoverDataDAO();
		String result = recDataDAO.checkEmail(email);

		return result;
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: Email not found. Retry!");
		
		alert.showAndWait();
	}

}
