/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.controller;

import ch.bfh.btx8081.w2014.blue.patient.gui.Login;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * @author Pira
 *
 */
public class ControllerUI extends UI {

	public static final String HOMEVIEW = "home";
	public static final String LOGINVIEW = "login";
	public static final String TASKVIEW = "task";
	public static final String MEDICATION = "medication";
	private static Controller controller;
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ControllerUI.class, widgetset = "ch.bfh.btx8081.w2014.blue.patient.GUI.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }
    @Override
    protected void init(VaadinRequest request) 
    {
    	Data.loadComments();
		Data.loadDiseases();
		Data.loadDrugs();
		Data.loadUsers();
    	navigator = new Navigator(this, this);
    	navigator.addView("", new Init());
        navigator.addView(LOGINVIEW, new Login());
        
        
   
    

}

}
