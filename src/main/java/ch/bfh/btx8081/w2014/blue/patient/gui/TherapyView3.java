/**
 * 
 */
package ch.bfh.btx8081.w2014.blue.patient.gui;

import java.util.HashSet;

import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerTherapy;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerUI;
import ch.bfh.btx8081.w2014.blue.patient.controller.ControllerLogin;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.Action;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
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
	private Button buttonOk;
	private Button buttonNotOk;
	private HashSet<Object> markedRows = new HashSet<Object>();
	private String valueString;
	private int chosenItem = 1;
	private ControllerTherapy therapyController;
	private ControllerLogin loginController;
	private ColumnGenerator OkColumn;
	private ColumnGenerator NotOkColumn;
	private Button buttonBack2;

	/**
	 * Constructs a THERAPYVIEW3 on the base of different parameters.
	 */
	public TherapyView3(ControllerLogin loginController, ControllerTherapy therapyController)

	{
		this.loginController = loginController;
		this.therapyController = therapyController;
		therapyController.setTherapyView3(this);
		design = new PatientMainDesign(this);
		layout = design.getLayout();
		mainLayout = design.getMainLayout();
		Styles styles = Page.getCurrent().getStyles();
		// inject the colors for goal table here
		styles.add(".v-table-row.v-table-row-highlight-green, .v-table-row-odd.v-table-row-highlight-green { background-color: #00ff00;}");
		styles.add(".v-table-row.v-table-row-highlight-red, .v-table-row-odd.v-table-row-highlight-red { background-color: #ff0000;}");
		styles.add(".v-table-row.v-table-row-highlight-orange, .v-table-row-odd.v-table-row-highlight-orange { background-color: #ffbb00;}");
		buildVerticalLayout_23();
		createLayout();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (loginController.checkPermission() == false){
			loginController.doLogout();
		};
		buildTaskList();
	}

	/**
	 * create a layout and add this new layout at the mainLayout. the title of
	 * this layout will be defined.
	 */
	private void createLayout() {

		design.setTitleLabel("Task");
		// verticalLayout_23
		verticalLayout = buildVerticalLayout_23();
		mainLayout.addComponent(verticalLayout, "top:80.0px;left:30.0px;");
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
		goalTable.setColumnHeader(String.class, "Task");
		goalTable.setColumnHeader(String.class, "Date");
		goalTable.addContainerProperty("Task", String.class, "");
		goalTable.addContainerProperty("Date", String.class, "");
		goalTable.addGeneratedColumn("Done", getOkColumn());
		goalTable.addGeneratedColumn("Not Done", getNotOkColumn());
		goalTable.setSelectable(false);

		verticalLayout.addComponent(goalTable);
		verticalLayout.setComponentAlignment(goalTable, Alignment.TOP_CENTER);

		// Button for OK

		buttonOk = new Button("Done");
		buttonOk.setIcon(FontAwesome.CHECK);
		buttonOk.setWidth("40%");
		buttonOk.setHeight("-1px");
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
			}
		});

		buttonNotOk = new Button("Not done");
		buttonNotOk.setIcon(FontAwesome.TIMES);
		buttonNotOk.setWidth("40%");
		buttonNotOk.setHeight("-1px");

		buttonNotOk.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				chosenItem = Integer.parseInt(valueString);
				goalTable.getItem(chosenItem).getItemProperty("Status")
						.setValue(new CheckBox("", false));
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

		verticalLayout.addComponent(buttonBack2);
		verticalLayout.setComponentAlignment(buttonBack2,
				Alignment.BOTTOM_CENTER);
		return verticalLayout;
	}

	public ColumnGenerator getOkColumn() {
		OkColumn = new ColumnGenerator() {
			@Override
			public Object generateCell(final Table source, final Object itemId,
					Object columnId) {
				Button button = new Button("Done");
				button.addClickListener(new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						therapyController.clickDoneButton(itemId);
					}
				});
				return button;
			}
		};
		return OkColumn;
	}

	public ColumnGenerator getNotOkColumn() {
		NotOkColumn = new ColumnGenerator() {
			@Override
			public Object generateCell(final Table source, final Object itemId,
					Object columnId) {
				Button button = new Button("Not Done");
				button.addClickListener(new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						therapyController.clickNotDoneButton(itemId);
					}
				});
				return button;
			}
		};
		return NotOkColumn;
	}

	public void buildTaskList() {
		goalTable.removeAllItems();
		int objectCounter = 0;
		for (Object[] goalData : therapyController.getTasksOfTherapy()) {
			goalTable.addItem(new Object[] { (String) goalData[0],
					(String) goalData[1] }, objectCounter);
			objectCounter++;
		}
		changeRowColor(goalTable, "highlight-red", "highlight-red");
	}

	// color argument prüfen
	public void changeRowColor(Object itemToChange, String color,
			String oldColor) {
		goalTable.setCellStyleGenerator(new Table.CellStyleGenerator() {
			@Override
			public String getStyle(Table source, Object chosenItem,
					Object propertyId) {
				if (itemToChange.equals(chosenItem)) {
					return color;
				} else {
					return oldColor;
				}
			}
		});
	}
}
