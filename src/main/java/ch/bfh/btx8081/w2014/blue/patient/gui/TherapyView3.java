/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerTherapy;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;
import ch.bfh.btx8081.w2014.blue.patient.model.TaskModel;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.Action;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Michel This Class creates the 3th page of the therapy section
 */
@SuppressWarnings("serial")
public class TherapyView3 extends VerticalLayout implements View {

	final VerticalLayout layout;
	private AbsoluteLayout mainLayout;
	private VerticalLayout verticalLayout;
	private PatientMainDesign design;
	private Table goalTable;
	private Button next;
	private Link mailToDoctor;
	private Button buttonOk;
	private Button buttonNotOk;
	private HashSet<Object> markedRows = new HashSet<Object>();
	private String valueString;
	private int chosenItem = 1;
	private ControllerTherapy therapyController;
	protected Button buttonNext1;
	protected Button buttonBack2;


	/**
	 * Constructs a THERAPYVIEW3 on the base of different parameters.
	 */
	public TherapyView3(ControllerTherapy therapyController)

	{
		this.therapyController = therapyController;
		therapyController.setTherapyView3(this);
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		buildVerticalLayout_23();
		createLayout();
	}

	/**
	 * create a layout and add this new layout at the mainLayout. the title of
	 * this layout will be defined.
	 */
	private void createLayout() {

		design.setTitleLabel("Task");
		// verticalLayout_23
		verticalLayout = buildVerticalLayout_23();
		mainLayout.addComponent(verticalLayout, "top:60.0px;left:30.0px;");

	}

	/**
	 * Builds the verticallayout and defines the size. Edits the verticallayout
	 * by adding the application logo, a table for the goals of therapy and to
	 * shot of the goaleis done or not done and a button for click done, if the
	 * goal is not done, there is a link with the mail address of the doctor to
	 * send him the reason why the goal is not done and a next button to go to
	 * the next page
	 */
	private VerticalLayout buildVerticalLayout_23() {
		// common part: create layout
		verticalLayout = new VerticalLayout();
		verticalLayout.setImmediate(false);
		verticalLayout.setWidth("260px");
		verticalLayout.setHeight("360px");
		verticalLayout.setMargin(false);

		// Table for Goals of Therapies

		goalTable = new Table();

		goalTable.setWidth("100%");
		goalTable.setHeight("100%");

		goalTable.setRequired(true);
		goalTable.setImmediate(true);

		goalTable.setPageLength(5);
		goalTable.setColumnHeader(String.class, "Task");
		goalTable.setColumnHeader(CheckBox.class, "Status");
		goalTable.setColumnHeader(String.class, "Date");
		goalTable.addContainerProperty("Task", String.class, "");
		goalTable.addContainerProperty("Status", CheckBox.class, new CheckBox(
				"", false));
		goalTable.addContainerProperty("Date", String.class, "");
		goalTable.setSelectable(true);

		verticalLayout.addComponent(goalTable);
		verticalLayout.setComponentAlignment(goalTable, Alignment.TOP_CENTER);
		
		// Button for OK

		buttonOk = new Button("Done");
		buttonOk.setIcon(FontAwesome.CHECK);
		buttonOk.setWidth("40%");
		buttonOk.setHeight("-1px");
		//verticalLayout.addComponent(buttonOk);
		//verticalLayout.setComponentAlignment(buttonOk, Alignment.MIDDLE_CENTER);

		buttonOk.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				chosenItem = Integer.parseInt(valueString);
				goalTable.getItem(chosenItem).getItemProperty("Status")
						.setValue(new CheckBox("", true));
			}
		});

		final Action ACTION_MARK = new Action("Mark");
		final Action ACTION_UNMARK = new Action("Unmark");

		goalTable.addActionHandler(new Action.Handler() {
			@Override
			public Action[] getActions(final Object target, final Object sender) {
				if (markedRows.contains(target)) {
					return new Action[] { ACTION_UNMARK };
				} else {
					return new Action[] { ACTION_MARK };
				}
			}

			@Override
			public void handleAction(final Action action, final Object sender,
					final Object target) {
				if (ACTION_MARK == action) {
					markedRows.add(target);
				} else if (ACTION_UNMARK == action) {
					markedRows.remove(target);
				}
				goalTable.markAsDirtyRecursive();
			}

		});

		goalTable.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(final ValueChangeEvent event) {
				valueString = String.valueOf(event.getProperty().getValue());
				Notification.show("Value changed:", valueString,
						Type.TRAY_NOTIFICATION);
			}
		});

		//verticalLayout.addComponent(buttonOk);
		//verticalLayout.setComponentAlignment(buttonOk, Alignment.MIDDLE_CENTER);

		// Button for NOT OK

		buttonNotOk = new Button("Not done");
		buttonNotOk.setIcon(FontAwesome.TIMES);
		buttonNotOk.setWidth("40%");
		buttonNotOk.setHeight("-1px");
		//verticalLayout.addComponent(buttonNotOk);
		//verticalLayout.setComponentAlignment(buttonNotOk,
			//	Alignment.MIDDLE_CENTER);

		buttonNotOk.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				chosenItem = Integer.parseInt(valueString);
				goalTable.getItem(chosenItem).getItemProperty("Status")
						.setValue(new CheckBox("", false));
				// .setValue(
				// Task.setTherapyState(goalTable.getItem(0),
				// "NotSolved"));

			}
		});
		
		// Button for Next

		buttonNext1 = new Button("GO to Tasks");
		buttonNext1.setIcon(FontAwesome.ARROW_CIRCLE_O_RIGHT);
		buttonNext1.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ControllerUI.navigateTo(ControllerUI.THERAPYVIEW3);

			}
		});
		
		// Button for got o 1 step back

		buttonBack2 = new Button("GO back");
		buttonBack2.setIcon(FontAwesome.ARROW_CIRCLE_O_LEFT);
		buttonBack2.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ControllerUI.navigateTo(ControllerUI.THERAPYVIEW);

			}
			
		});

		verticalLayout.addComponent(buttonNext1);
		verticalLayout.setComponentAlignment(buttonNext1,
				Alignment.BOTTOM_CENTER);
		verticalLayout.addComponent(buttonBack2);
		verticalLayout.setComponentAlignment(buttonBack2,
				Alignment.BOTTOM_CENTER);


		// Link for Mail to Doctor send
		//
		// Link mailToDoctor = new Link("Send a report to Doctor",
		// new ExternalResource("Doctor@bfh.ch"));
		//
		// mailToDoctor.setImmediate(true);
		// verticalLayout.addComponent(mailToDoctor);
		// verticalLayout.setComponentAlignment(mailToDoctor,
		// Alignment.BOTTOM_CENTER);

		return verticalLayout;
	}


	@Override
	public void enter(ViewChangeEvent event) {
		goalTable.removeAllItems();
		int objectCounter = 0;
		for (Object[] goalTableItem : therapyController.getTasksOfTherapy()){
			goalTable.addItem(goalTableItem, objectCounter);
			objectCounter++;
		}
	}

}
