package ch.bfh.btx8081.w2014.blue.patient.gui;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Pira
 *
 */
@SuppressWarnings("serial")
public class Login extends VerticalLayout {


		final VerticalLayout layout;
		private AbsoluteLayout mainLayout;
		protected Button homeButton;
		private VerticalLayout verticalLayout;
		private PasswordField passwordField;
		private TextField userField;
		private PatientMainDesign design;

		/**
		 * Constructs a LOGINVIEW on the base of different parameters.
		 * 
		 * 
		 */

		public Login()

		{
			design = new PatientMainDesign(this);
			layout = design.getLayout();
			mainLayout = design.getMainLayout();
			buildVerticalLayout_1();
			createLayout();
		}

		/**
		 * create a layout and add this new layout at the mainLayout. the title
		 * of this layout will be defined.
		 */

		private void createLayout() {

			design.setTitleLabel("MHC-Patient");
			// verticalLayout_1
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
		 * Builds the verticallayout and defines the size. Edits the
		 * verticallayout by adding the application logo, textfield and a
		 * passwordfield.
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
			userField.setImmediate(true);
			userField.setRequired(true);
			userField.setWidth("80%");
			userField.setHeight("-1px");
			userField.addValidator(new EmailValidator(
					"Username must be an email address"));
			userField.setInvalidAllowed(false);
			verticalLayout.addComponent(userField);
			verticalLayout.setComponentAlignment(userField,
					Alignment.BOTTOM_CENTER);

			// passwordField_1 for insert the Password
			passwordField = new PasswordField("Password: ");
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

		
				
			

		
	}

