package ch.bfh.btx8081.w2014.blue.patient.model;

/**
 * 
 * @author R. Ramsauer
 */

public class MedicationModel {
	
	private String name;
	private int dosage;
	private String description;
	private String day;
	private String time;
	
	/**
	 * construct a raw model from a Medication.
	 */
	public MedicationModel() {
		
	}
	/**
	 * 
	 * @return the day of medications use.
	 */
	public String getDay() {
		return day;
	}

	/**
	 * 
	 * @param day set the day of medications use.
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * 
	 * @return the time of medications use.
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 
	 * @param time set the time of medications use.
	 */
	public void setTime(String time) {
		this.time = time;
	}

	

	/**
	 * 
	 * @return the name of medication.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name set the name of medication.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the dosage of medication
	 */
	public int getDosage() {
		return dosage;
	}

	/**
	 * 
	 * @param dosage set the dosage of the medication
	 */
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	/**
	 * 
	 * @return the description of the medication.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description set the description of the medication.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
