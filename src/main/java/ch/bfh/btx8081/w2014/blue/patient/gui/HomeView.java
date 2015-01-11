/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerTherapy;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

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
	private TextArea textMedicationArea;
	private TextArea textTherapyArea;
	private Styles style;
	private ControllerTherapy therapyController;
	private Label medicationLabel;
	private Map<String, String> therapySummaryMap;
	 

	/**
	 * construct the Home view with two buttons.
	 */
	public HomeView() {
		style = Page.getCurrent().getStyles();
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

		// common part: create TextArea for MedicationSummary
		textMedicationArea = new TextArea("Medication Summary");
		setStyleForTextArea();
		textMedicationArea.setStyleName("textarea");

		textMedicationArea.setWidth("100%");
		textMedicationArea.setHeight("100px");
		textMedicationArea.setImmediate(true);

		verticalLayout.addComponent(textMedicationArea);
		verticalLayout.setComponentAlignment(textMedicationArea,
				Alignment.MIDDLE_CENTER);

		// common part: create Button for Medication
		medicationButton = new Button("Medication Details");
		medicationButton.setIcon(FontAwesome.MEDKIT);
		medicationButton.setImmediate(true);
		medicationButton.setWidth("100%");
		medicationButton.setHeight("-8px");
		verticalLayout.addComponent(medicationButton);
		verticalLayout.setComponentAlignment(medicationButton,
				Alignment.MIDDLE_CENTER);

		// common part: create TextArea for TherapySummary
		textTherapyArea = new TextArea("Therapy Summary");
		prepareTherapyTextArea();
		setStyleForTextArea();
		textTherapyArea.setStyleName("textarea");

		textTherapyArea.setWidth("100%");
		textTherapyArea.setHeight("100px");
		textTherapyArea.setImmediate(true);

		verticalLayout.addComponent(textTherapyArea);
		verticalLayout.setComponentAlignment(textTherapyArea,
				Alignment.MIDDLE_CENTER);
		// common part: create Button for Therapy
		therapyButton = new Button("Therapy Details");
		therapyButton.setIcon(FontAwesome.USER_MD);
		therapyButton.setImmediate(true);
		therapyButton.setWidth("100%");
		therapyButton.setHeight("-8px");
		verticalLayout.addComponent(therapyButton);
		verticalLayout.setComponentAlignment(therapyButton,
				Alignment.MIDDLE_CENTER);

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

	/*
	 * Create CSS for the Style
	 */
	private void setStyleForTextArea() {
		style.add(".textarea{" + " padding: 0.1cm !important;"
				+ "font-size: 40px;" + ";}");
	}
	
	/*
	 * fill out TherapyTextArea with therapyNames
	 */
	private void prepareTherapyTextArea(){
		
		String s1="";
		for(String str: TherapyView.therapyNames)
			{
			s1+=str+"\n";
			textTherapyArea.setValue(s1);
			}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		

	}

}
