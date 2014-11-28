/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * @author Pira
 *
 */
public class PatientMainDesign {
		
		final VerticalLayout layout;
		private AbsoluteLayout mainLayout;
		private VerticalLayout upperVerticalLayout;
		private HorizontalLayout lowerHorizontalLayout;
		private Label title;
		
		public PatientMainDesign(VerticalLayout layout)
		{
			this.layout = layout;
			createLayout();
		}
		private void createLayout()
		{
			layout.setStyleName(Reindeer.LAYOUT_BLUE);
			layout.setWidth("320px");
			layout.setHeight("480px");
			createMainLayout();	
			layout.addComponent(mainLayout);
		}
		
		private void createMainLayout()
		{
			mainLayout = new AbsoluteLayout();
			mainLayout.setWidth("320px");
			mainLayout.setHeight("480px");

			createUpperVerticalLayout();
			createLowerHorizontalLayout();
				
			mainLayout.addComponent(upperVerticalLayout,"top:0px;left:0px");
			mainLayout.addComponent(lowerHorizontalLayout,"bottom:0px;left:0px");	
		}
		private void createUpperVerticalLayout()
		{
			upperVerticalLayout = new VerticalLayout();
			upperVerticalLayout.setHeight("60px");
			upperVerticalLayout.setWidth("320px");
			upperVerticalLayout.setStyleName(Reindeer.LAYOUT_BLUE);	
			
		}
		private void createLowerHorizontalLayout()
		{
			lowerHorizontalLayout = new HorizontalLayout();
			lowerHorizontalLayout.setHeight("60px");
			lowerHorizontalLayout.setWidth("320px");
			lowerHorizontalLayout.addStyleName("mylayout");
		}
		public VerticalLayout getLayout()
		{
			return layout;
		}
		public AbsoluteLayout getMainLayout()
		{
			return mainLayout;
		}
		public VerticalLayout getUpperVerticalLayout()
		{
			return upperVerticalLayout;
		}
		public HorizontalLayout getLowerHorizontalLayout()
		{
			return lowerHorizontalLayout;
		}
		public void setTitleLabel(String title)
		{
			this.title = new Label(title);
			this.title.setSizeUndefined();
			this.title.setStyleName("mylabel");
			upperVerticalLayout.removeAllComponents();
			upperVerticalLayout.addComponent(this.title);
			upperVerticalLayout.setComponentAlignment(this.title, Alignment.MIDDLE_CENTER);
		}
	}



