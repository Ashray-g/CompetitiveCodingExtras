package facebookHackerCup.qual2021.A1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A1 {
    public static void main(String[] args) throws IOException {
        File g = new File("src/facebookHackerCup/qual2021/A1/text.txt");
        Scanner scan  = new Scanner(g);

        String format = "Case #%s: %s";

        int t  = scan.nextInt();

        File file = new File("src/facebookHackerCup/qual2021/A1/output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int counter = 0;
        while(t-->0){
            counter++;
            String n = scan.next();
            int v=0, c=0;
            int[] chars =new int[26];
            int vMax = 0, cMax = 0;
            for(int i = 0;i<n.length();i++){
                char a= n.charAt(i);
                chars[a-'A']++;
                if(a=='A'||a=='E'||a=='I'||a=='O'||a=='U'){
                    v++;
                    vMax = Math.max(vMax, chars[a-'A']);
                }
                else{
                    c++;
                    cMax = Math.max(cMax, chars[a-'A']);
                }
            }
            int chooseV = c + (v - vMax)*2;
            int chooseC = v + (c - cMax)*2;
//            System.out.println(String.format(format, counter, Math.min(chooseC, chooseV)));
            writer.write(String.format(format, counter, Math.min(chooseC, chooseV)) + "\n");

        }
        writer.close();
    }
}
