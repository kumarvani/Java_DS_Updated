package arrays;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int[] array1 = { 1, 3, 4, 5 };
		int[] array2 = { 2, 4, 6, 8 };
		int n1 = array1.length;
		int n2 = array2.length;
		int[] array3 = new int[n1 + n2];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < n1 && j < n2) {
			if (array1[i] <= array2[j]) {
				array3[k] = array1[i];
				k++;
				i++;
			} else if (array2[j] < array1[i]) {
				array3[k] = array2[j];
				k++;
				j++;
			} else {
				i++;
			}
		}

		while (i < n1) {
			array3[k] = array1[i];
			k++;
			i++;
		}

		while (j < n2) {
			array3[k] = array2[j];
			k++;
			j++;
		}

		BlockReversalTechnique.print(array3);
	}
}
