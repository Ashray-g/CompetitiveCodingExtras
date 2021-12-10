package codeForces;

import java.util.Scanner;

//NOT FINISHED
public class sumOfCubes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        long[] cubes = new long[10001];
        for(int i = 1;i<=10000;i++) cubes[i] = (long)i*(long)i*(long)i;
        for(int i = 0;i<t;i++) {
            long p = scan.nextLong();
            boolean ans = false;
            long low = 1;
            long high = 10000;
            long lastHigh = 10000;
            long lastLow = 1;
            while(true){
                long cube = cubes[(int)low] + cubes[(int)high];
                if(cube < p) low++;
                else if(cube > p) high--;
                else ans = true;
                if(high < low) break;
                if(low == lastLow && high == lastHigh) break;
                lastHigh = high;
                lastLow = low;
            }
            if(ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
