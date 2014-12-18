package ch.bfh.btx8081.w2014.blue.patient.controller;

import com.vaadin.data.Item;

/**
 * This controller will implement the methods of a solved <code>Task</code>
 * 
 * @author Stefan Johner
 *
 */
public class Solved implements ITherapyState {

	private Item taskEntry;
	public Solved(Item taskEntry) {
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

}
