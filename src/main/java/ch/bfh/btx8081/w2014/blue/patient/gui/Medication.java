/**	
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;

import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * @author Sabine
 *
 *
 */
public class Medication extends VerticalLayout implements View {


	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private ComboBox calendarList;
	private Button showInfoButton;
	private Button homeButton;
	private PatientMainDesign design;
	private Table medication;

	
	/**
	 * Constructs a MEDICATIONVIEW on the base of different parameters.
	 */
	
	public Medication()
	{
		//buildVerticalLayout_1();
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		createLayout();
	}
	
	
	/**
	 * create a layout and add this new layout at the mainLayout. the title
	 * of this layout will be defined.
	 */
	
	private void createLayout() {
		design.setTitleLabel("Medication");
		//medication=new Table ("medication");
		verticalLayout = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");
		
		

	}

	
	/**
	 * Builds the verticallayout and defines the size.
	 */
	
	private VerticalLayout buildVerticalLayout_1(){
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);
		
		
		/**
		 * ComboBox for a list of days
		 */

		calendarList = new ComboBox();
		calendarList.setInputPrompt("Select a Day");
		calendarList.setHeight("-1px");
		calendarList.setNewItemsAllowed(true);
		calendarList.setImmediate(true);
		calendarList.setNullSelectionAllowed(false);
		verticalLayout.addComponent(calendarList);
		verticalLayout.setComponentAlignment(calendarList, Alignment.TOP_CENTER);
		
		
		/**
		 * Button to confirm selected day
		 */
		
		showInfoButton = new Button("Show Medication");
		showInfoButton.setIcon(FontAwesome.INFO_CIRCLE);
		showInfoButton.setImmediate(true);
		showInfoButton.setWidth("80%");
		showInfoButton.setHeight("-1px");
		verticalLayout.addComponent(showInfoButton);
		verticalLayout.setComponentAlignment(showInfoButton, Alignment.TOP_CENTER);
		
		
		/**
		 * * Table for a list of medication for selected day
		 */
		
		medication=new Table ();
		medication.setWidth("100%");
		medication.setHeight("100%");
		medication.addContainerProperty("Medication", String.class, null);
		medication.addContainerProperty("Dosage", String.class,  null);
		medication.addContainerProperty("Time", String.class, null);
		Object cipralex = medication.addItem();
		Item row1 = medication.getItem(cipralex);
		row1.getItemProperty("Medication").setValue("Cipralex");
		verticalLayout.addComponent(medication);
		verticalLayout.setComponentAlignment(medication, Alignment.TOP_CENTER);
		//mainLayout.addComponent(medication);
		//mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");
		
		
		/**
		 * Button to get back to the HOMEVIEW
		 */
		
		homeButton = new Button("Home");
		homeButton.setIcon(FontAwesome.HOME);
		homeButton.setImmediate(true);
		homeButton.setWidth("80%");
		homeButton.setHeight("-1px");
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
		verticalLayout.setComponentAlignment(homeButton, Alignment.BOTTOM_CENTER);
		
		return verticalLayout;
		
	}
	
	
	public void enter(ViewChangeEvent event) {
		calendarList.removeAllItems();
		calendarList.addItems("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
	}
	
}
