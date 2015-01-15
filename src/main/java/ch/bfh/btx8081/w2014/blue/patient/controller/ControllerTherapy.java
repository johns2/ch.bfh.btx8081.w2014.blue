package ch.bfh.btx8081.w2014.blue.patient.controller;

import java.util.ArrayList;
import java.util.List;

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
	private Solved solvedController = new Solved();
	private NotSolved notSolvedController = new NotSolved();
	private ToImprove toImproveController = new ToImprove();
	private ArrayList<Object[]> taskData = new ArrayList<Object[]>();
	private ArrayList<String> therapyNames = new ArrayList<String>();
	private ArrayList<String> therapyDescriptions = new ArrayList<String>();
	private ArrayList<String> therapyPurpose = new ArrayList<String>();
	private TaskModel taskToChange;
	private TaskModel changedTask;

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
		solvedController.setView(therapyView3);
		notSolvedController.setView(therapyView3);
		toImproveController.setView(therapyView3);
	}

	/**
	 * Returns the tasks of a therapy
	 * 
	 * @return goalTableItems in a <code>ArrayList</code><Object[]>
	 */
	public ArrayList<Object[]> getTasksOfTherapy() {
		taskData.clear();
		for (TaskModel task : therapies.get(0).getTasks()) {
			Object[] taskTableContainer = new Object[2];
			taskTableContainer[0] = task.getTaskGoal();
			taskTableContainer[1] = task.getTaskDate();
			taskData.add(taskTableContainer);
		}
		return taskData;
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

	/**
	 * Returns the purpose texts of the therapies
	 * 
	 * @return therapyPurpose in a <code>ArrayList</code><String>
	 */
	public ArrayList<String> getTherapyPurpose() {
		for (TherapyModel therapy : therapies) {
			therapyPurpose.add(therapy.getPurpose());
		}
		return therapyPurpose;
	}

	public void clickDoneButton(Object itemId) {
		taskToChange = therapies.get(0).getTasks().get((Integer) itemId);
		if (changedTask == null){
			changedTask = taskToChange;
		}
		if (taskToChange.getTaskState().equals("Solved")) {
			taskToChange = solvedController.clickDoneButton(changedTask,
					itemId);
		} else if (taskToChange.getTaskState().equals("ToImprove")) {
			taskToChange = toImproveController.clickDoneButton(changedTask,
					itemId);
		} else {
			taskToChange = notSolvedController.clickDoneButton(changedTask,
					itemId);
		}
		therapies.get(0).getTasks().set((Integer) itemId, taskToChange);
	}

	public void clickNotDoneButton(Object itemId) {
		taskToChange = therapies.get(0).getTasks().get((Integer) itemId);
		if (changedTask == null){
			changedTask = taskToChange;
		}
		if (taskToChange.getTaskState().equals("Solved")) {
			changedTask = solvedController.clickNotDoneButton(changedTask,
					itemId);
		} else if (taskToChange.getTaskState()
				.equals("ToImprove")) {
			changedTask = toImproveController.clickNotDoneButton(changedTask,
					itemId);
		} else {
			changedTask = notSolvedController.clickNotDoneButton(changedTask,
					itemId);
		}
		therapies.get(0).getTasks().set((Integer) itemId, changedTask);

	}
}
