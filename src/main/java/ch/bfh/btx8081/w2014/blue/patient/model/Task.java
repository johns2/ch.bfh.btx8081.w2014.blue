package ch.bfh.btx8081.w2014.blue.patient.model;

import java.util.Calendar;

import com.vaadin.data.Item;

import ch.bfh.btx8081.w2014.blue.patient.controller.ITherapyState;
import ch.bfh.btx8081.w2014.blue.patient.controller.NotSolved;
import ch.bfh.btx8081.w2014.blue.patient.controller.Solved;
import ch.bfh.btx8081.w2014.blue.patient.controller.ToImprove;

/**
 * This model implements a task for the <code>Therapy</code> class. For
 * implementing the state pattern it uses the interface <code>IState</code> with
 * his subclasses
 * 
 * @author Stefan Johner, johns2@bfh.ch
 *
 */
public class Task {
	private static ITherapyState therapyState;
	private String taskTitle;
	private String taskGoal;
	private String taskMessage;
	private String taskDate;
	
	public Task(){
		
	}
	
	public Task (String taskTitle, String taskGoal){
		this.taskTitle = taskTitle;
		this.taskGoal = taskGoal;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
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

	public ITherapyState getTherapyState() {
		return therapyState;
	}

	public static void setTherapyState(Item taskEntry, String actualState) {
		if (actualState.equals("NotSolved")) {
			therapyState = new NotSolved(taskEntry);
		} else if (actualState.equals("ToImprove")) {
			therapyState = new ToImprove(taskEntry);
		} else {
			therapyState = new Solved(taskEntry);
		}
	}

	public void clickCheckMark() {
		therapyState.clickCheckMark();
	}

	public void clickXMark() {
		therapyState.clickXMark();

	}

	public void changeColor() {
		therapyState.changeColor();
	}
}
