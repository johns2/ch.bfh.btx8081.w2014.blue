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

	public ControllerLogin(UI ControllerUI) {
		this.ControllerUI = ControllerUI;
	}
	
	/**
	 * Performs a Login with the submitted credentials using the Authentificator Model
	 * @param userField
	 * @param passwordField
	 */
	public void doLogin(TextField userField, PasswordField passwordField) {
		Authenticator authenticator = new Authenticator();
		Boolean isAuthenticated = authenticator.authenticate(
				userField.getValue(), passwordField.getValue());
		if (isAuthenticated == true) {

			// Store the username in the session
			ControllerUI.getSession()
					.setAttribute("user", userField.getValue());
			
			// Navigate to main view after a successful login
			ControllerUI.getNavigator().navigateTo(HOMEVIEW);

		} else {
			ControllerUI.getSession().setAttribute("user", null);
			// Wrong password clear the password field and refocuses it
			passwordField.setValue(null);
			passwordField.focus();

		}
	}
}
