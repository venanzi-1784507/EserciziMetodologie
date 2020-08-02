package lezione19;

import java.util.ArrayList;

public class SequenzaDiGradini {

	private ArrayList<Integer> gradini;
	
	public SequenzaDiGradini() {
		gradini = new ArrayList<>();
	}
	
	public void add(Integer i) throws GradinoIrraggiungibileException {
		if(gradini.isEmpty())
			gradini.add(i);
		else {
			//se il gradino è gia' presente
			if(gradini.contains(i))
				return;
			if(Math.abs(gradini.get(gradini.size()-1)-i)!=1)
				throw new GradinoIrraggiungibileException();
			gradini.add(i);
		}
	}
	
	@Override
	public String toString() {
		return gradini.toString();
	}
	
	public static void main(String[] args) {
		
		SequenzaDiGradini sg = new SequenzaDiGradini();
		
		try {
			sg.add(1);
			sg.add(2);
			sg.add(3);
		} catch (GradinoIrraggiungibileException e) {
			e.printStackTrace();
		}
		
		System.out.println(sg);
		
		try {
			sg.add(7);
		}
		catch(GradinoIrraggiungibileException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
