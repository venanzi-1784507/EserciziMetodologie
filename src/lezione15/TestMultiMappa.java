package lezione15;

public class TestMultiMappa {

	public static void main(String[] args) {
		
		MultiMappa mappa = new MultiMappa();
		mappa.set("uni", 1);
		mappa.set("uni", 11);
		mappa.set("uni", 111);
		
		mappa.set("tres", 33);
		mappa.set("tres", 333);
		mappa.set("tres", 3333);
		mappa.set("tres", 33);
		
		System.out.println(mappa.get("uni"));
		System.out.println(mappa.get("tres"));
		
		System.out.println(mappa.keySet());
		System.out.println(mappa.valueSet());
		System.out.println(mappa.values());
	}
}
