package lezione15;

import java.util.function.Consumer;

public class TestElencoDiRoutine {

	public static void main(String[] args) {
		
		ElencoDiRoutine rout = new ElencoDiRoutine();
		
		Consumer<Integer> stampa = i->System.out.println(i);
		
		stampa.accept(rout.esegui(ElencoDiRoutine.funzioni.LEN, "18"));
		stampa.accept(rout.esegui(ElencoDiRoutine.funzioni.SOMMA, "18"));
		stampa.accept(rout.esegui(ElencoDiRoutine.funzioni.TO_INTERO, "18"));
		stampa.accept(rout.esegui(ElencoDiRoutine.funzioni.Y, "18"));
	}
}
