package alphastar.SAB.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AcornShowcase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(),m = scan.nextInt();
        int[] x = new int[n], y = new int[n];
        for(int i = 0;i<n;i++) {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }
        ArrayList<Integer>[] adList = new ArrayList[n];
        for(int i = 0;i<n;i++) adList[i] = new ArrayList<>();
        for(int i = 0;i<m;i++){
            int a = scan.nextInt()-1, b = scan.nextInt()-1;
            adList[a].add(b);
            adList[b].add(a);
        }

        boolean[] vis = new boolean[n];

        long g = Integer.MAX_VALUE/2;

        for(int i = 0;i<n;i++){
            if(!vis[i]) {

                int xMin= Integer.MAX_VALUE/2;
                int xMax= Integer.MIN_VALUE/2;
                int yMin= Integer.MAX_VALUE/2;
                int yMax= Integer.MIN_VALUE/2;

                vis[i] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int cur = q.poll();
                    xMin = Math.min(xMin, x[cur]);
                    xMax = Math.max(xMax, x[cur]);
                    yMin = Math.min(yMin, y[cur]);
                    yMax = Math.max(yMax, y[cur]);
                    for(int ad : adList[cur]){
                        if(!vis[ad]){
                            vis[ad] = true;
                            q.add(ad);
                        }
                    }
                }

                g = Math.min(g, (yMax - yMin) * 2L + (xMax - xMin) * 2L);
            }
        }

        System.out.println(g);
    }
}
