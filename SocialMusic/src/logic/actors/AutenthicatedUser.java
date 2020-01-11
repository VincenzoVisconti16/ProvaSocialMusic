package logic.actors;

import java.time.LocalDate;
import java.util.Date;

public class AutenthicatedUser {

	private int idUtente;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private Date subsDate;
	private Date birthDate;
	private String zone;
	private String instrPlayed;
	private Boolean band;
	private String nameBand;
	
	
	/*public AutenthicatedUser(int idUtente, String username, String password, String email, String firstname, String lastname, Date subsDate, Date birthDate, String zone, String instrPlayed, Boolean band, String nameBand) {
		
		this.idUtente = idUtente;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.subsDate = subsDate;
		this.birthDate = birthDate;
		this.zone = zone;
		this.instrPlayed = instrPlayed;
		this.band = band;
		this.nameBand = nameBand;
		
	}*/
	
	public AutenthicatedUser() {
		
	}

	public AutenthicatedUser(int idUtente2, String username2, String password2, String email2, String firstname2,
			String lastname2, Date subsDate2, Date birthDate2, String zone2, String instrPlayed2, Boolean band2,
			String nameBand2) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return idUtente;
	}
	public void setId(int idUtente) {
		this.idUtente = idUtente;
	}
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
	
	public Date getSubsDate() {
		return subsDate;
	}
	
	public void setSubsDate(Date localDate) {
		this.subsDate = localDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public Boolean getBand() {
		return band;
	}

	public void setBand(Boolean band) {
		this.band = band;
	}

	public String getNameBand() {
		return nameBand;
	}

	public void setNameBand(String nameBand) {
		this.nameBand = nameBand;
	}
	
	/*public abstract void writeRules();
	public abstract void moderateUsers();*/
	
	
}
