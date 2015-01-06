/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Pira
 *
 */
@Theme("mytheme")
public class PatientMainDesign {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout upperVerticalLayout;
	private HorizontalLayout lowerHorizontalLayout;
	private Label title;
	private Styles styles;

	public PatientMainDesign(VerticalLayout layout) {
		styles = Page.getCurrent().getStyles();
		this.layout = layout;
		createCssForMainLayout();
		createLayout();
	}

	private void createLayout() {

		layout.setStyleName("layout");

		createMainLayout();
		layout.setWidth(null);

		layout.addComponent(mainLayout);
		// layout.setComponentAlignment(mainLayout, Alignment.TOP_CENTER);
		// layout.setWidth("25%");
		// layout.setHeight("75%");

	}

	private void createMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setStyleName("mainlayout");
		mainLayout.setWidth("320px");
		mainLayout.setHeight("480px");

		createUpperVerticalLayout();
		createLowerHorizontalLayout();

		mainLayout.addComponent(upperVerticalLayout, "top:0px;left:0px");
		mainLayout.addComponent(lowerHorizontalLayout, "bottom:0px;left:0px");
	}

	private void createUpperVerticalLayout() {
		upperVerticalLayout = new VerticalLayout();
		upperVerticalLayout.setHeight("60px");
		upperVerticalLayout.setWidth("320px");
		upperVerticalLayout.setStyleName(Reindeer.LAYOUT_BLACK);

	}

	private void createLowerHorizontalLayout() {
		lowerHorizontalLayout = new HorizontalLayout();
		lowerHorizontalLayout.setHeight("60px");
		lowerHorizontalLayout.setWidth("320px");
		lowerHorizontalLayout.addStyleName("mylayout");
	}

	public VerticalLayout getLayout() {
		return layout;
	}

	public AbsoluteLayout getMainLayout() {
		return mainLayout;
	}

	public VerticalLayout getUpperVerticalLayout() {
		return upperVerticalLayout;
	}

	public HorizontalLayout getLowerHorizontalLayout() {
		return lowerHorizontalLayout;
	}

	public void setTitleLabel(String title) {

		this.title = new Label(title);
		this.title.setSizeUndefined();
		this.title.setStyleName(Reindeer.LABEL_H1);
		upperVerticalLayout.removeAllComponents();
		upperVerticalLayout.addComponent(this.title);
		upperVerticalLayout.setComponentAlignment(this.title,
				Alignment.MIDDLE_CENTER);
	}

	private void createCssForMainLayout() {

		styles.add(".mainlayout {"

		+ "background-image: url(http://us.123rf.com/450wm/gigello/gigello1110/gigello111000007/10798899-green-alternative-medication-concept--vector-illustration.jpg);" + "position: fixed;" + "top: 50%;"
				+ "left:50%;" + " transform: translate(-50%, -50%);"
				+ "border: #cedcf2 double 4px;"
				+ " border-color: #0000ff #0000ff; "
				+ "box-shadow: 0 0 30px #9ecaed;" + 
				";}");
	}

/*	private void createCssForLabel(){
	styles.add(".mylabel {"
	+ "font-size: 40px;"
	+"padding-top: 10px;"
	+"padding-bottom: 15px;"
	+"}");
	}*/

	// styles.add(".mylayout {"
	// +"padding-right: 30px;"
	// +"padding-left: 30px;"
	// +"background-color: black;"
	// +"}");

	public Styles getStyles() {
		return styles;
	}

}
