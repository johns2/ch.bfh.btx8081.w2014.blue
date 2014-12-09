package ch.bfh.btx8081.w2014.blue.patient.model;

/**
 * 
 * @author R. Ramsauer
 */
public class Medication {
	
	private String name;
	private int dosage;
	private String description;
	
	public Medication() {
		
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
