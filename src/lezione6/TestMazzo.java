package lezione6;

public class TestMazzo {

	public static void main(String[] args) {
		MazzoDiCarte mazzo = new MazzoDiCarte();
		mazzo.stampaMazzo();
		System.out.println();
		System.out.println(mazzo.distribuisci());
		mazzo.mescola();
		System.out.println();
		mazzo.stampaMazzo();
		System.out.println();
		System.out.println(mazzo.distribuisci());
		System.out.println();
		mazzo.stampaMazzo();
	}
}
