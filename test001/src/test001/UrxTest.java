package test001;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UrxTest {
	public static void main(String[] args) {
		String s = "aadf63433";
		if(s.matches("[a-zA-Z]+//d+")) {
			System.out.println("match");
		}else {
			System.out.println("dis match");
		}
		Pattern p = Pattern.compile("[a-zA-Z]{4}\\d{5}");
		Matcher m = p.matcher(s);
		System.out.println(m.matches());
	}
}
