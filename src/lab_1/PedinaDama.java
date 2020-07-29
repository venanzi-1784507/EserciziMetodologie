package lab_1;

public class PedinaDama {

	public static enum TIPO { BIANCO("B"), NERO("N"), VUOTA("V"); 
		
		String value;
		
		TIPO(String s){
			value = s;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
	
	private TIPO tipo;
	
	public TIPO getTipo() { return tipo; }
	
	public PedinaDama(TIPO t) {
		tipo = t;
	}
}
