/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Riza Ramsauer
 *
 */
public class Init extends VerticalLayout implements View{      
	@Override
	public void enter(ViewChangeEvent event) 
	{
		ControllerUI.navigateTo(ControllerUI.LOGINVIEW);
		ControllerUI.navigateTo(ControllerUI.HOMEVIEW);
		ControllerUI.navigateTo(ControllerUI.THERAPYVIEW);
		ControllerUI.navigateTo(ControllerUI.MEDICATION);
		
		
		
		
	}

}
