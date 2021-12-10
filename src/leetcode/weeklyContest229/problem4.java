package leetcode.weeklyContest229;//package leetCode.weeklyContest229;
//
//import java.util.Scanner;
//
//public class problem4 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String word1 = "cacb";
//        String word2 = "cbba";
//        int w1n = word1.length();
//        int w2n = word2.length();
//        word2 = (new StringBuilder(word2).reverse()).toString();
//        int[][] dp = new int[w1n][w2n];
//
//        for(int i = w1n-1;i>=0;i--){
//            for(int j = w2n-1;j>=0;j--){
//                int word1Loc = i;
//                int word2Loc = j;
//                if(word1.charAt(word1Loc) == word2.charAt(word2Loc)){
//                    int len = 1;
//                    while (true) {
//                        if (dp[word1Loc][word2Loc] > 0) {
//                            len += dp[word1Loc][word2Loc];
//                            break;
//                        }
//                        if(word1Loc < w1n || word2Loc < w2n){
//
//                        }
//                    }
//                    dp[i][j] = len;
//                }
//            }
//        }
//    }
//}
