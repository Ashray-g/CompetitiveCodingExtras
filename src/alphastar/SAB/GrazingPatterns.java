package alphastar.SAB;

import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;

public class GrazingPatterns {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arr = new int[5][5];
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                arr[i][j] = scan.nextInt();
            }
        }

        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                dfs(new Point(i, j), "");
            }
        }
        System.out.println(ans.size());

    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static HashSet<String> ans = new HashSet<>();

    public static void dfs(Point start, String cur){
        if(cur.length() == 6){
            ans.add(cur);
            return;
        }

        for(int i = 0;i<4;i++){
            int x = start.x + dx[i];
            int y = start.y + dy[i];
            if(x>=0&&y>=0&&x<5&&y<5){
                dfs(new Point(x, y), cur + arr[y][x]+"");
            }
        }

    }
}
