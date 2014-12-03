/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;



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
	protected TextField therapyName;
	protected TextArea doctorNotes;
	protected Table goalTable;
	protected Link mailToDoctor;
	protected Button buttonOk;
	protected Button buttonNotOk;
	
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
		verticalLayout.setComponentAlignment(therapyList,
				Alignment.BOTTOM_CENTER);
		
		
		
		// Textfield for TherayTitleName
		
		therapyName = new TextField(" Therapyname: ");
		
		therapyName.setWidth("80%");
		therapyName.setHeight("-1px");
		therapyName.setRequired(true);
		therapyName.setImmediate(true);
		verticalLayout.addComponent(therapyName);
		verticalLayout.setComponentAlignment(therapyName,
				Alignment.BOTTOM_CENTER);
		
		
		
		
		// Textarea for TherapyNotes
		
		doctorNotes = new TextArea ("DoctorNotes: ");
		
		doctorNotes.setWidth("80%");
		doctorNotes.setHeight("-1px");
		doctorNotes.setRequired(true);
		doctorNotes.setImmediate(true);
		verticalLayout.addComponent(doctorNotes);
		verticalLayout.setComponentAlignment(doctorNotes,
				Alignment.BOTTOM_CENTER);
		
		doctorNotes.setRows(10);
		
		
		// Table for Goals of Therapies
		
		goalTable = new Table ("Therapy Goals");
		
		goalTable.setWidth("80%");
		goalTable.setHeight("-1px");
		
		goalTable.setRequired(true);
		goalTable.setImmediate(true);
		
		goalTable.setPageLength(10);
		goalTable.addContainerProperty("String", String.class, "");
		goalTable.addContainerProperty("Button", Button.class, "OK");
		goalTable.addContainerProperty("Button", Button.class, "X");
		
		verticalLayout.addComponent(goalTable);
		verticalLayout.setComponentAlignment(goalTable,
				Alignment.BOTTOM_CENTER);
		
		
		// Button for OK
		
		buttonOk = new Button ("OK");
		
		buttonOk.setWidth("80%");
		buttonOk.setHeight("-1px");
		
		buttonOk.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		        Notification.show("Well done !");
		    }
		});
		
		
		verticalLayout.addComponent(buttonOk);
		verticalLayout.setComponentAlignment(buttonOk,
			Alignment.BOTTOM_CENTER);
		        
		
		// Button for NOT OK
		


		buttonNotOk = new Button ("X");
		
		buttonNotOk.setWidth("80%");
		buttonNotOk.setHeight("-1px");
		
		buttonNotOk.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		        Notification.show("Send a Email to the Doctor");
		    }
		});
		
		verticalLayout.addComponent(buttonNotOk);
		verticalLayout.setComponentAlignment(buttonNotOk,
			Alignment.BOTTOM_CENTER);

		
		// Link for Mail to Doctor send
		
		Link mailToDoctor = new Link("Send a reprot to Doctor",
		        new ExternalResource("Doctor@bfh.ch"));
		
		mailToDoctor.setWidth("80%");
		mailToDoctor.setHeight("-1px");
		
		
		mailToDoctor.setImmediate(true);
		
		
		verticalLayout.addComponent(mailToDoctor);
		verticalLayout.setComponentAlignment(mailToDoctor,
			Alignment.BOTTOM_CENTER);
		
		
		return verticalLayout;
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
	    
	}
    
    
    
   
    
    
    
    
    

}
