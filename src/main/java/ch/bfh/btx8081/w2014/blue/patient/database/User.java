/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.database;


/**
 * @author Riza Ramsauer
 *
 */
public class User {
	private String name;
	private String password;


	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}


	public String getUsername() {
	
		return name;
	}

	public String getPassword() {
	
		return password;
	}
	
	

}
