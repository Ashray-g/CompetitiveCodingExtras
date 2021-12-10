package codechef.SnackDown2019Practice;

import java.util.Arrays;
import java.util.Scanner;

public class QualifyingToPreElim {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            int a = scan.nextInt();
            int b = scan.nextInt();

            int[] arr = new int[a];
            for(int i = 0;i<a;i++) arr[i] = scan.nextInt();

            Arrays.sort(arr);
            int v = arr[a - 1 - (b - 1)];
            int j = 0;
            for(int f = b+1;f<a;f++){
                if(arr[(a -1 -(f-1))] == v) j++;
                else break;
            }
            System.out.println(b + j);
        }
    }
}
