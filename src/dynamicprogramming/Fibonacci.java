package dynamicprogramming;

public class Fibonacci {
	public static void main(String[] args) {

		printFibonacci();
		System.out.println();
		System.out.println(fibonacci(4));
	}

	static void printFibonacci() {
		int a = 0;
		int b = 1;
		System.out.print(a + " , " + b + " , ");
		int i = 0;
		while (i < 10) {
			a=a+b;
			b=a+b;
			System.out.print(a + " , " + b + " , ");
			i++;
		}
	}

	static int fibonacci(int n) {
		if (n <= 2)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);

	}
}
