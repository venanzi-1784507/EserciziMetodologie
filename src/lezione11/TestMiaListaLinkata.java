package lezione11;

public class TestMiaListaLinkata {

	public static void main(String[] args) {
		
		MiaListaLinkata mll = new MiaListaLinkata(0);
		mll.add(10);
		mll.add(20);
		mll.add(30);
		mll.add(40);
		mll.add(50);
		mll.add(60);
		mll.add(70);
		mll.add(80);
		mll.add(90);
		
		System.out.println("stampa la lista");
		for(int i: mll)
			System.out.print(i+" ");
		
		System.out.println();
		
		System.out.println("stampa true se la lista contiene 20");
		System.out.println(mll.contains(new Integer(20)));
		
		System.out.println("stampa true se la lista ha rimosso 50");
		System.out.println(mll.remove(new Integer(50)));
		
		System.out.println("stampa la lista");
		for(int i: mll)
			System.out.print(i+" ");
		
		mll.clear();
		
		System.out.println();
		
		System.out.println("stampa la lista");
		for(int i: mll)
			System.out.print(i+" ");
		
		System.out.println();
		
		System.out.println("ora dovrebbe essere vuota");
		
	}
}
