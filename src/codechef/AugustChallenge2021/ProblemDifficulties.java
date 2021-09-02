package codechef.AugustChallenge2021;

import java.util.Scanner;

public class ProblemDifficulties {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0;i<t;i++){
            int[] freq = new int[15];
            int max =0;
            for(int j = 0;j<4;j++) max = Math.max(max, ++freq[scan.nextInt()]);
            System.out.println(Math.min(2, 4-max));
        }
    }
}
