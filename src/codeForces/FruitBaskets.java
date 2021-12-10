package codeForces;

import java.util.Scanner;

public class FruitBaskets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int n = scan.nextInt();
        int tot = 0;
        for(int i = 0;i<a;i++){
            int x = scan.nextInt();
            tot += x/n;
            if(x % n != 0){
                tot++;
            }
        }
        System.out.println(tot);
    }
}
