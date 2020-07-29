package lezione14;

import java.util.Objects;

public class Canzone implements Comparable<Canzone>{

	private String nome;
	private String autore;
	
	public String getNome() { return nome; }
	public String getAutore() { return autore; }
	
	public Canzone(String nome, String autore) {
		this.nome = nome;
		this.autore = autore;
	}
	
	@Override
	public boolean equals(Object obj) {
		//obj is-not-a Canzone
		if(obj.getClass() != getClass())
			return false;
		if(nome.equals(((Canzone)obj).getNome()) && autore.equals(((Canzone)obj).getAutore()))
				return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, autore);
	}
	
	@Override
	public String toString() {
		return "'" + nome + "', scritta da: " + autore;
	}
	
	@Override
	public int compareTo(Canzone arg0) {
		if(nome.equals((arg0.getNome())))
			return autore.compareTo(arg0.getAutore());
		return nome.compareTo(arg0.getNome());
	}
}
