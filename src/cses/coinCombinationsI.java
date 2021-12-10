package cses;

import java.util.Scanner;

public class coinCombinationsI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        int t = scan.nextInt();
        int[] coins = new int[c], dp = new int[t + 100];
        for(int i = 0;i<c;i++){
            coins[i] = scan.nextInt();
            if(coins[i] <= t) dp[coins[i]] = 1;
        }
        for(int i = 1;i<=t;i++){
            for(int j : coins){
                if(i - j > 0){
                    dp[i] = (dp[i-j] + dp[i])%1_000_000_007;
                }
            }
        }
        System.out.println(dp[t]);
    }
}
