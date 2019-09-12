package arrays;

public class MoveZeroesToEnd {
	public static void main(String[] args) {
		int[] array = { 1, 2, 0, 4, 3, 0, 5, 0 };
		int n = array.length;
		int j = -1, temp = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] != 0) {
				j++;
				temp = array[j];
				array[j] = array[i];
				array[i] = temp;

			}
		}
		BlockReversalTechnique.print(array);
	}
}
