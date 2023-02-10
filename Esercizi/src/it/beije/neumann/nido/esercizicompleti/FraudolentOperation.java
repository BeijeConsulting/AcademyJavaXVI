package it.beije.neumann.nido.esercizicompleti;

import java.util.Scanner;

public class FraudolentOperation {
	
	// Attributes
	private String action;
	private double cost;
	private int quantity;
	private char operation;
	
	// Methods
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	
	@Override
	public String toString() {
		return (this.action + " " + this.cost + " " + this.quantity + " " + this.operation);
	}
	
	

}
