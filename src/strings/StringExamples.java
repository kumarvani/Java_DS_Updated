package strings;
import java.util.Stack;

public class StringExamples {
	
	static void reverseWord() {
		String s = "WORD"; //DROW
		StringBuilder builder =  new StringBuilder();
		Stack<Character> stack =  new Stack<>();
		char[] charArray = s.toCharArray();
		for(Character ch:charArray)
			stack.push(ch);
		while(!stack.isEmpty())
			builder.append(stack.pop());
		System.out.println(builder.toString());
	}
	
	static void reverseSentence() {
		String s = "This is a sentence"; // sentence is a this
		StringBuilder builder =  new StringBuilder();
		Stack<String> stack =  new Stack<>();
		String[] strings = s.split(" ");
		for(String ch:strings)
			stack.push(ch);
		while(!stack.isEmpty())
			builder.append(stack.pop());
		System.out.println(builder.toString());
	}
	
	static void reverseSentenceEachWord() {
		String s = "This is a sentence"; // siht si a ecnetnes
		StringBuilder builder =  new StringBuilder();
		String[] strings = s.split(" ");
		for(String ch:strings)
			builder.append(new StringBuilder(ch).reverse());
		System.out.println(builder.toString());
	}
}