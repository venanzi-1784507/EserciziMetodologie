package lezione8;

public class TestBarra {

	public static void main(String[] args) {
		
		BarraDiEnergia be = new BarraDiEnergia(10);
		BarraDiEnergiaConPercentuale bep = new BarraDiEnergiaConPercentuale(10);
		System.out.println(be);
		System.out.println(bep);
		
		be.increase();
		be.increase();
		System.out.println(be);
		
		bep.increase();
		bep.increase();
		System.out.println(bep);
		
		be.increase();
		be.increase();
		be.increase();
		be.increase();
		be.increase();
		be.increase();
		be.increase();
		be.increase();
		System.out.println(be);
		
		bep.increase();
		bep.increase();
		bep.increase();
		bep.increase();
		bep.increase();
		bep.increase();
		bep.increase();
		bep.increase();
		System.out.println(bep);
	}
}
