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

	private List<MedicationModel> Medications;
	private Medication medication;
	private ArrayList<String> medicationNames = new ArrayList<String>();
	private ArrayList<String> medicationDosages = new ArrayList<String>();
	private ArrayList<String> medicationDescriptions = new ArrayList<String>();
	private ArrayList<String> medicationDays = new ArrayList<String>();
	private ArrayList<String> medicationTime = new ArrayList<String>();

	public ControllerMedication(List<MedicationModel> list, Medication medication) {
		this.Medications = list;
		this.medication = medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	
	/**
	 * Returns the names of the medication
	 * 
	 * @return medicationNames in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getMedicationNames() {
		for (MedicationModel medication : Medications) {
			medicationNames.add(medication.getName());
		}
		return medicationNames;
	}
	
	//**
	
	
	/**
	 * Returns the dosage of the medication
	 * 
	 * @return medicationDosages in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getMedicationDosages() {
		for (MedicationModel medication : Medications) {
			medicationDosages.add(medication.getName());
		}
		return medicationDosages;
	}
	
	
	/**
	 * Returns the description of the medication
	 * 
	 * @return medicationDescriptions in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getMedicationDescriptions() {
		for (MedicationModel medication : Medications) {
			medicationDescriptions.add(medication.getDescription());
		}
		return medicationDescriptions;
	}
	
	/**
	 * Returns the day of the medication
	 * 
	 * @return medicationDay in a <code>ArrayList</code><String>
	 */
	/*
	public ArrayList<String> getMedicationDays() {
		for (MedicationModel medication : Medications) {
			medicationDays.add(medication.getDay());
		}
		return medicationDays;
	}
	*/

}

