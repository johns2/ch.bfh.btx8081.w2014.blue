package ch.bfh.btx8081.w2014.blue.patient.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import ch.bfh.btx8081.w2014.blue.patient.model.UserData;

/**
 * Manages and provides Controller with Entities from Database
 * @author R. Ramsauer
 */
public class EntityManager {
	
	// JDBC Connection
	private Connection connection;
	private final String username = "";
	private final String password ="";
	
	public EntityManager() {
		try {
			connection = DriverManager.getConnection(
			        "jdbc:myDriver:myDatabase",
			        username,
			        password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UserData> getPatients() {
		return null;
	}

}
