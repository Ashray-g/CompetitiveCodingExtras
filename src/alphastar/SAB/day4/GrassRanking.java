package alphastar.SAB.day4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GrassRanking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        ArrayList<Integer>[] graphReversed = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            graph[i] = new ArrayList<>();
            graphReversed[i] = new ArrayList<>();
        }

        for(int i = 0;i<m;i++){
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            graph[a].add(b);
            graphReversed[b].add(a);
        }

        int ans =0;

        for(int i = 0;i<n;i++){
            int c = 0;
            c += reach(graph, i, n);
            c += reach(graphReversed, i, n);
            if(c == n-1){
                ans++;
            }
        }

        System.out.println(ans);

    }
    public static int reach(ArrayList<Integer>[] adList, int start, int n){
        Stack<Integer> st = new Stack<>();
        st.push(start);
        boolean[] vis = new boolean[n];
        int ct = 0;
        vis[start] = true;
        while(!st.isEmpty()){
            int cur = st.pop();
            for(int i : adList[cur]){
                if(!vis[i]){
                    vis[i] = true;
                    st.push(i);
                    ct++;
                }
            }
        }
        return ct;
    }
}
