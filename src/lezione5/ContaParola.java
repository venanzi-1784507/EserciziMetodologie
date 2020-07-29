package lezione5;

public class ContaParola {

	public int contaParola(String testo, String parola) {
		parola = parola.toLowerCase();
		int count = 0;
		String[] parole = testo.split(" ");
		for (int k = 0; k < parole.length; k++)
			count += parole[k].toLowerCase().equals(parola) ? 1 : 0;
		return count;
	}

	public static void main(String[] args) {
		String testo = "ciao gianni come va ? tutto bene ? 41 41 41";
		ContaParola cP = new ContaParola();
		System.out.println(cP.contaParola(testo, "41"));
	}

}
