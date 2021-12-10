package alphastar.SAB.finals;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CowSolitareBFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] value = new int[n][n];
        //q ->
        scan.nextLine();
        for(int i = 0;i<n;i++){
            String row = scan.nextLine();
            for(int j = 0;j<n;j++){
                char val = row.charAt(j * 3);
                int h = 0;
                if(val - '1' <= 10){
                    h = val - '0';
                }else{
                    switch(val){
                        case 'T':
                            h = 10;
                            break;
                        case 'J':
                            h = 11;
                            break;
                        case 'Q':
                            h = 12;
                            break;
                        case 'K':
                            h = 13;
                            break;
                        case 'A':
                            h = 1;
                            break;
                    }
                }
                value[i][j] = h;
            }
        }

        Queue<point> q = new LinkedList<>();
        int[] dx = {0, 1};
        int[] dy = {-1, 0};
        int[][] scores = new int[n][n];
        for(int i = 0;i<n;i++) Arrays.fill(scores[i], -1);
        q.add(new point(0, n-1));
        scores[n-1][0] = value[n-1][0];
        while(!q.isEmpty()){
            point cur = q.poll();
            for(int i = 0;i<2;i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newY >= 0 && newX < n){
                    if(scores[cur.y][cur.x] + value[newY][newX] > scores[newY][newX]){
                        scores[newY][newX] = scores[cur.y][cur.x] + value[newY][newX];
                        q.add(new point(newX, newY));
                    }
                }
            }
        }
        System.out.println(scores[0][n-1]);

    }
    public static class point{
        public int x, y;
        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
