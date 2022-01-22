package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int IdUser;
	private String FirstName;
	private String LastName;

	/**
	 * @return IdUser
	 */
	public int getIdUser() {
		return IdUser;
	}

	/**
	 * @param idUser
	 */
	public void setIdUser(int idUser) {
		IdUser = idUser;
	}

	/**
	 * @return FirstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "User{" + "IdUser=" + IdUser + ", FirstName='" + FirstName + '\'' + ", LastName='" + LastName + '\''
				+ '}';
	}
}
