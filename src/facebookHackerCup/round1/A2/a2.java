package facebookHackerCup.round1.A2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class a2 {
    public static void main(String[] args)  throws IOException {
        File g = new File("src/facebookHackerCup/round1/A2/text.txt");
        Scanner scan  = new Scanner(g);

        String format = "Case #%s: %s";

        int t  = scan.nextInt();

        File file = new File("src/facebookHackerCup/round1/A2/output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int counter = 0;
        while(t-->0) {
            counter++;
            int len = scan.nextInt();
            String in = scan.next();

            long k = 0;

            for(int p = 0;p<len;p++){
                for(int j = p;j<len;j++){
                    String in2 = in.substring(p, j + 1);
                    int len2 = in2.length();
                    int ans = -1;
                    char cur = 'G';
                    for(int i = 0;i<len2;i++){
                        char c = in2.charAt(i);
                        if(c == 'X' || c == 'O'){
                            if(c != cur){
                                ans ++;
                                cur = c;
                            }
                        }
                    }
                    if(ans == -1) ans++;
                    k += ans;
                    k %= 1000000007;
                }
            }

            writer.write(String.format(format,counter, k) + "\n");

        }
        writer.close();
    }
}
