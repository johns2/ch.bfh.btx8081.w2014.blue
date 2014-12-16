/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;



/**
 * @author Michel
 *
 */
@SuppressWarnings("serial")
public class Therapy3 extends VerticalLayout implements View{
    
    	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private PatientMainDesign design;
	protected Table goalTable;
	protected Button next;
	protected Link mailToDoctor;
	protected Button buttonOk;
	protected Button buttonNotOk;
	
	/**
	 * Constructs a THERAPYVIEW on the base of different parameters.
	 * 
	 * 
	 */
	
	public Therapy3()

	{
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		buildVerticalLayout_23();
		createLayout();
	}
	
	/**
	 * create a layout and add this new layout at the mainLayout. the title
	 * of this layout will be defined.
	 */
	
	
	private void createLayout() {

		design.setTitleLabel("Therapy");
		// verticalLayout_1
		verticalLayout = buildVerticalLayout_23();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");

	}
	
	
	
	
	
	/**
	 * Builds the verticallayout and defines the size. Edits the
	 * verticallayout by adding the application logo, 
	 */
	

	private VerticalLayout buildVerticalLayout_23() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		
		
	// Table for Goals of Therapies
		
	goalTable = new Table ("Therapy Goals: ");
				
	goalTable.setWidth("80%");
	goalTable.setHeight("-1px");
				
	goalTable.setRequired(true);
	goalTable.setImmediate(true);
				
	goalTable.setPageLength(5);
	goalTable.addContainerProperty("Goals", String.class, "");
	goalTable.addContainerProperty("Done", Button.class, "");
	goalTable.addContainerProperty("Not done", Button.class, "");
				
	verticalLayout.addComponent(goalTable);
	verticalLayout.setComponentAlignment(goalTable,Alignment.TOP_CENTER);
	
	// Button for OK
	
	buttonOk = new Button ("Done");
	buttonOk.setIcon(FontAwesome.CHECK);
	buttonOk.setWidth("40%");
	buttonOk.setHeight("-1px");
	
	buttonOk.addClickListener(new Button.ClickListener() {
		public void buttonClick(ClickEvent event) {
			Notification.show("Well done !");
			}
		});
			
		
	
	verticalLayout.addComponent(buttonOk);
	verticalLayout.setComponentAlignment(buttonOk, Alignment.MIDDLE_CENTER);
	
	// Button for NOT OK
	
	buttonNotOk = new Button ("Not done");
	buttonNotOk.setIcon(FontAwesome.TIMES);
	buttonNotOk.setWidth("40%");
	buttonNotOk.setHeight("-1px");
	
	buttonNotOk.addClickListener(new Button.ClickListener() {
	    public void buttonClick(ClickEvent event) {
	        Notification.show("Send a Email to the Doctor: doctor@bfh.ch");
	    }
	});
	
	verticalLayout.addComponent(buttonNotOk);
	verticalLayout.setComponentAlignment(buttonNotOk,Alignment.BOTTOM_CENTER);
	
	// Link for Mail to Doctor send
	/*
	Link mailToDoctor = new Link("Send a report to Doctor",
	        new ExternalResource("Doctor@bfh.ch"));

	mailToDoctor.setImmediate(true);
	verticalLayout.addComponent(mailToDoctor);
	verticalLayout.setComponentAlignment(mailToDoctor,Alignment.BOTTOM_CENTER);
	*/	
		
	return verticalLayout;	
	}

	@Override
	public void enter(ViewChangeEvent event) {
	    
	}
    


}

