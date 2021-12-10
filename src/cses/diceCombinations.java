package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class diceCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        long times = Long.parseLong(buf.readLine());
        long[] ways = new long[(int)times + 100];
        for(int i = 0;i<6;i++) ways[i+1] = 1;
        for(int i = 1;i<=times;i++){
            for(int j = i-1;j>=Math.max(0, i-6);j--){
                ways[i] = (ways[i] + ways[j])%1_000_000_007;
            }
        }
        System.out.println(ways[(int)times]);
    }
}
