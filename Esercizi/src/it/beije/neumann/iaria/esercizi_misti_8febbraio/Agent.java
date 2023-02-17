package it.beije.neumann.iaria.esercizi_misti_8febbraio;

public class Agent {

	private String action;
	private String amount;
	private String quantity;
	private String operation;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" Azione: ").append(action)
				.append(", Importo: ").append(amount)
				.append(", Quantità: ").append(quantity)
				.append(", Operazione: ").append(operation)
				.append("}");

		return builder.toString();
	}
}