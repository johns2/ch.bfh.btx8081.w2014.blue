/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
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
	private Styles styles;

	/*
	 * create the main design for all of the views
	 */
	public PatientMainDesign(VerticalLayout layout) {
		styles = Page.getCurrent().getStyles();
		this.layout = layout;
		createCssForMainLayout();
		createLayout();
	}
	

	/*
	 * create the a vertical layout for mainLayout
	 */
	private void createLayout() {

		layout.setStyleName("layout");

		createMainLayout();
		layout.setWidth(null);

		layout.addComponent(mainLayout);

	}

	/*
	 * Create main Layout
	 */
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

	/*
	 * create the Upper Vertical Layout
	 */
	private void createUpperVerticalLayout() {
		upperVerticalLayout = new VerticalLayout();
		upperVerticalLayout.setHeight("60px");
		upperVerticalLayout.setWidth("320px");
		upperVerticalLayout.setStyleName(Reindeer.LAYOUT_BLACK);

	}

	/*
	 * create lower Horizontal layout
	 */
	private void createLowerHorizontalLayout() {
		lowerHorizontalLayout = new HorizontalLayout();
		lowerHorizontalLayout.setHeight("60px");
		lowerHorizontalLayout.setWidth("320px");
		lowerHorizontalLayout.addStyleName("mylayout");
	}

	/**
	 * 
	 * @return the layout
	 */
	public VerticalLayout getLayout() {
		return layout;
	}

	/**
	 * 
	 * @return the mainLayout
	 */
	public AbsoluteLayout getMainLayout() {
		return mainLayout;
	}

	/**
	 * 
	 * @return the upperVerticalLayout
	 */
	public VerticalLayout getUpperVerticalLayout() {
		return upperVerticalLayout;
	}

	/**
	 * 
	 * @return the lowerHorizontalLayout
	 */
	public HorizontalLayout getLowerHorizontalLayout() {
		return lowerHorizontalLayout;
	}

	/**
	 * 
	 * @param title set the title label to the given title
	 */
	public void setTitleLabel(String title) {

		this.title = new Label(title);
		this.title.setSizeUndefined();
		this.title.setStyleName(Reindeer.LABEL_H1);
		upperVerticalLayout.removeAllComponents();
		upperVerticalLayout.addComponent(this.title);
		upperVerticalLayout.setComponentAlignment(this.title,
				Alignment.MIDDLE_CENTER);
	}

	/**
	 * create CSS for the mainLayout
	 */
	private void createCssForMainLayout() {

		styles.add(".mainlayout {"

		+ "background-image: url(http://i.imgur.com/kaRnZJx.jpg?1);" + "position: fixed;" + "top: 50%;"
				+ "left:50%;" + " transform: translate(-50%, -50%);"
				+ "border: #cedcf2 double 4px;"
				+ " border-color: #0000ff #0000ff; "
				+ "box-shadow: 0 0 30px #9ecaed;" + 
				";}");
	}


	/**
	 * 
	 * @return the style
	 */
	public Styles getStyles() {
		return styles;
	}

}
