package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class FROGS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int r = 0;r<t;r++){
            int n = scan.nextInt();
            int[] w = new int[n], l = new int[n];
            int[] sorted = new int[n], locs = new int[n];
            for(int i = 0;i<n;i++){
                w[i] = scan.nextInt();
                sorted[i] = w[i];
            }
            Arrays.sort(sorted);
            for(int i = 0;i<n;i++){
                l[i] = scan.nextInt();
                locs[i] = getIndex(sorted[i], w);
            }
            int ans = 0;
            if(!sorted(w)) {
                for(int i = 1;i<n;i++){
                    while(locs[i] <= locs[i -1]){
                        ans++;
                        locs[i] += l[getIndex(sorted[i], w)];
                    }
                }
            }
            System.out.println(ans);
        }
    }
    public static int getIndex(int a, int[] h){
        int ans = 0;
        for(int i = 0;i<h.length;i++){
            if(h[i] == a){
                ans = i;
                break;
            }
        }
        return ans;
    }
    public static boolean sorted(int[] h){
        boolean sortedd = true;
        for(int i  =1;i<h.length;i++){
            if(h[i] < h[i-1]){
                sortedd = false;
                break;
            }
        }
        return sortedd;
    }
}
