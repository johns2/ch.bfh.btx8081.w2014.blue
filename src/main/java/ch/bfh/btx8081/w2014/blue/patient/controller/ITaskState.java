package ch.bfh.btx8081.w2014.blue.patient.controller;

import ch.bfh.btx8081.w2014.blue.patient.gui.TherapyView3;
import ch.bfh.btx8081.w2014.blue.patient.model.TaskModel;

/**
 * 
 * This interface will define the states of the therapy task using the state
 * pattern.
 * 
 * @author Stefan Johner
 *
 */
public interface ITaskState {
	/**
	 * This method will set the accessible view, where the state changes can be performed
	 */
	public void setView(TherapyView3 therapyView);
	
	/**
	 * This method will check a <code>Task</code> of a <code>Therapy</code> as solved
	 * @param itemId 
	 */
	public TaskModel clickDoneButton(TaskModel taskToChange, Object itemId);

	/**
	 * This method will mark <code>Task</code> of a <code>Therapy</code> as unsolved
	 */
	public TaskModel clickNotDoneButton(TaskModel taskToChange, Object itemId);
}