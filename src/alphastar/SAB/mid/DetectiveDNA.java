package alphastar.SAB.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DetectiveDNA {
    public static String[] sts;
    public static int n;
    public static int ans = 0;
    public static int[] permutation;
    public static boolean[] vis;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        sts = new String[n];
        permutation = new int[n];
        for(int i = 0;i<n;i++) sts[i] = scan.next();
        ans = Integer.MAX_VALUE/2;
        vis = new boolean[n];
        bkt(0);
        System.out.println(ans);
    }
    public static void bkt(int dep){
        if(dep == n){
            ans = Math.min(ans, len());
            return;
        }
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                vis[i] = true;
                permutation[dep] = i;
                bkt(dep + 1);
                vis[i] = false;
            }
        }
    }
    public static int len(){
        String tot = sts[permutation[0]];
        System.out.println(tot);
        for(int i = 1;i<n;i++){
            String a = sts[permutation[i]];
            int mx = 0;
            for(int j = 0;j<Math.min(a.length(),tot.length());j++){
                if(tot.substring(tot.length()-j-1).equals(a.substring(0, j+1))){
                    mx = Math.max(mx, j+1);
                }
            }
            tot += a.substring(mx);
        }
        return tot.length();
    }
}
