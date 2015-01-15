/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;


import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerMedication;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

/**
 * Creates a new <code>HomeView</code> instance, that contains three buttons in
 * order to see mediations, Therapy and to log out.
 * 
 * @author Amin
 *
 */
@SuppressWarnings("serial")
public class HomeView extends VerticalLayout implements View {

	
	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private Button medicationButton;
	private Button therapyButton;
	private Button logoutButton;
	private PatientMainDesign design;
	private Table medicationSummaryTable;
	private Table therapySummaryTable;
	 

	/**
	 * construct the Home view with two buttons.
	 */
	public HomeView() {
		
		design = new PatientMainDesign(this);
		layout = design.getLayout();
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

				ControllerUI.navigateTo(ControllerUI.MEDICATION);

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

		design.setTitleLabel("Home");
		verticalLayout = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout, "top:80.0px;left:30.0px;");

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

		prepareTextMedicationArea();
		
		verticalLayout.addComponent(medicationSummaryTable);
		verticalLayout.setComponentAlignment(medicationSummaryTable,
				Alignment.TOP_CENTER);

		// common part: create Button for Medication
		medicationButton = new Button("Medication Details");
		medicationButton.setIcon(FontAwesome.MEDKIT);
		medicationButton.setImmediate(true);
		medicationButton.setWidth("70%");
		medicationButton.setHeight("-8px");
		verticalLayout.addComponent(medicationButton);
		verticalLayout.setComponentAlignment(medicationButton,
				Alignment.MIDDLE_CENTER);

		
		prepareTherapyTextArea();
		verticalLayout.addComponent(therapySummaryTable);
		verticalLayout.setComponentAlignment(therapySummaryTable,
				Alignment.MIDDLE_CENTER);
		// common part: create Button for Therapy
		therapyButton = new Button("Therapy Details");
		therapyButton.setIcon(FontAwesome.USER_MD);
		therapyButton.setImmediate(true);
		therapyButton.setWidth("70%");
		therapyButton.setHeight("-8px");
		verticalLayout.addComponent(therapyButton);
		verticalLayout.setComponentAlignment(therapyButton,
				Alignment.BOTTOM_CENTER);

		logoutButton = new Button("Logout");
		logoutButton.setIcon(FontAwesome.SIGN_OUT);
		logoutButton.setImmediate(true);
		logoutButton.setWidth("50%");
		logoutButton.setHeight("-5px");
		verticalLayout.addComponent(logoutButton);
		verticalLayout.setComponentAlignment(logoutButton,
				Alignment.BOTTOM_CENTER);

		return verticalLayout;
	}

	
	/**
	 * fill out TherapyTextArea with therapyNames
	 */
	private void prepareTherapyTextArea(){
		
		
		therapySummaryTable=new Table();
		therapySummaryTable.setPageLength(4);
		therapySummaryTable.addContainerProperty("Therapy Summary", String.class, null);
		
		for(String str: TherapyView.therapyNames){
			therapySummaryTable.addItem(new Object[]{str},null);
		}
	}
	
	/**
	 * to fillout the textMedicationArea with medications names.
	 */
	private void prepareTextMedicationArea(){
		
	medicationSummaryTable=new Table();
	medicationSummaryTable.setPageLength(3);
	
	medicationSummaryTable.addContainerProperty("Medication Summary", String.class, null);
		
		for(String str: ControllerMedication.getMedicationNames()){
			medicationSummaryTable.addItem(new Object[]{str},null);
		}
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		

	}

}
