package lezione6;

public class CellaTris {

	private String value;
	private boolean checked;
	
	public CellaTris() {
		value = " ";
		checked = false;
	}
	
	public void changeValue(String v) {
		value = v;
	}
	
	public void check() {
		checked = true;
	}
	
	public boolean isChecked() {
		return checked;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return value.equals(((CellaTris)obj).value);
	}
}
