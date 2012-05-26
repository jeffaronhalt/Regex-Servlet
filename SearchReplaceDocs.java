

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplaceDocs {

	protected Pattern pattern;
	protected Matcher matcher;
	protected String replacement;
	
	public static void main(String args[]) {
		SearchReplaceDocs srd;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Enter REGEX : ");
			String regex = scan.next();
			System.out.println("Enter REPLACEMENT : ");
			String rep = scan.next();
			System.out.println("Enter Text to search and replace: ");
			String text = scan.next();
		
			srd = new SearchReplaceDocs(regex, rep, text);
			System.out.println(srd.replaceAndPrint());
		}
		
	}
	
	public SearchReplaceDocs(String regEx, String r, String DocText) {
		pattern = Pattern.compile(regEx);
		matcher = pattern.matcher(DocText);
		replacement = r;
	}

	public String replaceAndPrint() {
		return matcher.replaceAll(replacement);
	}

	public void setRegexPattern(String p) {
		pattern = Pattern.compile(p);
	}

	public String getRegexPattern() {
		return pattern.toString();
	}

	public void setMatcher(String m) {
		matcher = pattern.matcher(m);
	}

	public String getMatcher() {
		return matcher.toString();
	}

	public void setReplacement(String r) {
		replacement = r;
	}

	public String getReplacement() {
		return replacement;
	}

}
