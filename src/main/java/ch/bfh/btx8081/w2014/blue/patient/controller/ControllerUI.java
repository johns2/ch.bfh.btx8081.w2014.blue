/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.controller;

import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2014.blue.patient.database.XmlFileReader;
import ch.bfh.btx8081.w2014.blue.patient.gui.HomeView;
import ch.bfh.btx8081.w2014.blue.patient.gui.Login;
import ch.bfh.btx8081.w2014.blue.patient.gui.Medication;
import ch.bfh.btx8081.w2014.blue.patient.gui.TherapyView;
import ch.bfh.btx8081.w2014.blue.patient.gui.TherapyView3;
import ch.bfh.btx8081.w2014.blue.patient.model.UserData;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * @author Pira
 *
 */
@SuppressWarnings("serial")
public class ControllerUI extends UI {
	public static final String HOMEVIEW = "home";
	public static final String LOGINVIEW = "login";
	public static final String THERAPYVIEW = "therapy";
	public static final String THERAPYVIEW3 = "therapy3";
	public static String getHomeview() {
		return HOMEVIEW;
	}

	public static String getLoginview() {
		return LOGINVIEW;
	}

	public static String getTherapyview() {
		return THERAPYVIEW;
	}

	public static String getTherapyview3() {
		return THERAPYVIEW3;
	}

	public static String getMedication() {
		return MEDICATION;
	}

	public static final String MEDICATION = "medication";

	private static Navigator navigator;
	private static String previousView;

	private ControllerLogin loginController;
	private ControllerTherapy therapyController;
	private ControllerMedication medicationController;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ControllerUI.class, widgetset = "ch.bfh.btx8081.w2014.blue.patient.gui.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		getSession().setAttribute("user", null);
		navigator = new Navigator(this, this);
		loginController = new ControllerLogin(this);
		therapyController = new ControllerTherapy(XmlFileReader.getTherapies(),
				null, null);
		medicationController=new ControllerMedication(XmlFileReader.getMedication
				(new UserData("Patient1","111")));
		navigator.addView(LOGINVIEW, new Login(loginController));
		navigator.addView(THERAPYVIEW, new TherapyView(loginController, therapyController));
		navigator.addView(THERAPYVIEW3, new TherapyView3(loginController, therapyController));
		navigator.addView(HOMEVIEW, new HomeView(loginController));
		navigator.addView(MEDICATION, new Medication(loginController, medicationController));
		navigateTo(LOGINVIEW);
	}

	/**
	 * 
	 * @param view
	 * 
	 */
	public static void navigateTo(String view) {
		navigator.navigateTo(view);
	}

	public void performLogout() {
		previousView = navigator.getState();
		navigator.navigateTo(LOGINVIEW);
	}

	/**
	 * 
	 * @return
	 */
	public static String getPreviousView() {
		return previousView;
	}

	public ControllerLogin getLoginController() {
		return loginController;
	}

}
