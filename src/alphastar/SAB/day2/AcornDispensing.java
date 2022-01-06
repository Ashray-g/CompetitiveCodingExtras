package alphastar.SAB.day2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class AcornDispensing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<Point>[][] arr = new ArrayList[n][n];
        for(ArrayList<Point>[] f : arr){
            for(int i = 0;i<n;i++){
                f[i] = new ArrayList<>();
            }
        }

        for(int i = 0;i<m;i++){
            int x = scan.nextInt()-1, y = scan.nextInt()-1;
            int a = scan.nextInt()-1, b = scan.nextInt()-1;

            arr[y][x].add(new Point(a, b));
        }

        dfsUtil(arr, n);


    }
    public static void dfsUtil(ArrayList<Point>[][] arr, int n){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Stack<Point> st = new Stack<>();
        st.push(new Point(0, 0));

        boolean[][] vis = new boolean[n][n];
        boolean[][] light = new boolean[n][n];
        light[0][0] = true;

        while(!st.isEmpty()){
            Point cur = st.pop();
            vis[cur.y][cur.x] = true;
            ArrayList<Point> on = arr[cur.y][cur.x];
            for(Point h : on){
                if(!light[h.y][h.x]){
                    light[h.y][h.x] = true;
                    for(int i = 0;i<4;i++){
                        int newX = h.x + dx[i];
                        int newY = h.y + dy[i];
                        if(newX >= 0 && newX < n && newY >= 0 && newY < n){
                            if(vis[newY][newX]){
                                st.push(h);
                                break;
                            }
                        }
                    }
                }
            }
            for(int i = 0;i<4;i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < n){
                    if(!vis[newY][newX] && light[newY][newX]){
                        st.push(new Point(newX, newY));
                    }
                }
            }
        }
        int u = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                u += light[i][j]?1:0;
            }
        }
        System.out.println(u);
    }
}
