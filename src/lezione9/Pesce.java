package lezione9;

public class Pesce extends EssereVivente {

	public Pesce() {
		super();
	}
	
	public Pesce(String name, int age, Gender g) {
		super(name, age, g);
	}
	
	@Override
	public Pesce[] siRiproduceCon(EssereVivente e) throws Exception {
		//if e.getClass() isn't == to this one throw an exception
		if(e.getClass() != this.getClass()) throw new Exception("sesso tra specie non ammesso, malandrino.");    
						
		Pesce[] newBorn = new Pesce[random.nextInt(71)+30];
		for(int i = 0; i < newBorn.length; i++) newBorn[i] = new Pesce();
		
		return newBorn;
	}

}
