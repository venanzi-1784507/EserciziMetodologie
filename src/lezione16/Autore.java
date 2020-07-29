package lezione16;

public class Autore {

	private String nome;
	private String cognome;
	
	public String getNome() { return nome; }
	public String getCognome() { return cognome; }
	
	public Autore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != getClass()) return false;
		return nome == ((Autore)obj).nome && cognome == ((Autore)obj).cognome;
	}
	
	@Override
	public String toString() {
		return "nome: " + nome + ", cognome: " + cognome;
	}
}
