package arrays;

public class MinimumElementInSortedRotatedArray {
	public static void main(String[] args) {
		int[] array = { 5, 1, 2, 3, 4 };
		int n = array.length;
		int min = findMin(array, 0, n - 1);
		System.out.println("Minimum found at : " + min);
	}

	private static int findMin(int[] array, int low, int high) {
		if (high > low) {
			if (low == high) {
				return low;
			}
			int mid = (low + high) / 2;
			
			if (mid < high &&array[mid + 1] < array[mid]) {
				return array[mid + 1];
			}
			
			if (mid > low && array[mid] < array[mid - 1]) {
				return array[mid];
			}


			if (array[mid]<array[high])
				return findMin(array, low, mid - 1);
			return findMin(array, mid + 1, high);
		}
		return -1;

	}
}
