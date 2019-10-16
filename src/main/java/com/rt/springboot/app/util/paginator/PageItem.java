package com.rt.springboot.app.util.paginator;

public class PageItem {
	
	private int number;
	private boolean actual;
	
	/*----- Constructor -----*/
	public PageItem(int number, boolean actual) {
		this.number = number;
		this.actual = actual;
	}

	/*----- Getters & Setters -----*/
	public int getNumber() { return number; }
	
	public void setNumber(int number) { this.number = number; }
	
	public boolean isActual() { return actual; }
	
	public void setActual(boolean actual) { this.actual = actual; }

}
