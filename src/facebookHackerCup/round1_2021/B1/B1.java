package facebookHackerCup.round1_2021.B1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B1 {
    public static void main(String[] args) throws IOException {
        File g = new File("src/facebookHackerCup/round1/B1/text.txt");
        Scanner scan  = new Scanner(g);

        String format = "Case #%s: %s";

        int t  = scan.nextInt();

        File file = new File("src/facebookHackerCup/round1/B1/output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int counter = 0;
        while(t-->0) {
            counter++;
            int m  = scan.nextInt(), n = scan.nextInt();//n is x, m is y
            int tlbr = scan.nextInt(), trbl = scan.nextInt();

            int tlVal = tlbr - ((m - 1) + (n - 1));
            int blVal = trbl - ((m - 1) + (n - 1));

            int[][] ans = new int[m][n];

            ans[0][0] = tlVal;
            ans[m-1][0] = blVal;
            for(int i = 1;i<m-1;i++){
                ans[i][n-1] = 1;
                for(int j = 0;j<n-1;j++){
                    ans[i][j] = 1000;
                }
            }
            for(int i = 1;i<n;i++){
                ans[0][i] = 1;
                ans[m-1][i] = 1;
            }

            if(tlVal < 1 || blVal < 1) {
                writer.write(String.format(format, counter,"Impossible") + "\n");
            }else{
                writer.write(String.format(format, counter, "Possible") + "\n");
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        writer.write(ans[i][j] + " ");
                    }
                    writer.write("\n");
                }
            }

        }
        writer.close();
    }
}
