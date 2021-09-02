package facebookHackerCup.qual2021.A2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class A2 {

    //floyd-warshall?
    public static void main(String[] args) throws IOException {
        File g = new File("src/facebookHackerCup/qual2021/A2/text.txt");
        Scanner scan  = new Scanner(g);

        String format = "Case #%s: %s";

        int t  = scan.nextInt();

        File file = new File("src/facebookHackerCup/qual2021/A2/output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int counter = 0;

        while(t-->0){
            counter++;
            int min;

            String start = scan.next();
            int mappings = scan.nextInt();
            HashMap<Character, ArrayList<Character>> mapping = new HashMap<>();
            for(int  i= 0;i<mappings;i++){
                String a = scan.next();
                if(!mapping.containsKey(a.charAt(0))){
                    mapping.put(a.charAt(0), new ArrayList<Character>());
                }
                mapping.get(a.charAt(0)).add(a.charAt(1));
            }

            min = solve(mapping, start);
            if(min == Integer.MAX_VALUE/3) min = -1;

            System.out.println(String.format(format, counter, min));
            writer.write(String.format(format, counter, min) + "\n");
        }
        writer.close();
    }

    public static int solve(HashMap<Character, ArrayList<Character>> mapping, String start){
        int[][] dists = floydWarshall(mapping);

        int min = Integer.MAX_VALUE;
        for(int i = 'A';i<='Z';i++){
            int cur = 0;
            for(int j = 0;j<start.length();j++){
                if(dists[start.charAt(j)-'A'][i-'A'] != Integer.MAX_VALUE/3){
                    cur += dists[start.charAt(j)-'A'][i-'A'];
                }else{
                    cur = Integer.MAX_VALUE/3;
                    break;
                }
            }
            min = Math.min(min, cur);
        }
        return min;

    }
    public static int[][] floydWarshall(HashMap<Character, ArrayList<Character>> mapping){
        int[][] dists = new int[26][26];
        //time from a to get to b ([a][b])
        for(int i = 0;i<26;i++){
            Arrays.fill(dists[i], Integer.MAX_VALUE/3);
            dists[i][i] = 0;
        }

        for(int i = 0;i<26;i++){
            if(mapping.containsKey((char)('A'+i))){
                for(char a : mapping.get((char)('A'+i))){
                    dists[i][a-'A'] = 1;
                }
            }
        }

        for(int k = 0;k<26;k++){
            for(int i = 0;i<26;i++){
                for(int j = 0;j<26;j++){
                    if(dists[i][j] > dists[i][k] + dists[k][j]){
                        dists[i][j] = dists[i][k] + dists[k][j];
                    }
                }
            }
        }

        return dists;

    }

}
