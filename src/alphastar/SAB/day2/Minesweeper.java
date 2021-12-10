package alphastar.SAB.day2;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Minesweeper {
    public static boolean[][] mines;
    public static int[][] arr;
    public static int minesRemaining;
    public static int n, m;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int k = scan.nextInt();
        //n is height, m is width, k is num of mines
        arr = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = scan.nextInt();
            }
        }
        mines = new boolean[n][m];
        minesRemaining = k;
        dfsUtil();
    }

    public static void dfsUtil(){
        rec(0, 0);
    }

    public static void rec(int x, int y){
        if(minesRemaining == 0 && done()){
            System.out.println(Arrays.deepToString(mines));
            return;
        }
        System.out.println(minesRemaining);
        if(poss(x,  y)){
            mine(x, y, -1);
            mines[y][x] = true;
            minesRemaining--;
            if(x < m-1){
                rec(x + 1, y);
            }else{
                rec(0,y + 1);
            }
            mine(x, y, 1);
            mines[y][x] = false;
            minesRemaining++;
            if(x < m-1){
                rec(x + 1, y);
            }else{
                rec(0,y + 1);
            }
        }
    }

    public static boolean poss(int x, int y){
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {-1, 0, 1, 1, -1, 0, -1, 1};

        for(int i = 0;i<8;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < m && newY < n){
                if(arr[newY][newX] <= 0){
                    return false;
                }
            }
        }
        return minesRemaining > 0;
    }

    public static void mine(int x, int y,int change){
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {-1, 0, 1, 1, -1, 0, -1, 1};

        for(int i = 0;i<8;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < m && newY < n){
                arr[newY][newX] += change;
            }
        }
    }

    public static boolean done(){
        int tot = 0;
        for(int [] h : arr){
            for(int u : h) tot += u;
        }
        return tot == 0;
    }
}
