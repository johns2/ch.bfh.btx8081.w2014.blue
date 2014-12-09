package ch.bfh.btx8081.w2014.blue.patient.database;

/**
 * 
 * @author R. Ramsauer
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import ch.bfh.btx8081.w2014.blue.patient.model.Medication;
import ch.bfh.btx8081.w2014.blue.patient.model.Patient;
import ch.bfh.btx8081.w2014.blue.patient.model.Therapy;

/**
 * 
 * @author R. Ramsauer
 */
public class XmlFileReader {

	private static final String MEDICATION_PATH = "Medication.xml";
	private static final String THERAPY_PATH = "Therapy.xml";

	public static List<Therapy> getTherapies() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(MEDICATION_PATH);

		try {

			// Create document from path
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();

			// Get list of all Therapies
			List<Element> therapies = rootNode.getChildren("therapy");
			List<Therapy> retTherapies = new ArrayList<Therapy>();
			for (Element therapyElement : therapies) {
				// Mapping XML-File to Model Class
				Therapy therapy = new Therapy();
				therapy.setName(therapyElement.getChildText("name"));
				therapy.setDescription(therapyElement
						.getChildText("description"));
				therapy.setPurpose(therapyElement.getChildText("purpose"));
				// Add current Therapy to list
				retTherapies.add(therapy);
			}
			return retTherapies;
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return null;
	}

	public static List<Medication> getMedication(Patient patient) {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(MEDICATION_PATH);

		try {

			// Create document from path
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();

			// Get list of all PatientMedications
			List<Element> patientMedications = rootNode
					.getChildren("PatientMedication");
			for (Element patientMedication : patientMedications) {
				// Find the PatientMedication that belongs to the Patient we
				// want to find information for
				if (patientMedication.getAttribute("username").equals(
						patient.getUsername())) {
					List<Medication> medications = new ArrayList<Medication>();
					// Read the medications for a patient
					for (Element medicationElement : patientMedication
							.getChildren("Medication")) {
						Medication medication = new Medication();
						// Map xml data to model class
						medication.setName(medicationElement
								.getChildText("name"));
						medication.setDosage(Integer.parseInt(medicationElement
								.getChildText("dosage")));
						medication.setDescription(medicationElement
								.getChildText("dosage"));
						medications.add(medication);
					}
					// return the created array list of medications
					return medications;
				}
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		// If the reading process was unsuccessful return null
		return null;
	}

}
