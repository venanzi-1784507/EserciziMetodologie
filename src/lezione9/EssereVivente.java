package lezione9;

import java.util.Random;

public abstract class EssereVivente {

	public static enum Gender { M, F }
	//mi serve un insieme di dati in cui sono presenti nomi da prendere casualmente
	public static enum Names { ORIANA(Gender.F), MARIO(Gender.M), FRANCO(Gender.M), SILVIA(Gender.F);
		private Gender g;
		
		Names(Gender gender){ g = gender; }
		
		public Gender getGender() { return g; }
	}
	protected int age;
	protected Gender gender;
	protected String name;
	protected Random random = new Random();
	//campo che contrassegna l'essere vivo o morto
	protected boolean isAlive = true;//by defalut when you create a obj of this class it is alive
	
	public int getAge() { return age; }
	public Gender getGender() { return gender; }
	public String getName() { return name; }
	public boolean getIsAlive() { return isAlive; }
	
	public EssereVivente(String name, int age, Gender gender) {
		this.name = name; 
		this.age = age;
		this.gender = gender;
	}
	
	public EssereVivente() {
		Names temp = randomName();
		name = temp.toString();
		gender = temp.getGender();
		age = random.nextInt(100);
	}
	
	private Names randomName() {
		switch(random.nextInt(4)) {
		case 0: return Names.FRANCO;
		case 1: return Names.MARIO;
		case 2: return Names.ORIANA;
		case 3: return Names.SILVIA;
		default: return null;
		}
	}
	
	public void cresce() {
		//if it is already dead it can not grow any more
		if(!getIsAlive()) return;
		
		//30% chance to die
		if(random.nextInt(10) < 3) isAlive = false;
		else age++;
	}
	
	public void mangia() {
		if(!getIsAlive()) System.out.println(name + " è morto e non può mangiare.");
		else
			System.out.println(name + " sta mangiando.");
	}
	
	public abstract EssereVivente[] siRiproduceCon(EssereVivente e) throws Exception;
	
	public void muore() {
		isAlive = false;
	}
}
