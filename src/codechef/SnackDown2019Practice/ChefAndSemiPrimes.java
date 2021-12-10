package codechef.SnackDown2019Practice;

import java.util.Scanner;

public class ChefAndSemiPrimes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        boolean[] semi = new boolean[201];
        for(int i = 3;i<=200;i++) semi[i] = semiPrime(i);

        while(t-->0){
            int n = scan.nextInt();
            boolean pos = false;
            for(int j = 1;j<n-1;j++){
                if(semi[j] && semi[n - j]){
                    pos = true;
                    break;
                }
            }
            System.out.println(pos?"YES":"NO");
        }

    }
    public static boolean semiPrime(int a){
        int h = 0, d = 0;
        for(int i = 2; i<= a; i++) {
            if(a%i==0)d++;
            while(a%i == 0) {
                a = a/i;
                h++;
            }
        }
        return h==2 && d == 2;
    }
}
