package codechef.SeptemberChallenge2021;

import java.util.Scanner;

public class TravelPass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt(), a = scan.nextInt(), b = scan.nextInt();
            String l = scan.next();
            int ans  = 0;
            for(int i = 0;i<n;i++){
                if(l.charAt(i) == '0') ans +=a;
                else ans += b;
            }
            System.out.println(ans);
        }
    }
}
