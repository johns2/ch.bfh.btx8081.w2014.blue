/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerTherapy;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.TabSheet;

/**
 * @author Michel This Class creates the 1st page of the therapy section
 */
@SuppressWarnings("serial")
public class TherapyView extends VerticalLayout implements View {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private PatientMainDesign design;
	protected ComboBox therapyList;
	protected Button buttonNext1;
	protected TabSheet therapyInfo;
	private ControllerTherapy therapyController;
	protected Button buttonBack;
	private Map<String, String> therapyDescriptionMap;
	private Map<String, String> therapyPurposeMap;
	private ArrayList<String> therapyNames;
	private TextArea descriptionTextArea;
	private TextArea purposeTextArea;
	private Styles style;

	/**
	 * Constructs a THERAPYVIEW on the base of different parameters.
	 */
	public TherapyView(ControllerTherapy therapyController)

	{
		
		style = Page.getCurrent().getStyles();
		this.therapyController = therapyController;
		therapyNames=new ArrayList<String>();
		therapyNames=this.therapyController.getTherapyNames();
		therapyController.setTherapyView(this);
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		setStyleForTextArea();
		buildVerticalLayout_21();
		createLayout();
	}

	/**
	 * create a layout and add this new layout at the mainLayout. the title of
	 * this layout will be defined.
	 */
	private void createLayout() {

		design.setTitleLabel("Therapy");
		// verticalLayout_21
		verticalLayout = buildVerticalLayout_21();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");

	}

	/**
	 * Builds the verticallayout and defines the size. Edits the verticallayout
	 * by adding the application logo, a combobox for the list of various
	 * therapies and a next button to go to the next page
	 */
	private VerticalLayout buildVerticalLayout_21() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		// Comobox for Therapies

		therapyList = new ComboBox();

		therapyList.setInputPrompt("Select a Therapy");
		therapyList.setWidth("80%");
		therapyList.setHeight("-1px");
		therapyList.setStyleName(ValoTheme.COMBOBOX_BORDERLESS);
		therapyList.setNewItemsAllowed(false);
		therapyList.setImmediate(true);
		therapyList.setNullSelectionAllowed(false);
		verticalLayout.addComponent(therapyList);
		verticalLayout.setComponentAlignment(therapyList,
				Alignment.MIDDLE_CENTER);

		// Textarea for Therapy description
		descriptionTextArea = new TextArea("Description");
		
		descriptionTextArea.setStyleName("textarea");
		descriptionTextArea.setRequired(false);
		descriptionTextArea.setValue("Description");
		descriptionTextArea.setWidth("100%");
		descriptionTextArea.setHeight("100%");
		descriptionTextArea.setImmediate(true);

		verticalLayout.addComponent(descriptionTextArea);
		verticalLayout.setComponentAlignment(descriptionTextArea, Alignment.MIDDLE_CENTER);

		// Textarea for Therapy purpose
		purposeTextArea = new TextArea("purpose");
		purposeTextArea.setStyleName("textarea");
		purposeTextArea.setRequired(false);
		purposeTextArea.setValue("Purpose");
		purposeTextArea.setWidth("100%");
		purposeTextArea.setHeight("100%");
		purposeTextArea.setImmediate(true);

		verticalLayout.addComponent(purposeTextArea);
		verticalLayout.setComponentAlignment(purposeTextArea, Alignment.MIDDLE_CENTER);

		
		
		// Button for Next

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		
		buttonNext1 = new Button("GO to Tasks");
		buttonNext1.setIcon(FontAwesome.ARROW_CIRCLE_O_RIGHT);
		buttonNext1.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ControllerUI.navigateTo(ControllerUI.THERAPYVIEW3);

			}
		});

		// Button for got o 1 step back

		buttonBack = new Button("GO back");
		buttonBack.setIcon(FontAwesome.ARROW_CIRCLE_O_LEFT);
		buttonBack.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ControllerUI.navigateTo(ControllerUI.HOMEVIEW);

			}

		});

		horizontalLayout.addComponent(buttonBack);
		horizontalLayout.addComponent(buttonNext1);

		verticalLayout.addComponent(horizontalLayout);
		verticalLayout.setComponentAlignment(horizontalLayout,
				Alignment.BOTTOM_CENTER);
		return verticalLayout;

	}

	/*
	 * Create a map, containing the information about Therapies and their
	 * descriptions.
	 */
	private void createMapTherapyDescription() {

		therapyDescriptionMap = new TreeMap<String, String>();

		int i = 0;
		for (String str : therapyNames) {
			therapyDescriptionMap.put(str, therapyController
					.getTherapyDescriptions().get(i));
			i++;
		}
	}
	/*
	 * Create a map, containing the information about Therapies and their
	 * purpose.
	 */
	
	private void createMapTherapyPurpose() {

		therapyPurposeMap = new TreeMap<String, String>();
		//ArrayList<String> therapyPurpose = therapyController.getTherapyPurpose();

		int i = 0;
		for (String str : therapyNames) {
			therapyPurposeMap.put(str, therapyController
					.getTherapyPurpose().get(i));
			i++;
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {

		// Add the therapy names
		for (String therapyName : therapyController.getTherapyNames()) {
			therapyList.addItem(therapyName);
		}

		createMapTherapyDescription();
		therapyList.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				descriptionTextArea.setValue(therapyDescriptionMap.get(therapyList
						.getValue()));
			}
		});
		
		
		createMapTherapyPurpose();
		therapyList.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				purposeTextArea.setValue(therapyPurposeMap.get(therapyList
						.getValue()));

	}
		});}

	/*
	 * Create CSS for the Style
	 */
	private void setStyleForTextArea() {
		style.add(".textarea{" + " padding: 0.1cm !important;" + ";}");
	}

	}
