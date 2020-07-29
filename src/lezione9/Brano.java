package lezione9;

public class Brano {

	private String nomeCanzone;
	private String nomeCantante;
	
	public Brano(String canzone, String cantante) {
		nomeCanzone = canzone;
		nomeCantante = cantante;
	}
	
	public String getNomeCanzone() { return nomeCanzone; }
	public String getCantante() { return nomeCantante; }
	
	@Override
	public String toString() {
		return "nome canzone: " + nomeCanzone + ", nome cantante: " + nomeCantante;
	}
}
