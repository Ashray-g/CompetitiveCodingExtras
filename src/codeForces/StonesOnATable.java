package codeForces;

import java.util.Scanner;

public class StonesOnATable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String h = scan.nextLine();
        int tot = 0;
        for(int i = 1;i<n;i++){
            tot += (h.charAt(i) == h.charAt(i-1))?1:0;
        }
        System.out.println(tot);
    }
}
