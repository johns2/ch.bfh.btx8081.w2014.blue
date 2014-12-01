package ch.bfh.btx8081.w2014.blue.patient.model;

/**
 * This class models a person with his informations ID and name
 * 
 * @author Stefan Johner, johns2@bfh.ch
 * 
 */

public class Person {
	private int userID;
	private String PersonName;
	
	public Person (int userID, String Name){
		this.userID = userID;
		this.PersonName = Name;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPersonName() {
		return this.PersonName;
	}

	public void setPersonName(String PersonName) {
		this.PersonName = PersonName;
	}

}
