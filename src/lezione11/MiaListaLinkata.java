package lezione11;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MiaListaLinkata implements List<Integer> {

	class Elemento {
		//riferimento al successore
		public Elemento next;
		private int value;
		
		public Elemento(int val, Elemento el) {
			value = val;
			next = el;
		}
	}
	
	private Elemento primo;
	
	public MiaListaLinkata(int val) {
		primo = new Elemento(val, null);
	}
	
	@Override
	public boolean add(Integer arg0) {
		if(arg0 == null) return false;
		Elemento e = new Elemento(arg0, null);
		//se la lista è vuoto diventa il primo
		if(primo == null) {
			primo = e;
			return true;
		}
		
		//altrimenti lo inserisco in testa
		e.next = primo;
		primo = e;
		return true;
	}

	@Override
	public void add(int arg0, Integer arg1) {
		Elemento count = primo;
		
		for(int i = 1; i< arg0; i++) {
			count = count.next;
		}
		
		Elemento e = new Elemento(arg1, null);
		e.next = count;
		count = e;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends Integer> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		primo = null;//non sono sicuro da verificare
	}

	@Override
	public boolean contains(Object arg0) {
		if(!(arg0 instanceof Integer))
			return false;
		
		Elemento e = primo;
		while(e != null) {
			if(e.value == (int)arg0)
				return true;
			e = e.next;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		
//		for(Integer i: arg0)
		return false;
	}

	@Override
	public Integer get(int arg0) {
		if(arg0 == 0)
			return primo.value;
		
		Elemento e = primo;
		for(int i=1; i<arg0; i++)
			e = e.next;
		
		return e.value;
	}

	@Override
	public int indexOf(Object arg0) {
		if(!(arg0 instanceof Integer))
			return -1;
		if(primo.value == (int)arg0)
			return 0;
		Elemento e = primo;
		int count = 0;
		while(e != null) {
			if(e.value == (int)arg0)
				return count;
			count++;
			e = e.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return primo == null;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<>() {

			private Elemento currentEl = primo; //puntatore personale agli elementi di questa classe anonima
			
			@Override
			public boolean hasNext() {
				return currentEl != null;
			}

			@Override
			public Integer next() {
				int temp = currentEl.value;
				currentEl = currentEl.next;
				return temp;
			}
			
		};
	}

	@Override
	public int lastIndexOf(Object arg0) {
		if(!(arg0 instanceof Integer))
			return -1;
		int last = -1;
		Elemento e = primo;
		int count = 0;
		while(e != null) {
			if(e.value == (int)arg0)
				last = count;
			count++;
			e = e.next;
		}
		
		return last;
	}

	@Override
	public ListIterator<Integer> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Integer> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		if(!(arg0 instanceof Integer))
			return false;
		
		Elemento prevE = null;
		Elemento e = primo;
		while(e != null) {
			if(e.value == (int)arg0) {
				prevE.next = e.next;
				return true;
			}
			prevE = e;
			e = e.next;
		}
		return false;
	}

	@Override
	public Integer remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer set(int arg0, Integer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
