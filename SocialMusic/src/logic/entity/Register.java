package logic.entity;

import logic.dao.RegisterDAO;

public class Register {

	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String subsDate;
	private String birthDate;
	private String zone;
	private String instrPlayed;
	private int bandFlag;
	private String nameBand;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSubsDate() {
		return subsDate;
	}

	public void setSubsDate(String subsdate) {
		this.subsDate = subsdate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthdate) {
		this.birthDate = birthdate;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getInstrPlayed() {
		return instrPlayed;
	}

	public void setInstrPlayed(String instrPlayed) {
		this.instrPlayed = instrPlayed;
	}

	public int getBandFlag() {
		return bandFlag;
	}

	public void setBandFlag(int i) {
		this.bandFlag = i;
	}

	public String getNameBand() {
		return nameBand;
	}

	public void setNameBand(String nameBand) {
		this.nameBand = nameBand;
	}

	public String checkEmailAlreadyTaken() {

		RegisterDAO registerDAO = new RegisterDAO();
		String result = registerDAO.checkEmailAlreadyTaken(email);

		return result;
	}

	public String checkUsernameAlreadyTaken() {

		RegisterDAO registerDAO = new RegisterDAO();
		String result = registerDAO.checkUsernameAlreadyTaken(username);

		return result;
	}

	public void insertUtente(Register register) {
		
		RegisterDAO registerDAO = new RegisterDAO();
		registerDAO.insertUser(register);
		
	}
}
