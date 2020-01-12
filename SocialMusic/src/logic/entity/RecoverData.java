package logic.entity;

import logic.dao.RecoverDataDAO;

public class RecoverData {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserNameByEmail() {

		RecoverDataDAO recoverDataDAO = new RecoverDataDAO();
		String username = recoverDataDAO.getUserNameByEmail(email);

		return username;
	}

	public String getPasswordByEmail() {

		RecoverDataDAO recoverDataDAO = new RecoverDataDAO();
		String password = recoverDataDAO.getPasswordByEmail(email);
		
		return password;
	}

	public String checkIfRegistered() {
		
		RecoverDataDAO recDataDAO = new RecoverDataDAO();
		String result = recDataDAO.checkEmail(email);
		
		return result;
	}

}
