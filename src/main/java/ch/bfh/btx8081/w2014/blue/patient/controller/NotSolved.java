package ch.bfh.btx8081.w2014.blue.patient.controller;

import com.vaadin.data.Item;

import ch.bfh.btx8081.w2014.blue.patient.controller.ITherapyState;

/**
 * This controller will implement the methods of a unsolved <code>Task</code>
 * 
 * @author Stefan Johner
 *
 */
public class NotSolved implements ITherapyState {
	private Item taskEntry;
	public NotSolved(Item taskEntry) {
		this.taskEntry = taskEntry;
	}

	@Override
	public void clickCheckMark() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickXMark() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeColor() {
		// TODO Auto-generated method stub

	}

	public void showFeedbackForm() {

	}

}
