package ch.bfh.btx8081.w2014.blue.patient.model;

import java.util.List;

import ch.bfh.btx8081.w2014.blue.patient.database.XmlFileReader;

/**
 * 
 * @author R. Ramsauer
 */

public class TherapyModel {
	
	private String name;
	private String description;
	private String purpose;
	
	public List<TaskModel> getTasks() {
		return XmlFileReader.getTasks();
	}

	public TherapyModel(String name, String description, String purpose) {
		this.name = name;
		this.description = description;
		this.purpose = purpose;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	

}
