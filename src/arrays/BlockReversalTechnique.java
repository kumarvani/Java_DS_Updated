package arrays;

public class BlockReversalTechnique {

	public static void main(String[] args) {
		int[] array = { 1, 6, 7, 3, 2, 5, 8 };
		int times = 100;
		rotate(array, times);
		print(array);
	}

	public static void print(int[] array) {
		for (int a : array) {
			System.out.print(a + ",");
		}
	}
	
	public static void print(Integer[] array) {
		for (int a : array) {
			System.out.print(a + ",");
		}
	}

	private static void rotate(int[] array, int times) {
		int n = array.length;
		times = times % n;
		reverse(array, 0, times - 1);
		reverse(array, times, n - 1);
		reverse(array, 0, n - 1);
	}

	public static void reverse(int[] array, int start, int end) {
		int temp;
		while (start < end) {
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}

	}
}
