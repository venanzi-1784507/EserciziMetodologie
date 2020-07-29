package lezione6;

import java.lang.Object;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class StringUTF8 {
	
	private int[] bytes;
	private String conversione = "";
	
	public StringUTF8(int[] bytes) {
		this.bytes = bytes;
//		conversione = new String(bytes, Charset.forName("UTF-8"));
		for(int i=0;i<bytes.length;i++)
			conversione += new String(new byte[] {(byte)bytes[i] }, Charset.forName("UTF-8")); 
	}
	
	@Override
	public String toString() {
		return conversione;
	}

	public static void main(String[] args) {
		StringUTF8 sutf = new StringUTF8(new int[] {150,101,102,103,104});
		System.out.println(sutf);
	}
}
