package ch.bfh.btx8081.w2014.blue.patient.controller;

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
	 * This method will check a <code>Task</code> of a <code>Therapy</code> and
	 * describe them as solved
	 */
	public void clickCheckMark();

	/**
	 * This method will mark <code>Task</code> of a <code>Therapy</code> with a
	 * X and describe them as unsolved
	 */
	public void clickXMark();

	/**
	 * This method will change the color of a <code>Task</code> where is part of
	 * a <code>Therapy</code>
	 */
	public void changeColor();
}