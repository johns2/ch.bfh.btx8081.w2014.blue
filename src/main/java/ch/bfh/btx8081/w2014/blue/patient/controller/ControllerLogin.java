package ch.bfh.btx8081.w2014.blue.patient.controller;

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

public class ControllerLogin {

	private UI ControllerUI;
	private Authenticator authenticator;

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
		if (authenticator.authenticate() == true) {
			// Navigate to main view after a successful login
			ControllerUI.getNavigator().navigateTo(ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI.getHomeview());
			authenticator.setValidSession();
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
		ControllerUI.getNavigator().navigateTo(ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI.getLoginview());
		authenticator.unsetValidSession();
	}
	
	/**
	 * Check, if a valid session is open or not. 
	 * If not, the user is not permitted to view something.
	 */
	public Boolean checkPermission(){
		if (authenticator.getIsValid()){
			return true;
		} else {
			return false;
		}
	}
}
