package ch.bfh.btx8081.w2014.blue.patient.controller;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2014.blue.patient.gui.Medication;
import ch.bfh.btx8081.w2014.blue.patient.model.MedicationModel;


/**
 * 
 * @author Sabine Martin, marts1
 *
 */
public class ControllerMedication {

	private static List<MedicationModel> medications;
	private static ArrayList<String> medicationNames = new ArrayList<String>();
	private ArrayList<Integer> medicationDosages = new ArrayList<Integer>();
	private ArrayList<String> medicationDescriptions = new ArrayList<String>();
	private ArrayList<String> medicationDays = new ArrayList<String>();
	private ArrayList<String> medicationTime = new ArrayList<String>();

	/**
	 * construct a ControllerMedication with a List of MedicalModel
	 * @param list
	 */
	public ControllerMedication(List<MedicationModel> list) {
		this.medications = list;
		//this.medication = medication;
	}

	
	
	
	/**
	 * Returns the names of the medication
	 * 
	 * @return medicationNames in a <code>ArrayList</code><String>
	 */
	public static ArrayList<String> getMedicationNames() {
		for (MedicationModel medication : medications) {
			medicationNames.add(medication.getName());
		}
		return medicationNames;
	}
	
	
	
	/**
	 * Returns the dosage of the medication
	 * 
	 * @return medicationDosages in a <code>ArrayList</code><String>
	 */
	public ArrayList<Integer> getMedicationDosages() {
		for (MedicationModel medication : medications) {
			medicationDosages.add(medication.getDosage());
		}
		return medicationDosages;
	}
	
	
	/**
	 * Returns the description of the medication
	 * 
	 * @return medicationDescriptions in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getMedicationDescriptions() {
		for (MedicationModel medication : medications) {
			medicationDescriptions.add(medication.getDescription());
		}
		return medicationDescriptions;
	}
	
	/**
	 * Returns the day of the medication
	 * 
	 * @return medicationDay in a <code>ArrayList</code><String>
	 */
	
	public ArrayList<String> getMedicationDays() {
		for (MedicationModel medication : medications) {
			if(medicationDays.contains(medication)) continue;
			else medicationDays.add(medication.getDay());
		}
		return medicationDays;
	}

	/**
	 * Returns the time of the medication
	 *  @return medicationTime in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getMedicationTime() {
		
		for(MedicationModel medication :medications)
		{
			medicationTime.add(medication.getTime());
		}
		return medicationTime;
	}

	public void setMedicationTime(ArrayList<String> medicationTime) {
		this.medicationTime = medicationTime;
		
		
	}
	
	/**
	 * 
	 * @return the a list of medications
	 */
	public List<MedicationModel> getMedicationsList(){
		return medications;
	}
	

}

