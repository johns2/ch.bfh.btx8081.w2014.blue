/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Riza Ramsauer
 *
 */
public class Init extends com.vaadin.ui.UI {      
		  public void init(VaadinRequest request) {         
		    getPage().setTitle("Login"); 
		    VerticalLayout content = new VerticalLayout(); 
		    setContent(content); 
		    content.addComponent(new Label("Login"));   
		  } 
}
