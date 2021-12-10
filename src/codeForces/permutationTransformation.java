package codeForces;

import java.util.Arrays;
import java.util.Scanner;

public class permutationTransformation {
    public static int[] p = new int[200];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t  = scan.nextInt();
        for(int i = 0;i<t;i++){
            int n =scan.nextInt();
            int[] h = new int[n];
            for(int j = 0;j<n;j++) h[j] = scan.nextInt();
            recursion(h, 0);
            for(int j= 0;j<n;j++){
                System.out.print((p[h[j]]-1) + " ");
            }
            for(int j = 0;j<200;j++) p[j] = 0;
            System.out.println();
        }
    }
    public static void recursion(int[] j, int d){
        if(j.length == 0) return;
        if(j.length == 1){
            p[j[0]] = d+1;
            return;
        }
        int mac = 0;
        int maxDex = 0;
        for(int i = 0;i<j.length;i++){
            if(j[i] > mac){
                mac = j[i];
                maxDex = i;
            }
        }
        p[j[maxDex]] = d+1;
        if(maxDex!= 0) recursion(Arrays.copyOfRange(j, 0, maxDex), d+1);
        if(maxDex != j.length-1) recursion(Arrays.copyOfRange(j, maxDex+1, j.length), d+1);
    }
}
