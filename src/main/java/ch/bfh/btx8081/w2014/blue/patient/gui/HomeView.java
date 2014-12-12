/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;

import com.sun.jna.platform.unix.X11.Font;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.FontIcon;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * Creates a new <code>HomeView</code> instance, that contains three buttons in
 * order to see mediations, Therapy and to log out.
 * 
 * @author Amin
 *
 */
@SuppressWarnings("serial")
public class HomeView extends VerticalLayout implements View {

	/**
	 * 
	 */
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private Button medicationButton;
	private Button therapyButton;
	private Button logoutButton;
	private PatientMainDesign design;

	/**
	 * construct the Home view with two buttons.
	 */
	public HomeView() {
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		buildVerticalLayout_1();
		mainLayout = design.getMainLayout();
		createLayout();
		addActionListnerToButtons();

	}

	/**
	 * Add Listeners to Buttons
	 */
	private void addActionListnerToButtons() {
		medicationButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("Go to medication page");
				//ControllerUI.navigateTo(ControllerUI.MEDICATION);

			}
		});

		therapyButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// Notification.show("Go to Therapy page");
				ControllerUI.navigateTo(ControllerUI.THERAPYVIEW);

			}
		});

		logoutButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ControllerUI.navigateTo(ControllerUI.LOGINVIEW);

			}
		});
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
	 * Builds the verticallayout and defines the size.
	 */
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		layout.setImmediate(false);
		layout.setWidth("260px");
		layout.setHeight("360px");
		layout.setMargin(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		medicationButton = new Button("Medication");
		medicationButton.setIcon(FontAwesome.MEDKIT);
		verticalLayout.addComponent(medicationButton);
		verticalLayout.setComponentAlignment(medicationButton,
				Alignment.TOP_CENTER);

		therapyButton = new Button("Therapy");
		therapyButton.setIcon(FontAwesome.TH);
		verticalLayout.addComponent(therapyButton);
		verticalLayout.setComponentAlignment(therapyButton,
				Alignment.MIDDLE_CENTER);

		logoutButton = new Button("Logout");
		logoutButton.setIcon(FontAwesome.SIGN_OUT);
		verticalLayout.addComponent(logoutButton);
		verticalLayout.setComponentAlignment(logoutButton,
				Alignment.TOP_CENTER);

		return verticalLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
