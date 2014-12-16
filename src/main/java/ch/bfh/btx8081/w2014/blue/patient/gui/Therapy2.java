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
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;



/**
 * @author Michel
 *
 */

@SuppressWarnings("serial")
public class Therapy2 extends VerticalLayout implements View{
    
    	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private PatientMainDesign design;
	protected Button buttonNext2;
	protected TextField therapyName;
	protected TextArea doctorNotes;

	
	/**
	 * Constructs a THERAPYVIEW on the base of different parameters.
	 * 
	 * 
	 */
	
	public Therapy2()

	{
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		buildVerticalLayout_22();
		createLayout();
	}
	
	/**
	 * create a layout and add this new layout at the mainLayout. the title
	 * of this layout will be defined.
	 */
	
	
	private void createLayout() {

		design.setTitleLabel("Therapy");
		// verticalLayout_1
		verticalLayout = buildVerticalLayout_22();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");

	}

	
	
	/**
	 * Builds the verticallayout and defines the size. Edits the
	 * verticallayout by adding the application logo, 
	 */
	
	private VerticalLayout buildVerticalLayout_22() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);
	
	
	// Textfield for TherayTitleName
		
	therapyName = new TextField ("Therapy Title:");
				
	therapyName.setWidth("80%");
	therapyName.setHeight("-1px");
	therapyName.setRequired(true);
	therapyName.setImmediate(true);
	verticalLayout.addComponent(therapyName);
	verticalLayout.setComponentAlignment(therapyName,Alignment.TOP_CENTER);
		

	// Textarea for TherapyNotes
	
	doctorNotes = new TextArea ("Doctor Notes:");
			
	doctorNotes.setWidth("80%");
	doctorNotes.setHeight("-1px");
	doctorNotes.setRequired(true);
	doctorNotes.setImmediate(true);
	doctorNotes.setRows(8);
	verticalLayout.addComponent(doctorNotes);
	verticalLayout.setComponentAlignment(doctorNotes,Alignment.MIDDLE_CENTER);


	
	// Button for Next
	
	buttonNext2 = new Button ("Next");
	buttonNext2.setIcon(FontAwesome.ARROW_CIRCLE_O_RIGHT);
	buttonNext2.addClickListener(new Button.ClickListener() {

		@Override
		public void buttonClick(ClickEvent event) {
			ControllerUI.navigateTo(ControllerUI.THERAPYVIEW3);

		}
	});
	
	verticalLayout.addComponent(buttonNext2);
	verticalLayout.setComponentAlignment(buttonNext2,Alignment.BOTTOM_CENTER);
	
	
	return verticalLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
	    
	}
    


}

