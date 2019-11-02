package za.ac.sun.cs.regexagent;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;


public class TestRegexExtract {

    @Test
    public void MatcherFindStartEndExample() {
        String text = "This is the text which is to be searched "
                + "for occurrences of the word 'is'.";
        String patternString = "is";

        Pattern pattern = Pattern.compile("is");
        Matcher matcher = pattern.matcher(patternString);

        for (int i = 0; i < 3; i++) matcher.find();
    }

//    @Test
//    public void MatcherFindGroupExample() {
//
//        String text = "John writes about this, and John writes about that,"
//                + " and John writes about everything. ";
//        String patternString1 = "(a|b)*c+";
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//        matcher.matches();
//
//        while (matcher.find()) {
//            System.out.println("found: " + matcher.group(1));
//        }
//    }

//    @Test
//    public void MatcherFindMultipleGroupsExample() {
//
//        String text = "John writes about this, and John Doe writes about that,"
//                + " and John Wayne writes about everything.";
//
//        String patternString1 = "(John) (.+?) ";
//
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//
//        while (matcher.find()) {
//            System.out.println("found: " + matcher.group(1) + " "
//                    + matcher.group(2));
//        }
//    }
//
//    @Test
//    public void MatcherFindNestedGroupsExample() {
//
//        String text = "John writes about this, and John Doe writes about that,"
//                + " and John Wayne writes about everything.";
//
//        String patternString1 = "((John) (.+?)) ";
//
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//
//        while (matcher.find()) {
//            System.out.println("found: <" + matcher.group(1) + "> <"
//                    + matcher.group(2) + "> <" + matcher.group(3) + ">");
//        }
//    }
//
//    @Test
//    public void MatcherFindReplaceAllFirstExample() {
//
//        String text = "John writes about this, and John Doe writes about that,"
//                + " and John Wayne writes about everything.";
//
//        String patternString1 = "((John) (.+?)) ";
//
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//
//        String replaceAll = matcher.replaceAll("Joe Blocks ");
//        System.out.println("replaceAll   = " + replaceAll);
//
//        String replaceFirst = matcher.replaceFirst("Joe Blocks ");
//        System.out.println("replaceFirst = " + replaceFirst);
//    }
//
//    @Test
//    public void MatcherFindAppendReplaceTailExample() {
//
//        String text = "John writes about this, and John Doe writes about that,"
//                + " and John Wayne writes about everything.";
//
//        String patternString1 = "((John) (.+?)) ";
//
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//        StringBuffer stringBuffer = new StringBuffer();
//
//        while (matcher.find()) {
//            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
//            System.out.println(stringBuffer.toString());
//        }
//        matcher.appendTail(stringBuffer);
//
//        System.out.println(stringBuffer.toString());
//    }
//
//    @Test
//    public void MatcherMatchesExample() {
//
//        String text = "This is the text to be searched "
//                + "for occurrences of the http:// pattern.";
//
//        String patternString = ".*http://.*";
//
//        Pattern pattern = Pattern.compile(patternString);
//
//        Matcher matcher = pattern.matcher(text);
//        boolean matches = matcher.matches();
//
//        Pattern p=matcher.pattern();
//        System.out.println(p);
//        System.out.println(matcher);
//        System.out.println(matcher.group());
//    }
//
//    public void MatcherMatchesExample(Pattern pattern) {
//        String text = "This is the text to be searched "
//                + "for occurrences of the http:// pattern.";
//        Matcher matcher = pattern.matcher(text);
//        boolean matches = matcher.matches();
//
//        Pattern p=matcher.pattern();
//        System.out.println(p);
//        System.out.println(matcher);
//        System.out.println(matcher.group());
//    }
//
//    public void MatcherMatchesExample(Matcher matcher) {
//        boolean matches = matcher.matches();
//
//        Pattern p=matcher.pattern();
//        System.out.println(p);
//        System.out.println(matcher);
//        System.out.println(matcher.group());
//    }
//
//    /**
//     * The Matcher lookingAt() method works like the matches() method with one
//     * major difference. The lookingAt() method only matches the regular
//     * expression against the beginning of the text, whereas matches() matches
//     * the regular expression against the whole text. In other words, if the
//     * regular expression matches the beginning of a text but not the whole
//     * text, lookingAt() will return true, whereas matches() will return false.
//     *
//     * @param args
//     */
//    @Test
//    public void MatcherLookingAtExample() {
//
//        String text = "This is the text to be searched "
//                + "for occurrences of the http:// pattern.";
//
//        String patternString = "This is the";
//
//        Pattern pattern = Pattern.compile(patternString,
//                Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(text);
//
//        System.out.println("lookingAt = " + matcher.lookingAt());
//        System.out.println("matches   = " + matcher.matches());
//    }
//
//    @Test
//    public void PatternMatchesExample() {
//
//        String text = "This is the text to be searched "
//                + "for occurrences of the pattern.";
//
//        String pattern = ".*is.*";
//
//        boolean matches = Pattern.matches(pattern, text);
//
//        System.out.println("pattern matches = " + matches);
//    }
//
//    /**
//     * pattern compile w/o flags: int java.util.regex.Pattern flags() Returns
//     * this pattern's match flags. Modifier&Type Field and Description static
//     * int CANON_EQ Enables canonical equivalence. static int CASE_INSENSITIVE
//     * Enables case-insensitive matching. static int COMMENTS Permits whitespace
//     * and comments in pattern. static int DOTALL Enables dotall mode. static
//     * int LITERAL Enables literal parsing of the pattern. static int MULTILINE
//     * Enables multiline mode. static int UNICODE_CASE Enables Unicode-aware
//     * case folding. static int UNICODE_CHARACTER_CLASS Enables the Unicode
//     * version of Predefined character classes and POSIX character classes.
//     * static int UNIX_LINES Enables Unix lines mode.
//     *
//     * @param args
//     */
//    @Test
//    public void PatternCompileExample() {
//
//        String text = "This is the text to be searched "
//                + "for occurrences of the http:// pattern.";
//
//        String patternString = ".*http://.*";
//
//        Pattern pattern = Pattern.compile(patternString);
//        Pattern pattern2 = Pattern.compile(patternString,
//                Pattern.CASE_INSENSITIVE);
//    }
//
//    @Test
//    public void PatternMatcherExample() {
//
//        String text = "This is the text to be searched "
//                + "for occurrences of the http:// pattern.";
//
//        String patternString = ".*http://.*";
//
//        Pattern pattern = Pattern.compile(patternString,
//                Pattern.CASE_INSENSITIVE);
//
//        Matcher matcher = pattern.matcher(text);
//
//        boolean matches = matcher.matches();
//
//        System.out.println("matcher matches = " + matches);
//    }
//
//
//    public Matcher getPatternMatcher() {
//
//        String text = "This is the text to be searched "
//                + "for occurrences of the http:// pattern.";
//
//        String patternString = ".*http://.*";
//
//        Pattern pattern = Pattern.compile(patternString,
//                Pattern.CASE_INSENSITIVE);
//
//        Matcher matcher = pattern.matcher(text);
//        return matcher;
//    }
//
//    @Test
//    public void PatternSplitExample() {
//
//        String text = "A sep Text sep With sep Many sep Separators";
//
//        String patternString = "sep";
//        Pattern pattern = Pattern.compile(patternString);
//
//        String[] split = pattern.split(text);
//
//        System.out.println("split.length = " + split.length);
//
//        for (String element : split) {
//            System.out.println("element = " + element);
//        }
//    }
//
//    @Test
//    public void StringMatchesExample() {
//        List<String> input = new ArrayList<String>();
//        input.add("123-45-6789");
//        input.add("9876-5-4321");
//        input.add("987-65-4321 (attack)");
//        input.add("987-65-4321 ");
//        input.add("192-83-7465");
//
//        for (String ssn : input) {
//            if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
//                System.out.println("Found good SSN: " + ssn);
//            }
//        }
//    }
//
//    @Test
//    public void StringMatchesMoreExample() {
//        String str = new String("The quick brown fox jumps over the lazy dog.");
//        System.out.println();
//        System.out.print("Regex: (.*)quick brown fox(.*) ");
//        System.out.println(str.matches("(.*)quick brown fox(.*)"));
//
//        System.out.print("Regex: (.*)quick brown wolf(.*) ");
//        System.out.println(str.matches("(.*)quick brown wolf(.*)"));
//        System.out.println();
//
//        str = new String("Java String Methods");
//
//        System.out.print("Regex: (.*)String(.*) matches string? ");
//        System.out.println(str.matches("(.*)String(.*)"));
//
//        System.out.print("Regex: (.*)Strings(.*) matches string? ");
//        System.out.println(str.matches("(.*)Strings(.*)"));
//
//        System.out.print("Regex: (.*)Methods matches string? ");
//        System.out.println(str.matches("(.*)Methods"));
//    }
//
//    @Test
//    public void StringReplaceAllFirstExample() {
//        String Str = new String("Welcome to Tutorialspoint.com");
//
//        System.out.print("Return Value :");
//        System.out.println(Str.replaceAll("(.*)Tutorials(.*)", "AMROOD"));
//
//        System.out.print("Return Value :");
//        System.out.println(Str.replaceFirst("(.*)Tutorials(.*)", "AMROOD"));
//
//        System.out.print("Return Value :");
//        System.out.println(Str.replaceFirst("Tutorials", "AMROOD"));
//    }
//
//    @Test
//    public void StringSplitExample() {
//        String Str = new String("Welcome-to-Tutorialspoint.com");
//        System.out.println("Return Value :");
//
//        for (String retval : Str.split("-")) {
//            System.out.println(retval);
//        }
//
//        for (String retval : Str.split("-", 2)) {
//            System.out.println(retval);
//        }
//        System.out.println("");
//        System.out.println("Return Value :");
//
//        for (String retval : Str.split("-", 3)) {
//            System.out.println(retval);
//        }
//        System.out.println("");
//        System.out.println("Return Value :");
//
//        for (String retval : Str.split("-", 0)) {
//            System.out.println(retval);
//        }
//        System.out.println("");
//    }
//

//    @Test
//    public void main() throws IOException {
//
//        MatcherMatchesExample(Pattern.compile(".*http://.*"));
//        MatcherMatchesExample(getPatternMatcher());
//
//        String[] words = { "{apf", "hum_", "dkoe", "12f" };
//
//        for (String s : words) {
//            if (s.matches("[a-z]+")) {
//                System.out.println(s);
//            }
//        }
//        boolean isT=true;
//        PrintWriter writer = new PrintWriter(new FileWriter("fileName",true));
//        writer.println("abc");
//    }


}
