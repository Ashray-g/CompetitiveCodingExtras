package alphastar.SAB.day4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VacationMeetup {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] cities = new int[k];
        for(int i = 0;i<k;i++) cities[i] = scan.nextInt() - 1;
        boolean[][] reach = new boolean[n][n];
        Set<Integer>[] ad = new Set[n];
        for(int i =0 ;i<n;i++) ad[i] = new HashSet<>();
        for(int i = 0;i<m;i++){
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            reach[a][b] = true;
            reach[a][a] = true;
            reach[b][b] = true;
//            ad[a].add(b);
//            ad[b].add(b);
//            ad[a].add(a);
        }

        for(int a = 0;a<n;a++){
            for(int b = 0;b<n;b++){
                for(int c = 0;c<n;c++){
                    reach[b][c] = reach[b][c] || (reach[b][a] && reach[a][c]);
//                    if(ad[b].contains(c) || (ad[b].contains(a) && ad[b].contains(c))){
//                        ad[b].add(c);
//                    }
                }
            }
        }

        int ct = 0;

        for(int i = 0;i<n;i++){
            boolean pos = true;
            for(int j : cities){
//                pos = pos && ad[j].contains(i);
                pos = pos && reach[j][i];
            }
            if(pos) ct++;
        }
        System.out.println(ct);

    }
}
