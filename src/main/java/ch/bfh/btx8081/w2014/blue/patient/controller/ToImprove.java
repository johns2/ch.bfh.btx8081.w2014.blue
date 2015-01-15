package ch.bfh.btx8081.w2014.blue.patient.controller;

import ch.bfh.btx8081.w2014.blue.patient.controller.ITaskState;
import ch.bfh.btx8081.w2014.blue.patient.gui.TherapyView3;
import ch.bfh.btx8081.w2014.blue.patient.model.TaskModel;

/**
 * This controller will implement the methods of a unsolved <code>Task</code>
 * which is to improve.
 * 
 * @author Stefan Johner
 *
 */
public class ToImprove implements ITaskState {
	private TherapyView3 view;

	@Override
	public TaskModel clickDoneButton(TaskModel taskToChange, Object itemId) {
		view.changeRowColor(itemId, "highlight-green", "highlight-orange");
		taskToChange.setTaskState("Solved");
		taskToChange.setTaskImproveState(0);
		return taskToChange;
	}

	@Override
	public TaskModel clickNotDoneButton(TaskModel taskToChange, Object itemId) {
		taskToChange.incrementTaskImproveState();
		if (taskToChange.getTaskImproveState() < 3) {
			System.out.println("substate: " + taskToChange.getTaskImproveState());
			view.changeRowColor(itemId, "highlight-orange", "highlight-orange");
		} else {
			view.changeRowColor(itemId, "highlight-red", "highlight-orange");
			taskToChange.setTaskState("NotSolved");
		}
		return taskToChange;
	}

	@Override
	public void setView(TherapyView3 therapyView3) {
		this.view = therapyView3;
	}

}
