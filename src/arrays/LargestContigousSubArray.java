package arrays;

public class LargestContigousSubArray {
	public static void main(String[] args) {
		int[] array = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int max_so_far = 0;
		int max_ending_here = 0;
		int n = array.length;
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			max_ending_here += array[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
				start = i;
			}

			if (max_ending_here > max_so_far) {
				max_so_far = Math.max(max_so_far, max_ending_here);
				end = i;
			}

		}
		System.out.println(max_so_far);
		System.out.println(start+1 +" - " + end);
	}
}
