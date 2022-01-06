package codeForces;

import java.util.Scanner;

public class BitPlusPLus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int a = 0;
        for(int i = 0;i<n;i++){
            a += (scan.nextLine().charAt(1)=='+')?1:(-1);
        }
        System.out.println(a);
    }
}
