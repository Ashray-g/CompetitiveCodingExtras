package facebookHackerCup.qual2021.B1;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B1 {
    public static void main(String[] args) throws IOException {
        File g = new File("src/facebookHackerCup/qual2021/B1/text.txt");
        Scanner scan  = new Scanner(g);

        String format = "Case #%s: %s";

        int t  = scan.nextInt();

        File file = new File("src/facebookHackerCup/qual2021/B1/output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int counter = 0;
        while(t-->0) {
            counter++;

            int d = scan.nextInt();

            boolean[] cO = new boolean[d], rO = new boolean[d];
            int[] cX = new int[d], rX = new int[d];

            int[][] board = new int[d][d];

            for(int i = 0;i<d;i++){
                String row = scan.next();
                for(int j = 0;j<d;j++){
                    char c = row.charAt(j);
                    if(c == 'X') {
                        cX[j]++;
                        rX[i]++;
                        board[i][j] = 1;
                    }else if(c == 'O'){
                        cO[j] = true;
                        rO[i] = true;
                        board[i][j] = 2;
                    }
                }
            }

            //max
            int maxX = 0;
            for(int i = 0;i<d;i++){
                if(!cO[i]) maxX = Math.max(maxX, cX[i]);
                if(!rO[i]) maxX = Math.max(maxX, rX[i]);
            }

            //ways

            int ways = 0;
            if(maxX<d-1) {

                for (int i = 0; i < d; i++) {
                    if ((!rO[i] && rX[i] == maxX)) ways++;
                    if ((!cO[i] && cX[i] == maxX)) ways++;
                }
            }else{
                Set<Point> places = new HashSet<>();
                for (int i = 0; i < d; i++) {
                    if ((!rO[i] && rX[i] == maxX)){
                        for(int f = 0;f<d;f++){
                            if(board[i][f] == 0){
                                if(!places.contains(new Point(i, f))){
                                   ways++;
                                    places.add(new Point(i, f)); //r, c
                                }
                                break;
                            }
                        }
                    }
                    if ((!cO[i] && cX[i] == maxX)){
                        for(int f = 0;f<d;f++){
                            if(board[f][i] == 0){
                                if(!places.contains(new Point(f, i))){
                                    ways++;
                                    places.add(new Point(f, i)); //r, c
                                }
                                break;
                            }
                        }
                    }
                }
            }


            int needed = d - maxX;

            String answer = needed + " "+ ways;
            if(ways == 0) answer = "Impossible";
            System.out.println(String.format(format, counter, answer));
            writer.write(String.format(format, counter, answer) + "\n");

        }
        writer.close();
    }
}
