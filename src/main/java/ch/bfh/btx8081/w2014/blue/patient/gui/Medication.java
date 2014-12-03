/**	
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Pira
 * @author Sabine
 *
 */
public class Medication extends VerticalLayout implements View {


	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private Button DosageButton;
	private Button MedInfoButton;
	private Button HomeButton;
	private PatientMainDesign design;

	public Medication()
	{
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		buildVerticalLayout_1();
		createLayout();
	}
	
	private void createLayout() {
		design.setTitleLabel("Medication");
		verticalLayout = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");
	}
	
	public void enter(ViewChangeEvent event) {
		DosageButton.addClickListener(null);
		MedInfoButton.addClickListener(null);
		HomeButton.addClickListener(null);
	}
	
	private VerticalLayout buildVerticalLayout_1(){
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);
		
		DosageButton = new Button("Current Dosage");
		DosageButton.setImmediate(true);
		DosageButton.setWidth("80%");
		DosageButton.setHeight("-1px");
		verticalLayout.addComponent(DosageButton);
		verticalLayout.setComponentAlignment(DosageButton, Alignment.MIDDLE_CENTER);
		
		MedInfoButton = new Button("Medicine Information");
		MedInfoButton.setImmediate(true);
		MedInfoButton.setWidth("80%");
		MedInfoButton.setHeight("-1px");
		verticalLayout.addComponent(MedInfoButton);
		verticalLayout.setComponentAlignment(MedInfoButton, Alignment.MIDDLE_CENTER);
		
		HomeButton = new Button("Home");
		HomeButton.setImmediate(true);
		HomeButton.setWidth("80%");
		HomeButton.setHeight("-1px");
		verticalLayout.addComponent(HomeButton);
		verticalLayout.setComponentAlignment(HomeButton, Alignment.BOTTOM_CENTER);
		
		return verticalLayout;
		
	}
}
