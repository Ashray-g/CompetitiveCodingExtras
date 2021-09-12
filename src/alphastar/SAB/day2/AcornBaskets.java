package alphastar.SAB.day2;

import java.util.*;

public class AcornBaskets {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] abc = {scan.nextInt(), scan.nextInt(), scan.nextInt()};
        boolean[][][] vis = new boolean[abc[0]+1][abc[1]+1][abc[2]+1];

        TreeSet<Integer> ans = new TreeSet<>();

        Stack<int[]> st = new Stack<>();
        st.add(new int[]{0, 0, abc[2]});
        vis[0][0][abc[2]] = true;
        int[] da = {0, 0, 1, 1, 2, 2};
        int[] db = {1, 2, 0, 2, 0, 1};

        while(!st.isEmpty()){
            int[] cur = st.pop().clone();
            if(cur[0] == 0) ans.add(cur[2]);
            for(int i = 0;i<6;i++){
                int[] p = pour(cur[da[i]], cur[db[i]], abc[da[i]], abc[db[i]]);
                int[] temp = cur.clone();
                temp[da[i]] = p[0];
                temp[db[i]] = p[1];
                if(!vis[temp[0]][temp[1]][temp[2]]){
                    st.push(temp);
                    vis[temp[0]][temp[1]][temp[2]] = true;
                }
            }
        }
        for(int u : ans) System.out.print(u + " ");

    }
    public static int[] pour(int a, int b, int aS, int bS){
        if(bS - b >= a) return new int[] {0, Math.min(b + a, bS)};
        return new int[] {a - (bS - b), bS};
    }
}
