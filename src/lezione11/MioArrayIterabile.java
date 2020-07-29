package lezione11;

import java.util.Iterator;

public class MioArrayIterabile implements Iterable<Integer> {
	
	private int[] array;

	public MioArrayIterabile(int... arr) {
		array = arr;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<>() {
			
			int counter = 0;
			
			@Override
			public boolean hasNext() {
				return counter+1 <= array.length;
			}

			@Override
			public Integer next() {
				return array[counter++];
			}
			
		};
	}
	
	public static void main(String[] args) {
		
		MioArrayIterabile mai = new MioArrayIterabile(0,1,2,3,4,5,6,7,8,9);
		
		for(int i: mai)
			System.out.println("And the number is: " + i);
	}

}
