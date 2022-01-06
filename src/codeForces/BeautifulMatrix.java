package codeForces;

import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(scan.nextInt() == 1){
                    System.out.println(Math.abs(j - 2) + Math.abs(i - 2));
                    return;
                }
            }
        }
    }
}
