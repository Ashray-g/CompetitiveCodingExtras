package codeForces;

import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        System.out.println(a.substring(0, 1).toUpperCase() + a.substring(1));
    }
}
