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

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
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
	public static final String THERAPYVIEW2 = "therapy2";
	public static final String THERAPYVIEW3 = "therapy3";
	public static final String MEDICATION = "medication";

	private static Navigator navigator;
	private static String previousView;

	private ControllerLogin loginController;
	private ControllerTherapy therapyController;

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
		navigator.addView(LOGINVIEW, new Login(loginController));
		navigator.addView(THERAPYVIEW, new TherapyView(therapyController));
		navigator.addView(THERAPYVIEW3, new TherapyView3(therapyController));
		navigator.addView(HOMEVIEW, new HomeView());
		navigator.addView(MEDICATION, new Medication());
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

	// public static void navigateToHome()
	// {
	// //navigator.addView(HOMEVIEW, new HomeView());
	// previousView = navigator.getState();
	// navigator.navigateTo(HOMEVIEW);
	//
	// }

	public void performLogout() {
		previousView = navigator.getState();
		navigator.navigateTo(LOGINVIEW);
		// navigator.removeView(HOMEVIEW);

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
