package codeForces;

import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int j = 0;j<t;j++){
            int n = scan.nextInt();
            int q = scan.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i<n;i++) nums[i] = scan.nextInt();
            int[] prefix = new int[n+1];
            for(int i = 0;i<n;i++) prefix[i+1] = prefix[i] + nums[i];
            for(int i = 0;i<q;i++){
                int g = scan.nextInt();
                boolean solved = false;

                for(int p= 1 ;p<=n;p++){
                    if(prefix[p] == g){
                        System.out.print(p-1 + " ");
                        solved = true;
                        break;
                    }
                }
                if(!solved){
                    if(prefix[n] > 0){
                        
                    }else{
                        System.out.print(-1 + " ");
                    }
                }

            }
        }
    }
}
