package alphastar.SAB;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Garden {
    static char[][] arr;
    static HashSet<String> ans = new HashSet<>();
    static HashSet<String>[] midline;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new char[n][n];
        midline = new HashSet[n];
        for(int i = 0;i<n;i++){
            String u = scan.next();
            for(int j = 0;j<n;j++) arr[i][j] = u.charAt(j);
            midline[i] = new HashSet<>();
        }
        dfs(new point(0, 0), arr[0][0]+"", n);
        dfs2(new point(n-1, n-1), arr[n-1][n-1]+"", n);
        System.out.println(ans.size());
        System.out.println(Arrays.toString(midline));
        System.out.println(ans);
    }

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void dfs(point start, String cur, int n){
        if(cur.length() == n-1){
            midline[start.x].add(cur);
            return;
        }
        for(int i = 0;i<2;i++){
            int x = start.x + dx[i], y = start.y + dy[i];
            if(x>=0&&x<n){
                dfs(new point(x, y), cur + arr[y][x]+"", n);
            }
        }
    }

    static int[] dx2 = {0, -1};
    static int[] dy2 = {-1, 0};

    public static void dfs2(point start, String cur, int n){
        if(cur.length() == n-1){
            int x = start.x;
            System.out.println(cur);
            if(midline[x].contains(cur)) ans.add(cur + arr[start.y-1][x]);
            if(x > 0) {
                System.out.println();
                if (midline[x - 1].contains(cur)){
                    ans.add(cur + arr[start.y][x-1]);
                    ans.add(cur + arr[start.y-1][x]);
                }
            }
            if(x > 1) {
                if (midline[x - 2].contains(cur)) ans.add(cur + arr[start.y][x-1]);
            }
            return;
        }

        for(int i = 0;i<2;i++){
            int x = start.x + dx2[i], y = start.y + dy2[i];
            if(x>=0&&x<n){
                dfs2(new point(x, y), cur + arr[y][x]+"", n);
            }
        }

    }

    public static class point{
        int x, y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
