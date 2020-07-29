package finoLezione4;

public class RegistratoreDiCassa {

	private float conto;
	private float ultimoResto;
	private String articoli;

	public RegistratoreDiCassa() {
		conto = ultimoResto = 0;
		articoli = "";
	}

	public float getConto() {
		return conto;
	}

	/**
	 * 
	 * @return nomi degli articoli attualmente già passati alla cassa dall'ultimo
	 *         cliente
	 */
	public String getArticoli() {
		return articoli;
	}

	/**
	 * 
	 * @return ultimo resto che la cassa ha restituito all'ultimo cliente
	 */
	public float getUltimoResto() {
		return ultimoResto;
	}

	public void aggiungiArticolo(float prezzo, String nome) {
		conto += prezzo;
		articoli += nome + " ";
	}

	/**
	 * metodo che fa pagare il cliente se inserisce una somma sufficiente per
	 * pagare. poi cancella la lista di articoli e il conto da pagare, per
	 * processare il prossimo cliente, salvando comunque l'ultimo resto dato
	 * all'ultimo cliente
	 * 
	 * @param denaro somma di denaro con cui il cliente intende pagare
	 * @return il resto che la cassa restituisce al cliente, ritorna -1 se la somma
	 *         in input non è sufficiente
	 */
	public float paga(float denaro) {
		if (denaro < 0)
			return -1;
		ultimoResto = denaro - conto;
		System.out.println(articoli.substring(0, articoli.length() - 1));
		articoli = "";
		conto = 0;
		return ultimoResto;
	}

	public static void main(String[] args) {

		RegistratoreDiCassa rdc = new RegistratoreDiCassa();
		System.out.println(rdc.getArticoli());
		rdc.aggiungiArticolo(23.4f, "pompelmo");
		rdc.aggiungiArticolo(2, "candeggina");
		System.out.println(rdc.getConto());
		System.out.println(rdc.getUltimoResto());
		rdc.paga(50);
		System.out.println(rdc.getArticoli());
		System.out.println(rdc.getConto());
		System.out.println(rdc.getUltimoResto());
	}
}
