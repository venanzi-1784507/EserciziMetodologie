package finoLezione4;
// in questo package webinar 1 ci saranno gli esercizi delle lezioni che

// sono state svolte precedentemente al webinar

public class HelloWorld {

	int x;
	String name;

	public HelloWorld() {
		x = 10;
		name = "carlo";
	}

	public HelloWorld(String name) {
		this();
		this.name = name;
	}

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		HelloWorld hw = new HelloWorld("nicola");
		System.out.println(hw.x);
		System.out.println(hw.name);

	}
}
