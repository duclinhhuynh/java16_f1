package java_intern;

public class Lcm {
	public static void main(String[] args) {
		int [] numbers = {2, 4, 6, 6 };
		int rs = findlcm(numbers);
		System.out.println(rs);
	}

	private static int gcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
			
	private static int findlcm(int ...numbers) {
		int temp = lcm(numbers[0], numbers[1]);
		for(int i = 2; i < numbers.length; i++) {
			temp = lcm(temp,numbers[i]);
		}
		return temp;
	}
}
