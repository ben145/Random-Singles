/*
By: Ben Hamula, 06/17/18

ROMAN NUMERALS: Takes in an integer, up to 4999, and outputs it as a Roman Numeral
                Alternatively, can take in a Roman Numeral and return its integer equivalent
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RomanNumerals {

    private StringBuilder sb = new StringBuilder();

    /*
    Letters for Roman numerals, representing 1, 5, 10, 50, 100, 500,
    and 1000 respectively
     */
    private ArrayList<String> getLetters() {
        ArrayList<String> letters = new ArrayList<>();
        letters.add("I"); letters.add("V"); letters.add("X"); letters.add("L");
        letters.add("C"); letters.add("D"); letters.add("M");
        return letters;
    }

    private void intToRoman(int intInput) {
        mCheck(intInput);
        System.out.println();
    }

    private void mCheck(int m) {
        while (m > 999) {
            sb.append("M");
            m -= 1000;
        }
        mCheck2(m);
    }

    private void mCheck2(int m2) {
        if (m2 > 899) {
            sb.append("CM");
            m2 -= 900;
        }
        dCheck(m2);
    }

    private void dCheck(int d) {
        if (d > 399 && d < 500) {
            sb.append("CD");
            d -= 400;
        }
        if (d > 499) {
            sb.append("D");
            d -= 500;
        }
        cCheck(d);
    }

    private void cCheck(int c) {
        while (c > 99) {
            sb.append("C");
            c -= 100;
        }
        if (c > 89) {
            sb.append("XC");
            c -= 90;
        }
        lCheck(c);
    }

    private void lCheck(int l) {
        if (l > 39 && l < 50) {
            sb.append("XL");
            l -= 40;
        }
        if (l > 49) {
            sb.append("L");
            l -= 50;
        }
        xCheck(l);
    }

    private void xCheck(int x) {
        while (x > 9) {
            sb.append("X");
            x -= 10;
        }
        if (x == 9) {
            sb.append("IX");
            x -= 9;
        }
        vCheck(x);
    }

    private void vCheck(int v) {
        if (v > 4) {
            sb.append("V");
            v -= 5;
        }
        if (v == 4) {
            sb.append("IV");
            v -= 4;
        }
        iCheck(v);
    }

    private void iCheck(int i) {
        while (i > 0) {
            sb.append("I");
            i -= 1;
        }
        System.out.println(sb);
    }

    private void validCheck() {
        boolean valid = true;
        while (valid) {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter a number in Roman numerals: ");
            String roman = s.next();
            ArrayList<String> nums = getLetters();
            for (int i = 0; i < roman.length(); i++) {
                if (!nums.contains(roman.substring(i, i + 1)))
                    valid = false;
            }
            if (!valid) {
                valid = true;
                System.out.println("Input of '" + roman + "' not valid. Try again.");
            }
            else {
                valid = false;
            }
        }
        // function call
    }

    public static void main(String[] args) {
        RomanNumerals r = new RomanNumerals();
        //r.validCheck();

        int x = 122;
        r.intToRoman(x);
    }

}