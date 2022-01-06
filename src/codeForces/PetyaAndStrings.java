package codeForces;

import java.util.Locale;
import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        int c = (a.toLowerCase()).compareTo(b.toLowerCase());
        System.out.println((c!=0)?(c/Math.abs(c)):0);
    }
}
