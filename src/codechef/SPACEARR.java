package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class SPACEARR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0;i<t;i++){
            int n = scan.nextInt();
            int[] h = new int[n];
            for(int j = 0;j<n;j++) h[j] = scan.nextInt();
            Arrays.sort(h);
            boolean se = false;
            int tot = 0;
            for(int p = 1;p<=n;p++){
                int diff = p - h[p-1];
                if(diff<0){
                    System.out.println("Second");
                    se = true;
                    break;
                }
                tot += diff;
            }
            if(!se){
                if((tot & 1) == 1) System.out.println("First");
                else System.out.println("Second");
            }
        }
    }
}
