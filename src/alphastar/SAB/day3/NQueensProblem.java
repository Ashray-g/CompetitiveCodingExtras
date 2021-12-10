package alphastar.SAB.day3;

import java.util.Scanner;

public class NQueensProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int[][] arr = new int[n][n];
        rec(arr, 0);

    }
    public static boolean place(int[][] arr, int x, int y){
        boolean plac = true;
        for(int i = 0;i<arr.length;i++){
            if(arr[y][i] == 1){
                plac = false;
                break;
            }
            if(arr[i][x] == 1){
                plac = false;
                break;
            }
        }
        return plac;
    }

    public static boolean rec(int[][] arr, int x){
        if(x >= arr.length){
            return true;
        }
        for(int i = 0;i<arr.length;i++){
            if(place(arr, x, i)){
                arr[i][x] = 1;
                return rec(arr, x + 1);
//                arr[i][x] = 0;
            }
        }
        return false;
    }
}
