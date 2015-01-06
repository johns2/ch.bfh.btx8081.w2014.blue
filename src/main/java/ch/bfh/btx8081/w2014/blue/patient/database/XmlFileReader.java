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

import com.vaadin.ui.Label;

import ch.bfh.btx8081.w2014.blue.patient.model.UserData;
import ch.bfh.btx8081.w2014.blue.patient.model.showMedication;
import ch.bfh.btx8081.w2014.blue.patient.model.showTherapy;

/**
 ** This class is used to read data from different XML-Files that are located on
 * the disk and used to persist data in our application. Offers static methods.
 **/
public class XmlFileReader {

	/**
	 ** Constants for the location and name of the XML Files that will be read by
	 * the application Where are the XML Files located?
	 **/
	private static final String USER_PATH = "XML/UserData.xml";
	private static final String MEDICATION_PATH = "XML/Medication.xml";
	private static final String THERAPY_PATH = "XML/Therapy.xml";

	/**
	 ** SAXBuilder, Document and Element from JDOM library and Java File object
	 * as attributes used in every reading method
	 **/
	private static SAXBuilder builder;
	private static File xmlFile;
	private static Document document;
	private static Element rootNode;

	/**
	 ** Returns a list of all the existing UserData in our system. UserData
	 * consists of a username and a password. If the reading process fails a
	 * custom DataAccessException will be thrown, with a message specifying the
	 * exact failure reason.
	 **/
	public static List<UserData> getUserData() {
		// initialize new user reading operation
		builder = new SAXBuilder();
		// use the specified path for the user xml file
		xmlFile = new File(USER_PATH);
		// critical section (may throw exceptions)
		try {
			// try to build a jdom document from the given xml File
			// this will work if the file exists and is well structured
			document = (Document) builder.build(xmlFile);
			// get the first (root) element of the xml file
			rootNode = document.getRootElement();

			// Create a list of all the XML Elements named users
			List<Element> users = rootNode.getChildren("users");
			// Create a list of UserData Objects that will be returned later
			List<UserData> retUser = new ArrayList<UserData>();
			// Loop throught the XML Elements, foreach element a UserData object
			// will be added to the list we will return later
			for (Element userElement : users) {
				// Mapping XML-File to Model Class
				UserData user = new UserData();
				// Take the text of the element called Username, set it in model
				// class
				user.setUsername(userElement.getChildText("Username"));
				// Take the text of the element called Password, set it in model
				// class
				user.setPassword(userElement.getChildText("Password"));
				// Add current Users to list
				retUser.add(user);
			}
			// return the List of userData
			return retUser;
		} catch (JDOMException e) {
			// We will end up here if the file is not well structured, not a
			// valid xmlFile
			// for debug purposes printStackTrace to console
			e.printStackTrace();
			// By passing on the exception to the method we determine the custom
			// Error Message
			// that will be added to the DataAccessException
			throwDataAccessException(e);
		} catch (IOException e) {
			// We will end up here if the file doesn't exist
			// for debug purposes printStackTrace to console
			e.printStackTrace();
			throwDataAccessException(e);
		} catch (Exception e) {
			// We end up here if an unknown error takes place
			e.printStackTrace();
			throwDataAccessException(e);
		}
		return null;
	}

	private static void throwDataAccessException(JDOMException e) {
		throw new DataAccessException("The specified File " + USER_PATH
				+ " does not have a valid xml format.");
	}

	private static void throwDataAccessException(IOException e) {
		throw new DataAccessException("The specified File " + USER_PATH
				+ " could not be found.");
	}

	private static void throwDataAccessException(Exception e) {
		throw new DataAccessException(
				"An unknown error occured. Please contact the administrator.");
	}

	/**
	 ** This method is used to load all therapies from the corresponding XML-File
	 * Will throw a DataAccessException if an error occurs.
	 **/
	public static List<showTherapy> getTherapies() {
		builder = new SAXBuilder();
		xmlFile = new File(THERAPY_PATH);
		try {
			// Create document from path
			document = (Document) builder.build(xmlFile);
			rootNode = document.getRootElement();

			// Get a list of all the XML Elements (therapy)
			// and create a list of showTherapy objects to return later on
			// TODO Riza -> bitte showTherapy umbenennen, Klasse immer
			// Grossbuchstaben, Name sagt nichts aus (sprich aber mit deinem
			// Team darüber)
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
		} catch (JDOMException e) {
			// We will end up here if the file is not well structured, not a
			// valid xmlFile
			// for debug purposes printStackTrace to console
			e.printStackTrace();
			// By passing on the exception to the method we determine the custom
			// Error Message
			// that will be added to the DataAccessException
			throwDataAccessException(e);
		} catch (IOException e) {
			// We will end up here if the file doesn't exist
			// for debug purposes printStackTrace to console
			e.printStackTrace();
			throwDataAccessException(e);
		} catch (Exception e) {
			// We end up here if an unknown error takes place
			e.printStackTrace();
			throwDataAccessException(e);
		}
		return null;
	}

	/**
	 ** Method is used to get a list of the different Medications for a given
	 * User or null if the user does not currently have any medications
	 **/
	public static List<showMedication> getMedication(UserData patient) {
		builder = new SAXBuilder();
		xmlFile = new File(MEDICATION_PATH);

		try {

			// Create document from path
			document = (Document) builder.build(xmlFile);
			rootNode = document.getRootElement();

			// Create a list of all XML Elements that contain a patients
			// Medication
			List<Element> patientMedications = rootNode
					.getChildren("PatientMedication");
			for (Element patientMedication : patientMedications) {
				// Find the PatientMedication that belongs to the Patient we
				// want to find information for (is attribute of the
				// patientMedication element)
				if (patientMedication.getAttribute("username").equals(
						patient.getUsername())) {
					// We found the right element
					List<showMedication> medications = new ArrayList<showMedication>();
					// Read the medications for this patient, those are elements
					// of name Medication
					for (Element medicationElement : patientMedication
							.getChildren("Medication")) {
						// TODO Riza same as above
						showMedication medication = new showMedication();
						// Map xml data to model class, first the name
						medication.setName(medicationElement
								.getChildText("name"));
						// then the dosage
						medication.setDosage(Integer.parseInt(medicationElement
								.getChildText("dosage")));
						// then a description
						medication.setDescription(medicationElement
								.getChildText("description"));
						medications.add(medication);
					}
					// return the created array list of medications
					return medications;
				}
			}

		} catch (JDOMException e) {
			// We will end up here if the file is not well structured, not a
			// valid xmlFile
			// for debug purposes printStackTrace to console
			e.printStackTrace();
			// By passing on the exception to the method we determine the custom
			// Error Message
			// that will be added to the DataAccessException
			throwDataAccessException(e);
		} catch (IOException e) {
			// We will end up here if the file doesn't exist
			// for debug purposes printStackTrace to console
			e.printStackTrace();
			throwDataAccessException(e);
		} catch (Exception e) {
			// We end up here if an unknown error takes place
			e.printStackTrace();
			throwDataAccessException(e);
		}
		// if the medication for a user has not been found return null
		return null;
	}

	public static void main(String[] args) {
		for (showTherapy s : XmlFileReader.getTherapies()) {

			System.out.println(new Label(s.getName()));
		}
	}
}
