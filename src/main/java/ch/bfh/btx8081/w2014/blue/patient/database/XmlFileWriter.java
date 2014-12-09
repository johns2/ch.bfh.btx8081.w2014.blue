package ch.bfh.btx8081.w2014.blue.patient.database;

/**
 * 
 * @author R. Ramsauer
 */

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import ch.bfh.btx8081.w2014.blue.patient.model.Patient;

public class XmlFileWriter {

	/**
	 * CONSTANTS FOR FILEPATH AND XML-TAG Names
	 */
	private static final String PATIENTS_ROOT = "patients";
	private static final String PATIENTS_ELEMENT = "patient";
	private static final String PATIENTS_ELEMENT_ID = "username";
	private static final String PATIENTS_PATH = "patients.xml";

	public static void writePatientXml(Patient patient) {

		try {
			// Create root element
			Element patients = new Element(PATIENTS_ROOT);
			// Create document with root
			Document doc = new Document(patients);
			doc.setRootElement(patients);

			// Create patient element -> Mapping Model.Patient class to XML
			Element pat = new Element(PATIENTS_ELEMENT);
			pat.setAttribute(new Attribute(PATIENTS_ELEMENT_ID, patient
					.getUsername()));
			pat.addContent(new Element("password").setText(patient
					.getPassword()));
			pat.addContent(new Element("emailAddress").setText(patient
					.getEmailaddress()));
			// Add Patient Element to Document
			doc.getRootElement().addContent(pat);

			//Write XML-File to disk
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(PATIENTS_PATH));

			System.out.println("File Saved!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}
}
