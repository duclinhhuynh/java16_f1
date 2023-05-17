package java_intern;

import java.util.ArrayList;

public class UniqueNumber {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 5, 5, 3, 1};
		
		System.out.println(unique(arr));
	}
	private static ArrayList<Integer> unique(int[] a){
		int[] count = new int[a.length];
		for(int i = 0 ; i < a.length; i++) {
			count[a[i]]++;
		}
		ArrayList<Integer> rs = new ArrayList<>();
		for(int i = 0; i < a.length; i++) {
			if(count[i] == 1) {
				rs.add(i);
			}
		}
		return rs;
	}
	
}
