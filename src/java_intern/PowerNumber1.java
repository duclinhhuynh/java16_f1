package java_intern;

public class PowerNumber1 {
	public static void main(String[] args) {
		int a = 8;
		int b = 2;
		System.out.println(isPowerOf(a, b));
		System.out.println(power(b,a));
	}
	
	private static boolean isPowerOf(int a, int b) {
		if(a == 1 && b == 1) {
			return true;
		}
		if(a == 0 && b == 0) {
			return false;
		}
		if(a == b) {
			return true;
		}
		if(a % b == 0){
			return isPowerOf(a/b, b);
		}
		if(b % a == 0) {
			return isPowerOf(a, b/a);
		}
		return false;
	}
	private static boolean isPower(int a, int b) {
		double rs = Math.log(a) / Math.log(b);
		return Math.floor(rs) == Math.ceil(rs);
	}
	private static boolean power(int a, int b) {
		if(a * b > 1) {
			return a > b ? isPower(a,b) : isPower(b,a);
		}
		else
			return b > a ? isPower(b,a) : isPower(a,b);
	}
}
