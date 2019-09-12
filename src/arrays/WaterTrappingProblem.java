package arrays;

public class WaterTrappingProblem {
	public static void main(String[] args) {
		int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int n = array.length;
		int left_max = 0;
		int right_max = 0;
		int left = 0;
		int right = n - 1;
		int totalWater = 0;
		while (left < right) {
			if (array[left] < array[right]) {
				if (array[left] > left_max) {
					left_max = array[left];
				}
				totalWater += left_max - array[left];
				left++;
			} else {
				if (array[right] > right_max) {
					right_max = array[left];
				}
				totalWater += right_max - array[right];
				right--;
			}
		}
		System.out.println(totalWater);
	}
}
