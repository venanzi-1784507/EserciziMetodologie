package lezione5;

import java.util.Arrays;

public class DaCifreALettere {

	private String[] lettere = { "zero", "uno", "due", "tre", "quattro", "cinque", "sei", "sette", "otto", "nove" };
	private String[] cifre = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private String[] decine = { "unità", "dieci", "venti", "trenta", "quaranta", "cinquanta", "sessanta", "settanta",
			"ottanta", "novanta" };
	private String[] teen = { "dieci", "undici", "dodici", "tredici", "quattordici", "quindici", "sedici",
			"diciassette", "diciotto", "diciannove" };

	public String cifreLettere(String cifre) {
		String[] numeri = cifre.split("");
		String ritorno = "";
		for (int i = 0; i < numeri.length; i++)
			ritorno += lettere[Integer.parseInt(numeri[i])];
		return ritorno;
	}

	public String lettereCifre(String numInLet) {
		String[] caratteri = numInLet.split(" ");
		String ritorno = "";
		for (int i = 0; i < caratteri.length; i++) {
			for (int j = 0; j < lettere.length; j++) {
				if (lettere[j].equals(caratteri[i]))
					ritorno += cifre[j];
			}
		}
		return ritorno;
	}

	public String cifreLettereAvanzato(String numero) {
		String[] cifre = numero.split("");
		// se il numero è di una sola unità
		if (cifre.length == 1)
			return this.cifreLettere(numero);
		// se il numero è di una sola decina
		if (cifre.length == 2)
			return decineLettere(cifre);

		if (this.isCento(cifre))
			return "cento";
		if (this.isMille(cifre))
			return "mille";

		if (cifre.length == 3)
			return this.centinaia(cifre);

		return "work in progress";
	}

	private boolean isCento(String[] cifre) {
		return cifre[0].equals("1") && cifre[1].equals("0") && cifre[2].equals("0");
	}

	private boolean isMille(String[] cifre) {
		return cifre[0].equals("1") && cifre[1].equals("0") && cifre[2].equals("0") && cifre[3].equals("0");
	}

	private String decineLettere(String[] numeri) {
		if (numeri[0].equals("1")) {
			for (int k = 0; k < 10; k++)
				if (numeri[0 + 1].equals(this.cifre[k]))
					return teen[k];
		}
		if (numeri[1].equals("0"))
			return decine[Integer.parseInt(numeri[0])];
		String temp = decine[Integer.parseInt(numeri[0])];
		return temp + unita(numeri[1]);
	}

	private String unita(String u) {
		for (int k = 0; k < 10; k++)
			if (u.equals(cifre[k]))
				return lettere[k];
		return "-1";
	}

	private String centinaia(String[] numeri) {
		if (numeri[0].equals("1"))
			return "cento" + this.decineLettere(Arrays.copyOfRange(numeri, 1, 3));
		return unita(numeri[0]) + "cento" + this.decineLettere(Arrays.copyOfRange(numeri, 1, 3));
	}

	public static void main(String[] args) {
		DaCifreALettere dcfal = new DaCifreALettere();
		System.out.println(dcfal.cifreLettere("8452"));
		System.out.println(dcfal.lettereCifre("otto quattro cinque due"));
		System.out.println(dcfal.cifreLettereAvanzato("231"));
	}
}
