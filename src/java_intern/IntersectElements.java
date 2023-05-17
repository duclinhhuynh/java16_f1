package java_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectElements {
	public static void main(String[] args) {
		int[] a1 = { 2, 8, 9, 1, 6 };
		int[] a2 = { 2, 1, 1, 8, 9 };
		int[] rs = intersect(a1, a2);
		System.out.println(Arrays.toString(rs));
	}

	private static int[] intersect(int[] a, int[] b) {
		sort(a);
		sort(b);
		int j = 0;
		int i = 0;
		List<Integer> rs = new ArrayList<>();
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				rs.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] result = new int[rs.size()];
		for (int k = 0; k < rs.size(); k++) {
			result[k] = rs.get(k);
		}
		return result;
	}

	private static void sort(int[] a) {
		int temp = a[0];
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}
}
