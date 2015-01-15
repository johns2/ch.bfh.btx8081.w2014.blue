/**	
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerLogin;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerMedication;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;
import ch.bfh.btx8081.w2014.blue.patient.model.MedicationModel;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * @author Sabine
 *
 *
 */
public class Medication extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8877988983449185624L;
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private ComboBox calendarList;
	private Button homeButton;
	private PatientMainDesign design;
	private ControllerLogin loginController;
	private Table medicationsTable;
	private ControllerMedication controllerMedication;

	/**
	 * Constructs a MEDICATIONVIEW on the base of different parameters.
	 */

	public Medication(ControllerLogin loginController, ControllerMedication controllerMedication) {
		this.loginController = loginController;
		this.controllerMedication = controllerMedication;
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		createLayout();
	}

	/**
	 * create a layout and add this new layout at the mainLayout. the title of
	 * this layout will be defined.
	 */

	private void createLayout() {
		design.setTitleLabel("Medication");
		verticalLayout = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout, "top:80.0px;left:30.0px;");

	}

	/**
	 * Builds the verticallayout and defines the size.
	 */

	private VerticalLayout buildVerticalLayout_1() {
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		createComboBox();

		verticalLayout.addComponent(calendarList);
		verticalLayout
				.setComponentAlignment(calendarList, Alignment.TOP_CENTER);

		medicationsTable = new Table("Please select a day");
		medicationsTable.addContainerProperty("Medication", String.class, null);
		medicationsTable.addContainerProperty("Dosage", Integer.class, null);
		medicationsTable.addContainerProperty("Time", String.class, null);
		medicationsTable.setPageLength(0);
		verticalLayout.addComponent(medicationsTable);
		verticalLayout.setComponentAlignment(medicationsTable,
				Alignment.TOP_CENTER);

		/**
		 * Button to get back to the HOMEVIEW
		 */

		homeButton = new Button("Home");
		homeButton.setIcon(FontAwesome.HOME);
		homeButton.setImmediate(true);
		homeButton.setWidth("50%");
		homeButton.setHeight("-5px");
		homeButton.addClickListener(new Button.ClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				ControllerUI.navigateTo(ControllerUI.HOMEVIEW);

			}
		});
		verticalLayout.addComponent(homeButton);
		verticalLayout.setComponentAlignment(homeButton,
				Alignment.BOTTOM_CENTER);

		return verticalLayout;

	}

	/**
	 * ComboBox for a list of days
	 */
	private void createComboBox() {

		calendarList = new ComboBox();
		calendarList.setInputPrompt("Select a Day");
		calendarList.setHeight("-1");
		calendarList.setNewItemsAllowed(true);
		calendarList.setImmediate(true);
		calendarList.setNullSelectionAllowed(false);

		for (String day : controllerMedication.getMedicationDays()) {
			calendarList.addItem(day);
		}
		calendarList.setNewItemsAllowed(false);
	}

	/**
	 * 
	 * @param day
	 */
	private void createMedicationTable(String day) {

		
		medicationsTable.removeAllItems();

		for (MedicationModel medication : controllerMedication
				.getMedicationsList()) {

			if (day.equals(medication.getDay())) {

				medicationsTable.addItem(new Object[] { medication.getName(),
						medication.getDosage(), medication.getTime() }, null);

			}

		}
		medicationsTable.setPageLength(0);
	}

	public void enter(ViewChangeEvent event) {
		if (loginController.checkPermission() == false){
			loginController.doLogout();
		};
		calendarList.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				String day = calendarList.getValue().toString();
				createMedicationTable(day);

			}
		});

	}

}
