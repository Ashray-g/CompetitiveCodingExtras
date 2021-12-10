package alphastar.SAB.finals;

import java.util.*;

public class Moocast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] range = new int[n];
        ArrayList<Integer>[] adList = new ArrayList[n];
        for(int i = 0;i<n;i++){
            adList[i] = new ArrayList();
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
            range[i] = scan.nextInt();
        }

        for(int a = 0;a<n;a++){
            for(int b =0;b<n;b++){
                int distTo2 = (x[a] - x[b]) * (x[a] - x[b]) + (y[a] - y[b]) * (y[a] - y[b]);
                if(range[a] * range[a] >= distTo2){
                    adList[a].add(b);
                }
            }
        }

        int max = 0;

        for(int i = 0;i<n;i++){
            //bfs
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[n];
            vis[i] = true;
            int c = 0;
            q.add(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                c++;
                for(int ad : adList[cur]){
                    if(!vis[ad]){
                        vis[ad] = true;
                        q.add(ad);
                    }
                }
            }
            max = Math.max(max, c);

        }
        System.out.println(max);

    }
}