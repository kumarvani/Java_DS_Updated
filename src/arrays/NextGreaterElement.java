package arrays;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class NextGreaterElement {
	public static void main(String[] args) {
		int[] array = { 4, 5, 2, 25 };
		Stack<Integer> stack = new Stack<>();
		int n = array.length;
		stack.push(array[0]);
		int next = 0;
		int element = 0;
		for (int i = 1; i < n; i++) {
			next = array[i];
			if (!stack.isEmpty()) {
				element = stack.pop();
				while (element < next) {
					System.out.println(element + " -- > " + next);
					if(stack.isEmpty())
						break;
					element = stack.pop();
				}

				if (element > next) {
					stack.push(element);
				}
			}
			stack.push(next);
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " ---> " +" -1");
		}
	}
}
