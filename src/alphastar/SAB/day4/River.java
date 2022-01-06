package alphastar.SAB.day4;

import java.util.ArrayList;
import java.util.Scanner;

public class River {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] adMat = new int[52][52];
        for(int i = 0;i<n+1;i++){
            char ca = scan.next().charAt(0);
            char cb = scan.next().charAt(0);
            int c = scan.nextInt();
            int a;
            int b;

            if(ca >= 'a' && ca <= 'z') a = ca - 'a';
            else a = ca - 'A' + 26;
            if(cb >= 'a' && cb <= 'z') b = cb - 'a';
            else b = cb - 'A' + 26;

            adMat[a][b] += c;

        }
    }
}
