package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class MULGAME {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0;i<t;i++){
            int n = scan.nextInt();
            int q = scan.nextInt();
            int m = scan.nextInt();
            int[] ans = new int[m+10];
            int[] arr = new int[n];
            for(int j = 0;j<n;j++) arr[j] = scan.nextInt();
            int maxDiff = arr[0];
            for(int p = 0;p<q;p++){
                int a = scan.nextInt();
                int b = scan.nextInt();
                if(arr[a-1] <= m) {
                    ans[arr[a - 1]]++;
                    ans[Math.min(arr[b - 1] + arr[a - 1], m)]--;
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(ans));
            int cur = 0;
            int mx = 0;
            for(int p = 1;p<=m;p++){
                cur += ans[p];
                mx = Math.max(mx, cur);
            }
        }
    }
}
