import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Ben 07/23/2018
 */

public class Cryptoquip {

    public static void main(String[] args) {

        // A=65 to Z=90
        // ALPHA (character) is in original string; BETA is output

        // 's' must be a string in all caps
        String s = "THIS IS A TEST PHRASE";
        final int asciiShift = 64;
        /* Holds alphas and their corresponding betas */
        Hashtable<String, String> conversion = new Hashtable<>();
        ArrayList<String> exceptions = new ArrayList<>();
        /* All characters in original String 's' to ignore */
        exceptions.add(" "); exceptions.add(","); exceptions.add("?");
        exceptions.add("."); exceptions.add("'"); exceptions.add("-");
        exceptions.add(":"); exceptions.add("\"");

        /* Output string */
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < s.length(); i++) {
            /* if the current char is not . : ? , etc */
            if (!exceptions.contains(String.valueOf(s.charAt(i)))) {
                /* if the current alpha char is not already accounted for in hash table */
                if (!conversion.containsKey(String.valueOf(s.charAt(i)))) {
                    boolean pass = true;
                    while (pass) {
                        /* value of 1 through 25; 26 would be same char, >26 mods to 1-25 */
                        int shift = r.nextInt(25) + 1;
                        int add = s.charAt(i) + shift;
                        char beta = ((char) (add > 90 ? add-26 : add));
                        /* if beta char has not been assigned to an alpha */
                        if (!conversion.containsValue(String.valueOf(beta))) {
                            conversion.put(String.valueOf(s.charAt(i)), String.valueOf(beta));
                            sb.append(beta);
                            pass = false;
                        }
                    }
                }
                else
                    sb.append(conversion.get(String.valueOf(s.charAt(i))));
            }
            else
                sb.append(s.charAt(i));
        }
        System.out.println("\n\n"+sb);
        boolean allClear = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                if (!exceptions.contains(String.valueOf(s.charAt(i)))) {
                    // tells you if only 1 instance of a letter exists;
                    // should be at least 2 of each letter to cross-reference
                    System.out.println("There is only one " + s.charAt(i) + " in the string");
                    allClear = false;
                }
            }
        }
        if (allClear)
            System.out.println("all good :D");
        /* produces hint */
        int hint = r.nextInt(s.length());
        while (exceptions.contains(String.valueOf(s.charAt(hint)))) {
            hint = r.nextInt();
        }
        // provide a hint as to the value of one letter in the puzzle
        System.out.println("\nHint: " + conversion.get(String.valueOf(s.charAt(hint))) + " equals " + s.charAt(hint));
    }
}
