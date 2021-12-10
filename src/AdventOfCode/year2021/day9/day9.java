package AdventOfCode.year2021.day9;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day9 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/AdventOfCode/year2021/day9/input.txt"));
        int[][] g  = new int[100][100];
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int tot =0;
        for(int i = 0;i<100;i++){
            String h = scan.next();
            for(int j = 0;j<100;j++) {
                g[i][j] = h.charAt(j) - '0';
            }
        }
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        for(int i = 0;i<100;i++){
            for(int j = 0;j<100;j++){
                boolean k = true;
                for(int x = 0;x<4;x++){
                    int newX = j + dx[x];
                    int newY = i + dy[x];
                    if(newX >= 0 && newY>=0 && newX < 100 && newY < 100){
                        if(g[newY][newX] <= g[i][j]){
                            k = false;
                            break;
                        }
                    }
                }
                if(k){
                    tot += g[i][j]+1;
                    xs.add(j);
                    ys.add(i);
                }
            }
        }

        TreeSet<Integer> top = new TreeSet<>();

        for(int i = 0;i<xs.size();i++){
            int x = xs.get(i);
            int y = ys.get(i);
            int ct = 1;
            boolean[][] vis = new boolean[100][100];
            vis[y][x] = true;

            Queue<Point> q = new LinkedList<>();
            q.add(new Point(x, y));
            while(!q.isEmpty()){
                Point cur = q.poll();
                for(int ad = 0;ad<4;ad++){
                    int newX = cur.x + dx[ad];
                    int newY = cur.y + dy[ad];
                    if(newX >= 0 && newY>=0 && newX < 100 && newY < 100 && !vis[newY][newX]){
                        if(g[newY][newX] > g[cur.y][cur.x] && g[newY][newX] != 9) {
                            q.add(new Point(newX, newY));
                            vis[newY][newX] = true;
                            ct++;
                        }
                    }
                }
            }
            top.add(ct);
        }
        System.out.println(top.pollLast() * top.pollLast() * top.pollLast());




    }
}
