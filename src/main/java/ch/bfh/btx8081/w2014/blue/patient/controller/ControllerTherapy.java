package ch.bfh.btx8081.w2014.blue.patient.controller;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.CheckBox;

import ch.bfh.btx8081.w2014.blue.patient.gui.TherapyView;
import ch.bfh.btx8081.w2014.blue.patient.gui.TherapyView3;
import ch.bfh.btx8081.w2014.blue.patient.model.TaskModel;
import ch.bfh.btx8081.w2014.blue.patient.model.TherapyModel;

/**
 * 
 * @author Stefan Johner, johns2@bfh.ch
 *
 */
public class ControllerTherapy {

	private List<TherapyModel> therapies;
	private TherapyView therapyView;
	private TherapyView3 therapyView3;
	private ArrayList<Object[]> goalTableItems = new ArrayList<Object[]>();
	private ArrayList<String> therapyNames = new ArrayList<String>();
	private ArrayList<String> therapyDescriptions = new ArrayList<String>();

	public ControllerTherapy(List<TherapyModel> list, TherapyView therapyView,
			TherapyView3 therapyView3) {
		this.therapies = list;
		this.therapyView = therapyView;
		this.therapyView3 = therapyView3;
	}

	public void setTherapyView(TherapyView therapyView) {
		this.therapyView = therapyView;
	}

	public void setTherapyView3(TherapyView3 therapyView3) {
		this.therapyView3 = therapyView3;
	}

	
	/**
	 * Returns the tasks of a therapy
	 * 
	 * @return goalTableItems in a <code>ArrayList</code><Object[]>
	 */
	public ArrayList<Object[]> getTasksOfTherapy() {
		for (TaskModel task : therapies.get(0).getTasks()) {
			goalTableItems.add(new Object[] { task.getTaskGoal(),
					new CheckBox("", false), task.getTaskDate() });
		}
		return goalTableItems;
	}

	/**
	 * Returns the names of the therapies
	 * 
	 * @return therapyNames in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getTherapyNames() {
		for (TherapyModel therapy : therapies) {
			therapyNames.add(therapy.getName());
		}
		return therapyNames;
	}
	
	/**
	 * Returns the description texts of the therapies
	 * 
	 * @return therapyDescriptions in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getTherapyDescriptions() {
		for (TherapyModel therapy : therapies) {
			therapyDescriptions.add(therapy.getDescription());
		}
		return therapyDescriptions;
	}
}
