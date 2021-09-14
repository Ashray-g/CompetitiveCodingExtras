package codechef.SeptemberChallenge2021;

import java.util.Scanner;

public class AirlineRestrictions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while(t-->0){
            int[] arr = {scan.nextInt(), scan.nextInt(), scan.nextInt()};
            int d = scan.nextInt(), e = scan.nextInt();
            boolean pos = false;
            if(arr[0]+arr[1]+arr[2] > d + e){
            }else{
                int max = 0;
                for(int i : arr){
                    if(i <= e) max = Math.max(max, i);
                }
                if(max == 0){
                }else if(arr[0]+arr[1]+arr[2]-max <= d){
                    pos = true;
                }
            }
            System.out.println(pos?"YES":"NO");
        }
    }
}
