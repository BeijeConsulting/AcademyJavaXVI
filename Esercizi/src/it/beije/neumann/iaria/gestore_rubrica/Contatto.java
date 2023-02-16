package it.beije.neumann.iaria.gestore_rubrica;

public class Contatto {

	private String Nome;
	private String Cognome;
	private String Note;
	private String Telefono;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}
	
	public String getNote() {
		return Note;
	}
	public void setNote(String Note) {
		this.Note = Note;
	}
	
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" Nome: ").append(Nome)
				.append(", Cognome: ").append(Cognome)
				.append(", Note: ").append(Note)
				.append(", Telefono: ").append(Telefono)
				.append("}");

		return builder.toString();
	}
}
