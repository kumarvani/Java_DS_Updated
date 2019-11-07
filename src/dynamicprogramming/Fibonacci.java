package dynamicprogramming;

public class Fibonacci {
	public static long fibonacci(int n) {
		long[] f = new long[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n - 1];
	}

	public static double fibonacciFormula(int n) {
		return Math.pow(((1+Math.sqrt(5))/2),n)/Math.sqrt(5);
	}

	public static void main(String[] args) {
		System.out.println(fibonacciFormula(100));
	}
}
