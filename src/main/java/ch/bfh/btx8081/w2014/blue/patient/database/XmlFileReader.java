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

import ch.bfh.btx8081.w2014.blue.patient.model.UserData;
import ch.bfh.btx8081.w2014.blue.patient.model.showMedication;
import ch.bfh.btx8081.w2014.blue.patient.model.showTherapy;

public class XmlFileReader {

	private static final String USER_PATH = "XML/UserData.xml";
	private static final String MEDICATION_PATH = "XML/Medication.xml";
	private static final String THERAPY_PATH = "XML/Therapy.xml";
	
	public static List<UserData> getUserData() {
		
		
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(USER_PATH);
			// Create document from path
			Document document;
			try {
				document = (Document) builder.build(xmlFile);
				Element rootNode = document.getRootElement();

				// Get list of all User
				List<Element> users = rootNode.getChildren("User");
				List<UserData> retUser = new ArrayList<UserData>();
				for (Element userElement : users) {
					// Mapping XML-File to Model Class
					UserData user = new UserData();
					user.setUsername(userElement.getChildText("Username"));
					user.setPassword (userElement
							.getChildText("Password"));
					// Add current Users to list
					retUser.add(user);
				}
				return retUser;
			} catch (JDOMException e) {
				e.printStackTrace();
				throwDataAccessException(e);
			} catch (IOException e) {
				e.printStackTrace();
				throwDataAccessException(e);
			}
			return null;
	}
	
	private static void throwDataAccessException(JDOMException e) {
		throw new DataAccessException("The specified File " + USER_PATH + " does not have a valid xml format.");
	}
	
	private static void throwDataAccessException(IOException e) {
		throw new DataAccessException("The specified File " + USER_PATH + " could not be found.");
	}

	public static List<showTherapy> getTherapies() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(THERAPY_PATH);

		try {

			// Create document from path
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();

			// Get list of all Therapies
			List<Element> therapies = rootNode.getChildren("therapy");
			List<showTherapy> retTherapies = new ArrayList<showTherapy>();
			for (Element therapyElement : therapies) {
				// Mapping XML-File to Model Class
				showTherapy therapy = new showTherapy();
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

	public static List<showMedication> getMedication(UserData patient) {
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
					List<showMedication> medications = new ArrayList<showMedication>();
					// Read the medications for a patient
					for (Element medicationElement : patientMedication
							.getChildren("Medication")) {
						showMedication medication = new showMedication();
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
	
	public static void main(String[] args) {
//		List<UserData> li = XmlFileReader.getUserData();
//		 
//		for(UserData ausgabe : li)
//		{
//			System.out.println(ausgabe.getUsername());
//		}
		System.out.println(XmlFileReader.getUserData());
}}
