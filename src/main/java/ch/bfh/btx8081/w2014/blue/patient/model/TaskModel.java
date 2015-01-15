package ch.bfh.btx8081.w2014.blue.patient.model;

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
	private String taskGoal;
	private String taskMessage;
	private String taskDate;
	
	/**
	 * A TaskModel can only instanced with a taskState, a taskGoal and a taskDate
	 * @param taskState
	 * @param taskGoal
	 * @param taskDate
	 */
	public TaskModel (String taskState, String taskGoal, String taskDate){
		this.taskState = taskState;
		this.taskGoal = taskGoal;
		this.taskDate = taskDate;
	}
	
	/**
	 * Improve state describes a sub state of a task which has the state "to improve"
	 * @return taskImproveState
	 */
	public int getTaskImproveState() {
		return taskImproveState;
	}
	
	/**
	 * This method increments the sub state of a task which is "to improve"
	 * 
	 */
	public synchronized void incrementTaskImproveState(){
		taskImproveState++;
	}

	/**
	 * 
	 * @param taskImproveState sets the sub state of a task which has the state "to improve"
	 */
	public void setTaskImproveState(int taskImproveState) {
		this.taskImproveState = taskImproveState;
	}

	/**
	 * 
	 * @return taskDate returns the date of a task
	 */
	public String getTaskDate() {
		return taskDate;
	}

	/**
	 * 
	 * @param taskDate sets the date of a task
	 */
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	/**
	 * 
	 * @return taskState the state of a task
	 */
	public String getTaskState() {
		return taskState;
	}
	
	/**
	 * 
	 * @param taskState set the state of a task
	 */
	public void setTaskState(String taskTitle) {
		this.taskState = taskTitle;
	}

	/**
	 * 
	 * @return taskGoal the title of a task (also known as goal)
	 */
	public String getTaskGoal() {
		return taskGoal;
	}

	/**
	 * 
	 * @param taskGoal sets the title of a task (also known as goal)
	 */
	public void setTaskGoal(String taskGoal) {
		this.taskGoal = taskGoal;
	}

	/**
	 * 
	 * @return task Message the message of a task
	 */
	public String getTaskMessage() {
		return taskMessage;
	}

	/**
	 * 
	 * @param taskMessage sets the message of a task
	 */
	public void setTaskMessage(String taskMessage) {
		this.taskMessage = taskMessage;
	}
}