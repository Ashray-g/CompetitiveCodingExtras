package alphastar.SAB.day4;

import java.util.*;

public class Nemisis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<Integer>[] adList = new ArrayList[n];
        for(int i = 0;i<n;i++) adList[i] = new ArrayList<>();
        for(int i = 0;i<m;i++){
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            adList[a].add(b);
            adList[b].add(a);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE/3);
        dist[0] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int max  = 0;

        while(!q.isEmpty()){
            int cut = q.poll();
            for(int ad : adList[cut]){
                if(dist[ad] == Integer.MAX_VALUE/3){
                    dist[ad] = dist[cut] + 1;
                    q.add(ad);
                    max = Math.max(max, dist[ad]);
                }
            }
        }

        int ct = 0;
        int ind = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(dist[i] == max){
                ind = Math.min(ind, i);
                ct++;
            }
        }
        System.out.println((ind + 1) + " " + max + " " + ct);

    }
}
