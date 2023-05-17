package java_intern;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		int n = 16;
		if(getHappyNumber(n) ) {
			System.out.println("true");
		}
		else 
			System.out.println("false");
	}
	private static boolean getHappyNumber(int number) {
		Set<Integer> rs = new HashSet<>();
		while(rs.add(number)) {
			int sum = 0;
			while(number > 0) {
				sum += (number % 10) * (number % 10);
				number/=10;
			}
			number = sum;		
		}
		if(number == 1)
			return true;
		return false;
	}
}
