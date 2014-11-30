/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.controller;

import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2014.blue.patient.gui.Home;
import ch.bfh.btx8081.w2014.blue.patient.gui.Init;
import ch.bfh.btx8081.w2014.blue.patient.gui.Login;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
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
	private static Navigator navigator;
	private static String previousView;
	
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ControllerUI.class, widgetset = "ch.bfh.btx8081.w2014.blue.patient.gui.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }
    @Override
    protected void init(VaadinRequest request) 
    {
    	
    	navigator = new Navigator(this, this);
    	navigator.addView("", new Init());
        navigator.addView(LOGINVIEW, new Login());
        
    }
    /**
     * 
     * @param view
     * 
     */
    public static void navigateTo(String view)
    {
    navigator.navigateTo(view);
    }
    
    public static void navigateToHome(String view)
    { 
    	navigator.addView(HOMEVIEW, new Home());
    	previousView = navigator.getState();
        navigator.navigateTo(view);
       
    }
    
    public static void navigateLogout(String view)
    {
    	previousView = navigator.getState();
        navigator.navigateTo(view);
        navigator.removeView(HOMEVIEW);
 
    }
    
    
    /**
     * 
     * @return
     */
    public static String getPreviousView()
    {
		return previousView;
    }


}


