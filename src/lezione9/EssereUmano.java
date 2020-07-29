package lezione9;

public class EssereUmano extends EssereVivente {

	public EssereUmano() {
		super();
	}
	
	public EssereUmano(String name, int age, Gender g) {
		super(name, age, g);
	}
	
	@Override
	public EssereUmano[] siRiproduceCon(EssereVivente e) throws Exception {
		//if e.getClass() isn't == to this one throw an exception
		if(e.getClass() != this.getClass()) throw new Exception("Sesso tra specie non ammesso, malandrino.");    
		
		//if e.gender == this.gender throw an exception
		if(e.getGender() == this.gender)throw new Exception("Niente sesso per i gay."); 
		
		EssereUmano[] newBorn = new EssereUmano[random.nextInt(2)+1];
		for(int i = 0; i < newBorn.length; i++)
			newBorn[i] = new EssereUmano();
		return newBorn;
	}

}
