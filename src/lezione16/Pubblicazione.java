package lezione16;

import java.util.Objects;

public class Pubblicazione {

	private String titolo;
	private Autore[] autori;
	private String sede;
	private int anno;
	private int numCitazioni;
	
	public int getNumCitazioni() { return numCitazioni; }
	public void addCitazione() { numCitazioni++; }
	public int getAnno() { return anno; }
	public Autore[] getAutori() { return autori; }
	public String getTitolo() { return titolo; }
	public String getSede() { return sede; }
	
	public Pubblicazione(String titolo, String sede, int anno, Autore... autori) {
		this.titolo = titolo;
		this.autori = autori;
		this.sede = sede;
		this.anno = anno;
	}
	
	public Pubblicazione(String titolo, String sede, int anno, int citazioni, Autore... autori) {
		this(titolo, sede, anno, autori);
		this.numCitazioni = citazioni;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titolo, sede, anno, autori);
	}
}
