package leetcode.biweeklyContest46;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        int n = a.length();
        int maxLen = 0;
        String max = "";
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                String cur = a.substring(i, j+1);
                if(cur.length() > maxLen) {
                    if (isNice(cur)) {
                        max = cur;
                        maxLen = cur.length();
                    }
                }
            }
        }
        System.out.println(max);
    }
    public static boolean isNice(String a){
        int[] g = new int[26];
        for(int i = 0;i<a.length();i++){
            int in = a.charAt(i);
            if(in >= 'A' && in <= 'Z'){
                in -= 'A';
                if(g[in] !=2 && g[in] != 3) g[in] += 2;
            }else{
                in -= 'a';
                if(g[in] != 1 && g[in] != 3) g[in] += 1;
            }
        }
        boolean ans = true;
        for(int i : g){
            if(i == 1 || i == 2){
                ans = false;
                break;
            }
        }
        return ans;
    }
}
