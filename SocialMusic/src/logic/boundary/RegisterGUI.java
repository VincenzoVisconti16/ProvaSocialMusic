package logic.boundary;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.actors.AutenthicatedUser;
import logic.dao.RegisterDAO;
import logic.utils.WindowManagerGUI;

public class RegisterGUI {

	public static VBox getRegisterPageScene() {

		VBox root = new VBox();

		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 = new HBox();
		HBox hb6 = new HBox();

		Button registerBTN = new Button("Registrati");
		Button backBTN = new Button("Back");
		Text title = new Text();
		title.setText("Registrazione:");

		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();
		TextField emailField = new TextField();
		TextField firstNameField = new TextField();
		TextField lastNameField = new TextField();
		DatePicker birthDateField = new DatePicker();
		TextField zoneField = new TextField();
		TextField instrPlayedField = new TextField();
		CheckBox bandField = new CheckBox();
		TextField nameBandField = new TextField();

		WindowManagerGUI win = new WindowManagerGUI();

		usernameField.setMaxWidth(200);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		passwordField.setMaxWidth(200);
		passwordField.setAlignment(Pos.CENTER_LEFT);
		passwordField.setPromptText("Password");

		emailField.setMaxWidth(350);
		emailField.setAlignment(Pos.CENTER_LEFT);
		emailField.setPromptText("Email");

		firstNameField.setMaxWidth(200);
		firstNameField.setAlignment(Pos.CENTER_LEFT);
		firstNameField.setPromptText("First Name");

		lastNameField.setMaxWidth(200);
		lastNameField.setAlignment(Pos.CENTER_LEFT);
		lastNameField.setPromptText("Last Name");

		zoneField.setMaxWidth(200);
		zoneField.setAlignment(Pos.CENTER_LEFT);
		zoneField.setPromptText("Zone");

		instrPlayedField.setMaxWidth(200);
		instrPlayedField.setAlignment(Pos.CENTER_LEFT);
		instrPlayedField.setPromptText("Instrument");

		nameBandField.setMaxWidth(200);
		nameBandField.setAlignment(Pos.CENTER_LEFT);
		nameBandField.setPromptText("Name Band");
		nameBandField.setVisible(false);

		Text birth = new Text();
		birth.setText("When are you born?");

		Text band = new Text();
		band.setText("Are you in a band?");

		bandField.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				nameBandField.setVisible(newValue);
			}
		});

		registerBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Registration Error");
					alert.setContentText("Error: You didn't insert Username. Retry!");

					alert.showAndWait();

				} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Registration Error");
					alert.setContentText("Error: You didn't insert Password. Retry!");

					alert.showAndWait();

				} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Registration Error");
					alert.setContentText("Error: You didn't insert Email. Retry!");

					alert.showAndWait();

				} else if (firstNameField.getText() == null || firstNameField.getText().trim().isEmpty()) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Registration Error");
					alert.setContentText("Error: You didn't insert First Name. Retry!");

					alert.showAndWait();

				} else if (instrPlayedField.getText() == null || instrPlayedField.getText().trim().isEmpty()) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Registration Error");
					alert.setContentText("Error: You didn't insert the Instrument Played. Retry!");

					alert.showAndWait();

				} else if (bandField.isSelected() && nameBandField.getText().equals("")) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Social Music");
					alert.setHeaderText("Registration Error");
					alert.setContentText("Error: You didn't insert Name of your Band. Retry!");

					alert.showAndWait();

				} else {

					RegisterDAO registerDAO = new RegisterDAO();
					AutenthicatedUser user = new AutenthicatedUser();
					user.setUsername(usernameField.getText());
					user.setPassword(passwordField.getText());
					user.setEmail(emailField.getText());
					user.setFirstname(firstNameField.getText());
					user.setLastname(lastNameField.getText());

					String subsDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

					user.setSubsDate(subsDate);

					String birthDate = birthDateField.getValue().toString();

					user.setBirthDate(birthDate);

					user.setZone(zoneField.getText());
					user.setInstrPlayed(instrPlayedField.getText());

					if (bandField.isSelected() && nameBandField.getText().equals("") == false) {
						user.setBand(1);
						user.setNameBand(nameBandField.getText());
					} else {
						user.setBand(0);
						user.setNameBand(null);
					}

					String result = registerDAO.checkUsername(usernameField.getText());

					if (result.equals("trovato")) {

						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Social Music");
						alert.setHeaderText("Registration Error");
						alert.setContentText("Error: Username already in use. Retry!");

						usernameField.clear();

						alert.showAndWait();

					} else {

						registerDAO.insertUtente(user);

						usernameField.clear();
						passwordField.clear();
						emailField.clear();
						firstNameField.clear();
						lastNameField.clear();
						birthDateField.setValue(null);
						zoneField.clear();
						instrPlayedField.clear();
						bandField.setSelected(false);
						nameBandField.clear();

						win.loadLoginPage();
					}
				}
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadLoginPage();
			}

		});

		hb1.getChildren().addAll(usernameField, passwordField);
		hb2.getChildren().addAll(emailField);
		hb3.getChildren().addAll(firstNameField, lastNameField);
		hb4.getChildren().addAll(zoneField, instrPlayedField);
		hb5.getChildren().addAll(band, bandField, nameBandField);
		hb6.getChildren().addAll(birth, birthDateField);

		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb3.setAlignment(Pos.CENTER);
		hb4.setAlignment(Pos.CENTER);
		hb5.setAlignment(Pos.CENTER);
		hb6.setAlignment(Pos.CENTER);

		root.getChildren().addAll(title, hb1, hb2, hb3, hb4, hb5, hb6, registerBTN, backBTN);
		root.setAlignment(Pos.CENTER);

		return root;

	}
}
