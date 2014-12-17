package ch.bfh.btx8081.w2014.blue.patient.controller;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;

import ch.bfh.btx8081.w2014.blue.patient.model.Authenticator;

/**
 * 
 * This controller will perform a login due submitted credentials from a View
 * using the Authenticator Model
 * 
 * @author Stefan Johner, johns2@bfh.ch
 *
 */

public class ControllerLogin extends ControllerUI {

	private UI ControllerUI;
	private Boolean isAuthenticated;
	private Authenticator authenticator;

	public Boolean getIsAuthenticated() {
		return isAuthenticated;
	}

	public ControllerLogin(UI ControllerUI) {
		this.ControllerUI = ControllerUI;
		this.authenticator = new Authenticator(this.ControllerUI.getSession());
	}

	/**
	 * Performs a Login with the submitted credentials using the Authentificator
	 * Model
	 * 
	 * @param userField
	 * @param passwordField
	 */
	public void doLogin(String insertedUser, String insertedPassword) {
		authenticator.setUsername(insertedUser);
		authenticator.setPassword(insertedPassword);
		this.isAuthenticated = authenticator.authenticate();
		if (isAuthenticated == true) {

			// Navigate to main view after a successful login
			ControllerUI.getNavigator().navigateTo(HOMEVIEW);

		} else {
			doLogout();
		}
	}

	/**
	 * Performs a logout with setting null the "user" session variable.
	 * 
	 */
	public void doLogout() {
		// Navigate to login view after a logout
		ControllerUI.getNavigator().navigateTo(LOGINVIEW);
		ControllerUI.getSession().setAttribute("user", null);
	}
}
