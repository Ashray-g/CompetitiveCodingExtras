package codechef.AugustChallenge2021;

import java.util.Scanner;

public class OlympicsRanking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i =  0;i<n;i++){
            if(scan.nextInt() + scan.nextInt() + scan.nextInt() > scan.nextInt() + scan.nextInt() + scan.nextInt()) System.out.println(1);
            else System.out.println(2);
        }
    }
}
