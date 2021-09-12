package facebookHackerCup.round1.A1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeakTyping {
    public static void main(String[] args) throws IOException {
        File g = new File("src/facebookHackerCup/round1/A1/weak_typing_chapter_1_input.txt");
        Scanner scan  = new Scanner(g);

        String format = "Case #%s: %s";

        int t  = scan.nextInt();

        File file = new File("src/facebookHackerCup/round1/A1/output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int counter = 0;
        while(t-->0) {
            counter++;
            int len = scan.nextInt();
            String in = scan.next();
            int ans = -1;
            char cur = 'G';
            for(int i = 0;i<len;i++){
                char c = in.charAt(i);
                if(c == 'X' || c == 'O'){
                    if(c != cur){
                        ans ++;
                        cur = c;
                    }
                }
            }
//            System.out.println(String.format(format,counter, ans));
            if(ans == -1) ans++;
            writer.write(String.format(format,counter, ans) + "\n");
        }
        writer.close();
    }
}
