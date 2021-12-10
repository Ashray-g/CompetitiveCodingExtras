package codeForces;

import java.util.Scanner;

public class denseArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0;i<t;i++){
            int added = 0;
            int n = scan.nextInt();
            int last = 0;
            for(int j = 0;j<n;j++){
                int c =scan.nextInt();
                int oC = c;
                if(j > 0){
                    while(true) {
                        if ((double)Math.max(c, last) / (double)Math.min(c, last) > 2.0) {
                            if(c > last) {
                                last = 2 * last;
                                added++;
                            }else{
                                c = c * 2;
                                added++;
                            }
                        }else{
                            last = oC;
                            break;
                        }
                    }
                }else last = c;
            }
            System.out.println(added);
        }
    }
}
