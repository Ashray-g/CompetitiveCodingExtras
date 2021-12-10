package leetcode.biweeklyContest46;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        int h = isWater.length;
        int w = isWater[0].length;
        int[][] output = new int[h][w];
        for(int i = 0;i<h;i++) Arrays.fill(output[i], -1);
        Queue<Point> q = new LinkedList<>();
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                if(isWater[i][j]==1){
                    q.add(new Point(j, i));
                    output[i][j] = 0;
                }
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0;i<4;i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if(newX >= 0 && newY >= 0 && newX < w && newY < h) {
                    if (output[newY][newX] == -1) {
                        output[newY][newX] = output[cur.y][cur.x] + 1;
                        q.add(new Point(newX, newY));
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(output));

    }
}
