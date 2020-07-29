package lezione6;

import java.util.Arrays;

public class MioArray {
	
	private int[] mioArray;
	
	public MioArray(int[] array) {
		mioArray = array;
	}
	
	public boolean contiene(int posizione, int elemento) {
		if(mioArray.length <= posizione) return false;
		return mioArray[posizione] == elemento;
	}
	
	public int somma2() {
		switch(mioArray.length) {
		case 0: return 0;
		case 1: return mioArray[0];
		default: return mioArray[0] + mioArray[1];
		}
	}
	
	public void scambia(int pos1, int pos2) {
		if(pos1 >= mioArray.length || pos2 >= mioArray.length) return;
		int temp = mioArray[pos1];
		mioArray[pos1] = mioArray[pos2];
		mioArray[pos2] = temp;
		return;
	}
	
	public int maxTripla() {
		if(mioArray.length == 0) return 0;
		int max = mioArray[0];
		int len = mioArray.length;
		max = max < mioArray[len-1]? mioArray[len-1]: max;
		if(len % 2 == 0) {
			max = max < mioArray[len/2]? mioArray[len/2]: max;
			max = max < mioArray[len/2 -1]? mioArray[len/2 -1]: max;
		}
		else
			max = max < mioArray[len/2]? mioArray[len/2]: max;
		return max;
	}
	
	public int[] falloInDue() {
		if(mioArray.length == 0) return new int[] {};
		return new int[] {mioArray[0], mioArray[mioArray.length-1]};
	}
	
	@Override
	public String toString() {
		return Arrays.toString(mioArray);
	}
	
	public static void main(String[] args) {
		MioArray ma = new MioArray(new int[] {1,7,5,3,0,2,2});
		
		System.out.println(ma);
		System.out.println(ma.contiene(0, 1));
		System.out.println(ma.somma2());
		ma.scambia(0, 6);
		System.out.println(ma);
		System.out.println(ma.maxTripla());
		System.out.println(Arrays.toString(ma.falloInDue()));
	}

}
