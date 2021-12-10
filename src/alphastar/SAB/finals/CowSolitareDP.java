package alphastar.SAB.finals;

import java.util.Scanner;

public class CowSolitareDP {
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

        int[][] score = new int[n][n];
        score[n - 1][0] = value[n-1][0];
        for(int i = 1;i<n;i++){
            score[n - 1][i] = score[n - 1][i - 1] + value[n - 1][i];
            score[n - 1 - i][0] = score[n - i][0] + value[n - 1 - i][0];
        }
        for(int y = n-2;y>=0;y--){
            for(int x = 1;x<n;x++) {
                score[y][x] = Math.max(score[y+1][x], score[y][x-1]) + value[y][x];
            }
        }
        System.out.println(score[0][n-1]);
    }
}
