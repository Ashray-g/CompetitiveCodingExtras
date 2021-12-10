package codeForces;

import java.util.Scanner;

public class balancedRemainders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0;i<t;i++) {
            int n = scan.nextInt();
            int ans = 0;
            int target = n/3;
            int[] gotten = {0, 0, 0};
            for(int j = 0;j<n;j++){
                int s = scan.nextInt();
                int r = s%3;
                if(gotten[r] < target) gotten[r]++;
                else{
                    if(gotten[(r +1)%3] < target){
                        gotten[(r +1)%3]++;
                        ans++;
                    }else if(gotten[(r +2)%3] < target){
                        gotten[(r +2)%3]++;
                        ans+=2;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
