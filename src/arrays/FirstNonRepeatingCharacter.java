package arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		String string = "geeksforgeeks";
		String sequence="";
//		HashSet<Character> sequence1 = new LinkedHashSet<>();
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(char ch:string.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
//			if(!sequence1.contains(ch)) {
//				sequence1.add(ch);
//			}
		}
		
		boolean nonRepeating=true;
		boolean repeating=true;
		for(char ch:string.toCharArray()) {
			if(repeating && map.get(ch)>1) {
				System.out.println("First repeated character is " + ch);
				repeating=false;
			}else if(nonRepeating && map.get(ch)==1) {
				System.out.println("First non-repeated character is " + ch);
				nonRepeating=false;
			}
		}
		
		
		
	}
}
