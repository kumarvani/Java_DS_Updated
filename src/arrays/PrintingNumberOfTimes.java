package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintingNumberOfTimes {
	public static void main(String[] args) {
		String s = "A500B600C300";
		List<String> integers = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(s);
		while(matcher.find()) {
			integers.add(matcher.group());
		}
		for(Character ch:s.toCharArray()) {
		}
	}
}
