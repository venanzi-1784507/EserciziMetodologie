package lezione9;

public class Gatto extends EssereVivente {
	
	private int lives = 7;
	public int getLives() { return lives; }

	public Gatto() {
		super();
	}
	
	public Gatto(String name, int age, Gender g) {
		super(name, age, g);
	}
	
	@Override
	public Gatto[] siRiproduceCon(EssereVivente e) throws Exception {
		//if e.getClass() isn't == to this one throw an exception
		if(e.getClass() != this.getClass()) throw new Exception("sesso tra specie non ammesso, malandrino.");    
				
		Gatto[] newBorn = new Gatto[random.nextInt(5)+1];
		for(int i = 0; i < newBorn.length; i++)
				newBorn[i] = new Gatto();
		return newBorn;
	}
	
	@Override
	public void muore() {
		if(lives > 0)
			lives--;
		else
			super.muore();
	}

}
