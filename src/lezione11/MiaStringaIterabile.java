package lezione11;

import java.util.Iterator;

public class MiaStringaIterabile implements Iterable<Character>{

	private String stringa;
	
	public MiaStringaIterabile(String stringa) {
		this.stringa = stringa;
	}
	
	@Override
	public Iterator<Character> iterator() {
		return new StringaIterator(this);
	}
	
	
	class StringaIterator implements Iterator<Character>{

		private MiaStringaIterabile msi;
		private int counter;
		
		public StringaIterator(MiaStringaIterabile msi) {
			this.msi = msi;
		}
		
		@Override
		public boolean hasNext() {
			return counter+1 <= msi.stringa.length();
		}

		@Override
		public Character next() {
			return msi.stringa.charAt(counter++);
		}
		
	}
	
	public static void main(String[] args) {
		
		MiaStringaIterabile msi = new MiaStringaIterabile("giacomo!");
		
		//stampa tutto in colonna
//		for(char c: msi)
//			System.out.println(c);

		for(char c: msi) {
			System.out.println(c);
			for(char s: msi)
				System.out.println(s);
		}
	}

}
