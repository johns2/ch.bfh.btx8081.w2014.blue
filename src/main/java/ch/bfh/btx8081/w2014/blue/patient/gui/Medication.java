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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * @author Pira
 * @author Sabine
 *
 *
 */
public class Medication extends VerticalLayout implements View {


	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private Button dosageButton;
	private Button MedInfoButton;
	private Button homeButton;
	private PatientMainDesign design;

	public Medication()
	{
		buildVerticalLayout_1();
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		createLayout();
	}
	
	private void createLayout() {
		design.setTitleLabel("Medication");
		verticalLayout = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");
	}
	
	public void enter(ViewChangeEvent event) {
		/*dosageButton.addClickListener(null);
		MedInfoButton.addClickListener(null);
		homeButton.addClickListener(null);
		*/
	}
	
	private VerticalLayout buildVerticalLayout_1(){
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);
		
		dosageButton = new Button("Current Dosage");
		dosageButton.setIcon(FontAwesome.HOSPITAL_O);
		dosageButton.setImmediate(true);
		dosageButton.setWidth("80%");
		dosageButton.setHeight("-1px");
		verticalLayout.addComponent(dosageButton);
		verticalLayout.setComponentAlignment(dosageButton, Alignment.MIDDLE_CENTER);
		
		MedInfoButton = new Button("Medicine Information");
		MedInfoButton.setIcon(FontAwesome.INFO_CIRCLE);
		MedInfoButton.setImmediate(true);
		MedInfoButton.setWidth("80%");
		MedInfoButton.setHeight("-1px");
		verticalLayout.addComponent(MedInfoButton);
		verticalLayout.setComponentAlignment(MedInfoButton, Alignment.MIDDLE_CENTER);
		
		homeButton = new Button("Home");
		homeButton.setIcon(FontAwesome.HOME);
		homeButton.setImmediate(true);
		homeButton.setWidth("80%");
		homeButton.setHeight("-1px");
		homeButton.addClickListener(new Button.ClickListener() {
			
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
}
