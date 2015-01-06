/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;


import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;
import ch.bfh.btx8081.w2014.blue.patient.database.XmlFileReader;
import ch.bfh.btx8081.w2014.blue.patient.model.TherapyModel;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.TabSheet;



/**
 * @author Michel
 * This Class creates the 1st page of the 
 * therapy section
 */
@SuppressWarnings("serial")
public class Therapy extends VerticalLayout implements View{
    
    	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private PatientMainDesign design;
	protected ComboBox therapyList;
	protected Button buttonNext1;
	protected TabSheet therapyInfo;

	
	/**
	 * Constructs a THERAPYVIEW on the base of different parameters.
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
		// verticalLayout_21
		verticalLayout = buildVerticalLayout_21();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");

	}
	
	/**
	 * Builds the verticallayout and defines the size. Edits the
	 * verticallayout by adding the application logo, a combobox
	 * for the list of various therapies and a next button to go to the next page
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
		
		therapyList.setInputPrompt("Select a Therapy");
		therapyList.setWidth("80%");
		therapyList.setHeight("-1px");
		therapyList.setStyleName(ValoTheme.COMBOBOX_BORDERLESS);
		therapyList.setNewItemsAllowed(true);
		therapyList.setImmediate(true);
		therapyList.setNullSelectionAllowed(false);
		verticalLayout.addComponent(therapyList);
		verticalLayout.setComponentAlignment(therapyList,Alignment.MIDDLE_CENTER);
		
		// Textarea for TherapyNotes
		
		therapyInfo = new TabSheet ();
				
		therapyInfo.setWidth("100%");
		therapyInfo.setHeight("100%");
		therapyInfo.setImmediate(true);
		verticalLayout.addComponent(therapyInfo);
		verticalLayout.setComponentAlignment(therapyInfo,Alignment.MIDDLE_CENTER);

		
		
		
		
		// Button for Next
		
		buttonNext1 = new Button ("GO to Tasks");
		buttonNext1.setIcon(FontAwesome.ARROW_CIRCLE_O_RIGHT);
		buttonNext1.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ControllerUI.navigateTo(ControllerUI.THERAPYVIEW3);

			}
		});
		
		verticalLayout.addComponent(buttonNext1);
		verticalLayout.setComponentAlignment(buttonNext1,Alignment.MIDDLE_CENTER);
		
		return verticalLayout;
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		therapyList.removeAllItems();
		 
		for(TherapyModel s: XmlFileReader.getTherapies())
		    {
			
			therapyList.addItems(s.getName());
		}
		
		therapyInfo.removeAllComponents();
		therapyInfo.addTab(new Label(XmlFileReader.getTherapies().get(0).getDescription()),"Therapy1");
		therapyInfo.addTab(new Label(XmlFileReader.getTherapies().get(1).getDescription()),"Therapy2");
		therapyInfo.addTab(new Label(XmlFileReader.getTherapies().get(2).getDescription()),"Therapy3");
		therapyInfo.addTab(new Label(XmlFileReader.getTherapies().get(3).getDescription()),"Therapy4");
		therapyInfo.addTab(new Label(XmlFileReader.getTherapies().get(4).getDescription()),"Therapy5");
		
	}
	

//		public static void main(String[] args) {
//			for(showTherapy s: XmlFileReader.getTherapies())
//		    {
//			
//			System.out.println(new Label(s.toString().);
//		}

		
	    
	}
	
