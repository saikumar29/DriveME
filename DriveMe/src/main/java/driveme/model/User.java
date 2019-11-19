package driveme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "contatcNumber")
	private String contatcNumber;

	@Column(name = "driving_license_number")
	private String driving_license_number;

	@Column(name = "usr_password")
	private String usr_password;

	@Column(name = "usr_name")
	private String usr_name;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContatcNumber() {
		return contatcNumber;
	}

	public void setContatcNumber(String contatcNumber) {
		this.contatcNumber = contatcNumber;
	}

	public String getDriving_license_number() {
		return driving_license_number;
	}

	public void setDriving_license_number(String driving_license_number) {
		this.driving_license_number = driving_license_number;
	}

	public String getUsr_password() {
		return usr_password;
	}

	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}

	public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contatcNumber=" + contatcNumber + ", driving_license_number=" + driving_license_number
				+ ", usr_password=" + usr_password + ", usr_name=" + usr_name + "]";
	}

}
