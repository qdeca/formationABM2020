package fr.abm.firstproject;

public class FactoMain {

	public static void main(String[] args) {
		System.out.println(factorielle1(5));
		System.out.println(factorielle2(5));
		System.out.println(factorielle3(5));
		System.out.println(factorielle4(5));
	}
	
	// 5! = 1*2*3*4*5
	// 10! = 1*2*3*4*5*6*7*8*9*10
	
	public static int factorielle1(int n) {
		int result = 1;
		while (n>1) {
			result *= n;
			n--;
		}
		return result;
	}
	
	public static int factorielle2(int n) {
		int result = 1;
		do {
			result *= n;
			n--;
		} while (n>1);
		return result;
	}
	
	public static int factorielle3(int n) {
		int result = 1;
		for (int i=1; i<=n; i++ ) {
			result *= i;
		}
		return result;
	}
	
	// exemple de fonction récursive
	public static int factorielle4(int n) {
		if (n==1) {
			return 1;
		} else {
			return factorielle4(n-1) * n;
		}
	}
}
