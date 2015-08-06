package optimus.addressbook;
/*
 * public class Authentication
 * POJO for Authentication Table
 */
public class Authentication {

	/*
	 * Data Members
	 */
	long ID;
	String email;
	String password;
	String role;
	/*
	 * Getters & setters for Data members
	 */
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		this.ID = ID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
