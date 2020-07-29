package lezione9;

public class Fenice extends EssereVivente {

	public Fenice() {
		super();
	}
	
	public Fenice(String name, int age, Gender g) {
		super(name, age, g);
	}
	
	@Override
	public Fenice[] siRiproduceCon(EssereVivente e) throws Exception {
		//if e.getClass() isn't == to this one throw an exception
		if(e.getClass() != this.getClass()) throw new Exception("sesso tra specie non ammesso, malandrino.");    
		
		Fenice[] newBorn = new Fenice[random.nextInt(2)+1];
		for(int i = 0; i < newBorn.length; i++)
			newBorn[i] = new Fenice();
		return newBorn;
	}
	
	public void risorgi() {
		//if I am already alive do nothing
		if(getIsAlive()) return;
		else
			isAlive = true;
	}

}
