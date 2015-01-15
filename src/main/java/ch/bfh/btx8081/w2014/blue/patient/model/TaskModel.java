package ch.bfh.btx8081.w2014.blue.patient.model;

import java.util.Calendar;

import com.vaadin.data.Item;

import ch.bfh.btx8081.w2014.blue.patient.controller.ITaskState;
import ch.bfh.btx8081.w2014.blue.patient.controller.NotSolved;
import ch.bfh.btx8081.w2014.blue.patient.controller.Solved;
import ch.bfh.btx8081.w2014.blue.patient.controller.ToImprove;

/**
 * This model implements a task for the <code>Therapy</code> class. For
 * implementing the state pattern it uses the interface <code>ITaskState</code> with
 * his subclasses
 * 
 * @author Stefan Johner, johns2@bfh.ch
 *
 */
public class TaskModel {
	private String taskState;
	private int taskImproveState;
	public int getTaskImproveState() {
		return taskImproveState;
	}
	
	public synchronized void incrementTaskImproveState(){
		taskImproveState++;
	}

	public void setTaskImproveState(int taskImproveState) {
		this.taskImproveState = taskImproveState;
	}

	private String taskGoal;
	private String taskMessage;
	private String taskDate;
	
	public TaskModel (String taskState, String taskGoal, String taskDate){
		this.taskState = taskState;
		this.taskGoal = taskGoal;
		this.taskDate = taskDate;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskTitle) {
		this.taskState = taskTitle;
	}

	public String getTaskGoal() {
		return taskGoal;
	}

	public void setTaskGoal(String taskGoal) {
		this.taskGoal = taskGoal;
	}

	public String getTaskMessage() {
		return taskMessage;
	}

	public void setTaskMessage(String taskMessage) {
		this.taskMessage = taskMessage;
	}

//	public ITaskState getTherapyState() {
//		return therapyState;
//	}
//
//	public static void setTherapyState(Item taskEntry, String actualState) {
//		if (actualState.equals("NotSolved")) {
//			therapyState = new NotSolved(taskEntry);
//		} else if (actualState.equals("ToImprove")) {
//			therapyState = new ToImprove(taskEntry);
//		} else {
//			therapyState = new Solved(taskEntry);
//		}
//	}
//
//	public void clickCheckMark() {
//		therapyState.clickDoneButton();
//	}
//
//	public void clickXMark() {
//		therapyState.clickNotDoneButton();
//
//	}
//
//	public void changeColor() {
//		therapyState.changeColor();
//	}
}
