package ch.bfh.btx8081.w2014.blue.patient.gui;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerLogin;

import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page.Styles;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Pira
 *
 */
@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private HorizontalLayout horizontalLayout_1;
	private VerticalLayout upperVerticalLayout;
	protected Button homeButton;
	private VerticalLayout verticalLayout;
	private PasswordField passwordField;
	private TextField userField;
	private PatientMainDesign design;
	private ControllerLogin loginController;
	private Styles style;

	/**
	 * Constructs a LOGINVIEW on the base of different parameters.
	 * 
	 * 
	 */

	public Login(ControllerLogin loginController)

	{

		this.loginController = loginController;		
		design = new PatientMainDesign(this);
		style=design.getStyles();
		createCssForButton();
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		
		horizontalLayout_1 = design.getLowerHorizontalLayout();
		upperVerticalLayout = design.getUpperVerticalLayout();
		buildHorizontalLayout_1();
		createLayout();
	}

	/**
	 * create a layout and add this new layout at the mainLayout. the title of
	 * this layout will be defined.
	 */

	private void createLayout() {

		design.setTitleLabel("MHC-Patient");
		verticalLayout = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");

	}

	/**
	 * overridden method of the interface view.
	 */
	public void enter(ViewChangeEvent event) {
		userField.setInputPrompt("Your username (eg. name@bfh.ch)");
		passwordField.setValue(null);

	}

	/**
	 * Builds the verticallayout and defines the size.
	 */
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		// textField_1 for insert the Username

		userField = new TextField(" Username:");
		userField.setIcon(FontAwesome.USER);
		userField.setImmediate(true);
		userField.setRequired(true);
		userField.setWidth("80%");
		userField.setHeight("-1px");
		// userField.addValidator(new EmailValidator(
		// "False Username, Username must be an email address"));
		userField.setInvalidAllowed(false);
		verticalLayout.addComponent(userField);
		verticalLayout
				.setComponentAlignment(userField, Alignment.BOTTOM_CENTER);

		// passwordField_1 for insert the Password
		passwordField = new PasswordField("Password: ");
		passwordField.setIcon(FontAwesome.KEY);
		passwordField.setImmediate(false);
		passwordField.setWidth("80%");
		passwordField.setHeight("-1px");
		verticalLayout.addComponent(passwordField);
		verticalLayout.setComponentAlignment(passwordField,
				Alignment.MIDDLE_CENTER);

		passwordField.setRequired(true);
		passwordField.setValue("");
		passwordField.setNullRepresentation("");

		return verticalLayout;
	}

	/**
	 * HorizontalLayout use by adding a button to log in. The button navigates
	 * to the HOMEVIEW.
	 */
	private void buildHorizontalLayout_1() {

		homeButton = new Button();
		homeButton.setHeight("0px");
		homeButton.addStyleName("icons");
		homeButton.setIcon(FontAwesome.SIGN_IN);
		homeButton.setImmediate(true);
		//homeButton.setWidth("100px");
		//homeButton.setHeight("-10px");
		
		
		
		horizontalLayout_1.addComponent(homeButton);
		horizontalLayout_1.setComponentAlignment(homeButton,
				Alignment.TOP_CENTER);
		homeButton.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				//
				// Validate the fields using the navigator. By using validors
				// for the
				// fields we reduce the amount of queries we have to use to the
				// database
				// for wrongly entered passwords
				//
				if (!userField.isValid() || !passwordField.isValid()) {
					return;
				}
				loginController.doLogin(userField.getValue(),
						passwordField.getValue());
				if (loginController.getIsAuthenticated() == false) {
					// Wrong password clear the password field and refocuses it
					passwordField.setValue(null);
					passwordField.focus();
				}
			}
		});

	}

	// Validator for validating the passwords
	private static final class PasswordValidator extends
			AbstractValidator<String> {

		public PasswordValidator() {
			super("The password provided is not valid");
		}

		@Override
		protected boolean isValidValue(String value) {
			//
			// Password must be at least 8 characters long and contain at least
			// one number
			//
			if (value != null
					&& (value.length() < 8 || !value.matches(".*\\d.*"))) {
				return false;
			}
			return true;
		}

		@Override
		public Class<String> getType() {
			return String.class;
		}
	}
	
	
	private void createCssForButton(){
		
		
		style.add(".icons .v-icon{"
				+ "font-size: 30pt;"
				+ ""
				+ "}"
				+ ".icons .v-button-wrap{"
				+ "background:#87CEEB;"
				+ "display:block;"
				+ "padding:0;"
				+"}"
				);
		
	}

	// public void NavigateToHome() {
	// ControllerUI.navigateToHome();
	// }
}
