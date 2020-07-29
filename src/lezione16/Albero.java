package lezione16;

import java.util.ArrayList;

public class Albero {

	Nodo root;
	
	public Albero(Nodo root) {
		this.root = root;
	}
	
	/**
	 * cerca nell'albero usando una DFS
	 * @param i
	 * @return
	 */
	public boolean contiene(int i) {
		//caso base controllo se è in questo nodo
		if(root.valore == i) return true;
		return dfs(root, i);
	}
	
	private boolean dfs(Nodo node, int i) {
		//se è in questo nodo l'ho trovato e ritorno true
		if(node.valore == i) return true;
		//altrimenti itero i figli
		for(Nodo figlio: node.figli) {
			if(dfs(figlio, i)) return true;
		}
		//se non è nei figli di questo nodo 
		return false;
	}
	
	public void rimuovi(int i) {
		//anche qui cerco il nodo se è la root 
		rimuoviRicorsivo(root, i);
	}
	
	private boolean rimuoviRicorsivo(Nodo n, int i) {
		//caso base_1: se è questo nodo ed è la root
		if(n.padre == null && n.valore == i) {
			//metto il primo figlio in una variabile temporanea
			Nodo temp = n.figli.get(0);
			//lo rimuovo dai figli del padre
			n.figli.remove(0);
			//gli aggiungo i restanti figli del padre
			temp.figli.addAll(n.figli);
			//lo faccio diventare la nuova root
			root = temp;
			return true;
		}
		
		//caso base_2: se il nodo trovato non è la root e ha figli
		if(n.valore == i) {
			//tolgo il nodo da rimuovere dai figli di suo padre
			n.padre.figli.remove(n);
			//se il nodo ha figli
			if(!n.figli.isEmpty())
				//inserisco i suoi figli tra i figli del padre
				n.padre.figli.addAll(n.figli);
		}
		
		//caso ricorsivo
		//se il nodo non è questo passo ai figli
		for(Nodo figlio: n.figli) {
			//se era uno dei figli o dei figli dei figli ritorno
			if(rimuoviRicorsivo(figlio, i))
				return true;
		}
		//altrimenti
		return false;
	}
	
	public void aggiungi(int... valori) {
		Nodo inizio = root;
		for(int i: valori) {
			Nodo temp = aggiungiNodo(inizio, inizio, i);
			//se mi ritorna l'inizio allora o ha trovato un nodo oppure no e mi ritorna l'iniziale perchè non ha trovato niente
			if(inizio.valore == i) continue;
			else if(temp.valore == i) {
				inizio = temp;
				continue;
			}
			Nodo nuovo = new Nodo(temp, i);
			temp.figli.add(nuovo);
			inizio = nuovo;
		}
	}
	
	
	private Nodo aggiungiNodo(Nodo iniziale, Nodo n, int i) {
		//se il nodo in cui mi trovo ha già questo valore è già aggiunto
		if(n.valore == i)
			return n;
		//altrimenti controllo se è tra i figli e se non lo è lo aggiungo
		for(Nodo figlio: n.figli) {
			if(aggiungiNodo(iniziale, figlio, i) != null)
				return figlio;
		}
		
		//se sono il nodo iniziale e arrivo qui vuol dire che non ho trovato il nodo nell'albero
		if(n == iniziale) {
			//allora ritorno al chiamante e aggiungo li il nuovo nodo
			return iniziale;
		}
		//altrimenti 
		return null;
	}
	
	public void stampa() {
		root.stampa();
	}
	
	public static class Nodo {
		
		private Nodo padre;
		private ArrayList<Nodo> figli;
		private int valore;
		
		public Nodo(Nodo padre, int valore) {
			this.padre = padre;
			this.valore = valore;
			figli = new ArrayList<>();
		}
		
		public void add(Nodo figlio) {
			figli.add(figlio);
		}
		
		public void stampa() {
			System.out.println(this.toString());
			for(Nodo n: figli)
				n.stampa();
		}
		
		@Override
		public String toString() {
			return "VALORE: " + valore + " FIGLIO DI: " +  (padre == null? "null": padre.valore);
		}
	}
}
