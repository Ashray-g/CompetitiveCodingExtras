package codechef.AugustChallenge2021;

import java.util.Scanner;

public class SpecialTriplets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int ans = 0;
            for(int c = 1;c<n;c++){
                for(int b = c*2;b<=n;b+=c){
                    for (int a = c; a <= n; a += b) ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
