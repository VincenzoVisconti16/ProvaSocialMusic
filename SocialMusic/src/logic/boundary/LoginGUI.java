package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.actors.AutenthicatedUser;
import logic.dao.UserDAO;
import logic.utils.WindowManagerGUI;

public class LoginGUI {

	public static VBox getLoginPageScene() {

		VBox root = new VBox();

		Text title = new Text();

		title.setText("Benvenuto in Social Music!");

		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();

		Button loginBTN = new Button("Accedi");
		Button registerBTN = new Button("Registrati");
		Button recoverDataBTN = new Button("Recupera Dati");

		WindowManagerGUI win = new WindowManagerGUI();

		usernameField.setMaxWidth(200);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		passwordField.setMaxWidth(200);
		passwordField.setAlignment(Pos.CENTER_LEFT);
		passwordField.setPromptText("Password");

		loginBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Login Error");
					alert.setContentText("Error: You didn't insert Username. Retry!");

					alert.showAndWait();

				} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Login Error");
					alert.setContentText("Error: You didn't insert Password. Retry!");

					alert.showAndWait();

				} else {
					String username = usernameField.getText();
					String password = passwordField.getText();
					UserDAO userDAO = new UserDAO();
					AutenthicatedUser user = userDAO.getUtenteByUserPass(username, password);

					if (user != null && user.getUsername() != null) {

						win.loadHomePage();

					} else {

						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Social Music");
						alert.setHeaderText("Login Error");
						alert.setContentText("Error: Data not found. Retry!");

						usernameField.clear();
						passwordField.clear();

						alert.showAndWait();
					}
				}
			}
		});

		registerBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadRegisterPage();
			}
		});

		recoverDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadRecoverDataPage();
			}
		});

		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, usernameField, passwordField, loginBTN, registerBTN, recoverDataBTN);

		return root;

	}
}
