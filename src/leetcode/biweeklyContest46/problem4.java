package leetcode.biweeklyContest46;

import java.util.*;

public class problem4 {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        if (p == 0) return q;
        if ((p & 1) == 0 && (q & 1) == 0) return gcd(p >> 1, q >> 1) << 1;
        else if ((p & 1) == 0) return gcd(p >> 1, q);
        else if ((q & 1) == 0) return gcd(p, q >> 1);
        else if (p >= q) return gcd((p-q) >> 1, q);
        else return gcd(p, (q-p) >> 1);
    }
    public static void main(String[] args) {
        int[] nums = {2,3,3,2};
        int[][] edges = {{0,1},{1,2},{1,3}};

        List<Integer>[] adList = new List[nums.length];
        for(int i = 0;i<nums.length;i++) adList[i] = new ArrayList<>();
        for(int[] g : edges){
            adList[g[0]].add(g[1]);
        }
        //start
        //start pre-computation of 50s coprimes
        boolean[][] isComprime = new boolean[51][51];
        for(int i = 1;i<=50;i++){
            for(int j = 1;j<=50;j++){
                if(gcd(i, j) == 1) isComprime[i][j] = true;
            }
        }
        System.out.println(Arrays.deepToString(isComprime));
        //start traverse
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, -1);
        int[][] last = new int[n][51];//[node][ancestor]
        for(int i = 0;i<n;i++) Arrays.fill(last[i], -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1;i<=50;i++){
                if(isComprime[i][nums[cur]] && last[cur][i] != -1){
                    if(output[cur] == -1) output[cur] = last[cur][i];
                    else output[cur] = Math.max(output[cur], last[cur][i]);
                }
            }
            if(cur < edges.length) {
                for (int ad : adList[cur]) {
                    q.add(ad);
                    for(int i = 1;i<=50;i++){
                        last[ad][i] = last[cur][i];
                    }
                    last[ad][nums[cur]] = cur;
                }
            }
        }
        System.out.println(Arrays.toString(output));


    }
    //[9,16,30,23,33,35,9,47,39,46,16,38,5,49,21,44,17,1,6,37,49,15,23,46,38,9,27,3,24,1,14,17,12,23,43,38,12,4,8,17,11,18,26,22,49,14,9]
    //[[17,0],[30,17],[41,30],[10,30],[13,10],[7,13],[6,7],[45,10],[2,10],[14,2],[40,14],[28,40],[29,40],[8,29],[15,29],[26,15],[23,40],[19,23],[34,19],[18,23],[42,18],[5,42],[32,5],[16,32],[35,14],[25,35],[43,25],[3,43],[36,25],[38,36],[27,38],[24,36],[31,24],[11,31],[39,24],[12,39],[20,12],[22,12],[21,39],[1,21],[33,1],[37,1],[44,37],[9,44],[46,2],[4,46]]
}
