package ch.bfh.btx8081.w2014.blue.patient.controller;

import ch.bfh.btx8081.w2014.blue.patient.gui.TherapyView3;
import ch.bfh.btx8081.w2014.blue.patient.model.TaskModel;

/**
 * This controller will implement the methods of a solved <code>Task</code>
 * 
 * @author Stefan Johner
 *
 */
public class Solved implements ITaskState {
	private TherapyView3 view;

	@Override
	public TaskModel clickDoneButton(TaskModel taskToChange, Object itemId) {
		taskToChange.setTaskImproveState(0);
		return taskToChange;
	}

	@Override
	public TaskModel clickNotDoneButton(TaskModel taskToChange, Object itemId) {
		taskToChange.incrementTaskImproveState();
		if (taskToChange.getTaskImproveState() < 3) {
			view.changeRowColor(itemId, "highlight-orange", "highlight-green");
		} else {
			view.changeRowColor(itemId, "highlight-red", "highlight-green");
			taskToChange.setTaskState("NotSolved");
		}
		return taskToChange;
	}

	@Override
	public void setView(TherapyView3 therapyView3) {
		this.view = therapyView3;
	}

}
