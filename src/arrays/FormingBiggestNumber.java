package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class FormingBiggestNumber {
	public static void main(String[] args) {
		Integer[] array = { 54, 546, 548, 60 };
		Comparator<Integer> comparator = (i1,i2)->{
			String x = i1.toString();
			String y = i2.toString();
			return -x.compareTo(y);
		};
		Arrays.sort(array, comparator);
		BlockReversalTechnique.print(array);
	}
}
