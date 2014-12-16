/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;


import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;



/**
 * @author Michel
 *
 */
@SuppressWarnings("serial")
public class Therapy extends VerticalLayout implements View{
    
    	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private PatientMainDesign design;
	protected ComboBox therapyList;
	protected Button buttonNext1;

	
	/**
	 * Constructs a THERAPYVIEW on the base of different parameters.
	 * 
	 * 
	 */
	
	public Therapy()

	{
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		buildVerticalLayout_21();
		createLayout();
	}
	
	/**
	 * create a layout and add this new layout at the mainLayout. the title
	 * of this layout will be defined.
	 */
	
	
	private void createLayout() {

		design.setTitleLabel("Therapy");
		// verticalLayout_1
		verticalLayout = buildVerticalLayout_21();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");

	}

	
	
	
	/**
	 * Builds the verticallayout and defines the size. Edits the
	 * verticallayout by adding the application logo, 
	 */
	
	private VerticalLayout buildVerticalLayout_21() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		// Comobox for Therapies
		
		therapyList = new ComboBox ();
		
		therapyList.setWidth("80%");
		therapyList.setHeight("-1px");
		therapyList.setNewItemsAllowed(true);
		therapyList.setImmediate(true);
		therapyList.setNullSelectionAllowed(false);
		verticalLayout.addComponent(therapyList);
		verticalLayout.setComponentAlignment(therapyList,Alignment.TOP_CENTER);
		
		// Button for Next
		
		buttonNext1 = new Button ("Next");
		buttonNext1.setIcon(FontAwesome.ARROW_CIRCLE_O_RIGHT);
		buttonNext1.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ControllerUI.navigateTo(ControllerUI.THERAPYVIEW2);

			}
		});
		
		verticalLayout.addComponent(buttonNext1);
		verticalLayout.setComponentAlignment(buttonNext1,Alignment.MIDDLE_CENTER);
		
		return verticalLayout;
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
	    
	}
    
    

}