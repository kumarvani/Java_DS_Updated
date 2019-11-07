package arrays;

public class BinarySearchTechnique {
	public static void main(String[] args) {
		int[] array = { 1, 6, 7, 3, 2, 5, 8 };
		int n = array.length;
		int element = 8;
		int search = search(array, 0, n - 1, element);
	}

	private static int search(int[] array, int low, int high, int element) {
		if (high > low) {
			int mid = (low + high) / 2;
			if (array[mid] == element) {
				System.out.println("Element found at " + mid);
				return mid;
			}
			if (element < array[mid]) {
				return search(array, 0, mid - 1, element);
			}
			return search(array, mid + 1, high, element);
		}
		return -1;
	}
}