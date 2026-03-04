package it.diegotaioli.events.exceptions;

import java.util.ArrayList;

public class BadRequestException extends Exception{
	
	private ArrayList<String> errors;
	public BadRequestException(ArrayList<String> messages) {
		super("validation error");
		this.errors = messages;
	}
	
	public ArrayList<String> getErrors(){
		return this.errors;
	}

}
