package lezione9;

public class PescePagliaccio extends Pesce {

	public PescePagliaccio() {
		super();
	}
	
	public PescePagliaccio(String name, int age, Gender g) {
		super(name, age, g);
	}
	
	public void changeGender() {
		System.out.println("I'm changing gender but I'm not actually gay");
		
		gender  = gender == Gender.M? Gender.F: Gender.M;
	}
	
	@Override
	public void cresce() {
		super.cresce();
		
		//if I'm still alive, I have 50% chances of change gender
		if(random.nextBoolean()) 
			changeGender();
	}
}
