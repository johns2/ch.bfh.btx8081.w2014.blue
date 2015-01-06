package ch.bfh.btx8081.w2014.blue.patient.model;

/**
 * 
 * @author R. Ramsauer
 */

public class MedicationModel {
	
	private String name;
	private int dosage;
	private String description;
	
	public MedicationModel() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
