package arrays;

import java.util.HashSet;
import java.util.Set;

public class FindingPairinArray {
	public static void main(String[] args) {
		int[] array = { 10, 20, 35, 50, 75, 80 };
		int n = array.length;
		int value = 70;
//		Set<Integer> integers = new HashSet<>();
//		for (int a : array) {
//			integers.add(a);
//		}
//		for (int i = 0; i < n; i++) {
//			if (integers.contains(value - array[i])) {
//				System.out.println("{" + array[i] + " , " + (value - array[i]) + "}");
//				integers.remove(array[i]);
//			}
//		}

		findPair(array, value);
	}

	private static void findPair(int[] array, int value) {
		int n = array.length;
		int low = 0, high = n - 1;
		while(low<high) {
			int sumValue = array[low]+array[high];
			if(sumValue==value) {
				System.out.println("{" + array[low] + " , " + array[high] + "}");
				low++;
			}
			else if(sumValue>value) {
				high--;
			}else {
				low++;
			}
		}
	}

}
